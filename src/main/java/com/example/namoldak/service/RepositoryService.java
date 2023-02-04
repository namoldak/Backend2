package com.example.namoldak.service;

import com.example.namoldak.domain.*;
import com.example.namoldak.repository.*;
import com.example.namoldak.util.GlobalResponse.CustomException;
import com.example.namoldak.util.GlobalResponse.code.StatusCode;
import com.example.namoldak.util.s3.AwsS3Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.namoldak.util.GlobalResponse.code.StatusCode.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class RepositoryService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final GameRoomRepository gameRoomRepository;
    private final GameRoomAttendeeRepository gameRoomAttendeeRepository;
    private final KeywordRepository keywordRepository;
    private final GameStartSetRepository gameStartSetRepository;
    private final RewardReposiroty rewardReposiroty;
    private final ImageFileRepository imageFileRepository;
    private final AwsS3Service awsS3Service;
    private ObjectMapper objectMapper = new ObjectMapper();


    //////////////TODO 댓글 관련
    // 댓글 ID로 댓글 찾아오기
    public Comment findCommentById(Long commentId){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(StatusCode.COMMENT_NOT_FOUND)
        );
        return comment;
    }

    // 포스트 객체로 모든 댓글 리스트형으로 찾아오기
    public List<Comment> findAllCommentByPost(Post post){
        List<Comment> comments = commentRepository.findByPost(post);
        return comments;
    }

    // 댓글 저장
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    // 댓글 삭제
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    //////////////TODO 포스트 관련
    // 포스트 저장하기
    public Post savePost(Post post){
        postRepository.save(post);
        return post;
    }
    // 포스트 삭제하기
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    // 모든 포스트 찾아오기
    public List<Post> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }
    // 포스트 ID로 포스트 찾아오기
    public Post findPostById(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(StatusCode.POST_NOT_FOUND)
        );
        return post;
    }
    // 카테고리별 모든 포스트 불러오기
    public List<Post> findAllByCategory(String category) {
        List<Post> posts = postRepository.findAllByCategory(category);
        return posts;
    }
    public List<Post> findAllByMemberAndCategory(Member member, String category) {
        List<Post> posts = postRepository.findAllByMemberAndCategory(member, category);
        return posts;
    }
    // 페이징 처리한 자유게시판 불러오기
    public Page<Post> findAllByCategory(Pageable pageable, String category){
        Page<Post> postList = postRepository.findAllByCategory(pageable, category);
        return postList;
    }
    // 페이징 처리한 내가쓴피드백 불러오기
    public Page<Post> findAllByMemberAndCategoryOrderByCreatedAtDesc(Pageable pageable, Member member, String category){
        Page<Post> postList = postRepository.findAllByMemberAndCategoryOrderByCreatedAtDesc(pageable, member, category);
        return postList;
    }
    // 게시글 키워드 검색
    public Page<Post> findByKeyword(Pageable pageable, String category, String keyword) {
        Page<Post> posts = postRepository.findAllByCategoryContainingAndTitleContaining(pageable, category, keyword);
        return posts;
    }

    //////////////TODO 이미지 관련
    // 이미지 파일 전체 불러오기

    //////////////TODO GameStartSet Map <-> String
    public Map<String, String> getMapFromStr(String keywordToMember) {
        try {
            Map<String, String> map = objectMapper.readValue(keywordToMember, new TypeReference<Map<String, String>>() {});
            return map;
        } catch (JsonProcessingException e) {
            throw new CustomException(JSON_PROCESS_FAILED);
        }
    }

    public String getStrFromMap(Map<String, String> keywordToMember) {
        try {
            String str = objectMapper.writeValueAsString(keywordToMember);
            return str;
        } catch (JsonProcessingException e) {
            throw new CustomException(JSON_PROCESS_FAILED);
        }
    }

    //////////////TODO Member 관련
    // Email로 데이터 검증
    public boolean MemberDuplicateByEmail(String email){
        return memberRepository.existsByEmail(email);
    }

    // Nickname으로 데이터 검증
    public boolean MemberDuplicateByNickname(String nickname){
        return memberRepository.existsByNickname(nickname);
    }

    // 닉네임으로 Member 객체 갖고오기
    public Member findMemberByNickname(String nickname) {
        return memberRepository.findByNickname(nickname).orElseThrow(
                ()-> new CustomException(NOT_FOUND_MEMBER)
        );
    }

    // 이메일로 Member 객체 찾아오기
    public Member findMemberByEmail(String email){
        return memberRepository.findByEmail(email).orElseThrow(
                ()-> new CustomException(NOT_FOUND_MEMBER)
        );
    }

    // 이메일로 Member 객체 찾아오기
    public boolean existMemberByEmail(String email){
        return memberRepository.existsByEmail(email);
    }

    // 카카오 아이디로 Member 객체 찾아오기
    public Member findMemberByKakaoId(Long kakaoId){
        return memberRepository.findByKakaoId(kakaoId).orElseThrow(
                ()-> new CustomException(NOT_FOUND_MEMBER)
        );
    }

    // 카카오 아이디로 존재여부
    public boolean existMemberByKakaoId(Long kakaoId){
        return memberRepository.existsByKakaoId(kakaoId);
    }

    // 멤버 ID로 Member 객체 찾아오기
    public Member findMemberById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
                ()-> new CustomException(NOT_FOUND_MEMBER)
        );
    }

    // 멤버 객체로 데이터 삭제하기
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }

    // 멤버 객체 저장하기
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    // 회원탈퇴하며 모든 정보를 정리하기
    public void removeMemberInfo(Member member) {
        if(commentRepository.existsByMember(member)){
            commentRepository.deleteAllByMember(member);
        }
        // 게임룸 참여 여부 확인
        if(gameRoomAttendeeRepository.existsByMember(member)){
            gameRoomAttendeeRepository.deleteAllByMember(member);
        }
        // 이미지파일 여부 확인
        if(imageFileRepository.existsByMember(member)){

            List<ImageFile> imageFileList = imageFileRepository.findAllByMember(member);
            for (ImageFile imageFile : imageFileList) {
                String path = imageFile.getPath();
                String filename = path.substring(49);
                awsS3Service.deleteFile(filename);
            }

            imageFileRepository.deleteAllByMember(member);
        }
        // 글 여부 확인
        if(postRepository.existsByMember(member)){
            postRepository.deleteAllByMember(member);
        }
        // 리워드 여부 확인
        if(rewardReposiroty.existsByMember(member)){
            rewardReposiroty.deleteAllByMember(member);
        }
        // 회원 삭제
        deleteMember(member);
    }

    //////////////TODO GameRoom 관련
    // 게임룸 Id로 객체 찾아오기
    public GameRoom findGameRoomByRoomId(Long roomId) {
        return gameRoomRepository.findByGameRoomId(roomId).orElseThrow(
                ()-> new CustomException(NOT_EXIST_ROOMS)
        );
    }
    public GameRoom findGameRoomByRoomIdLock(Long roomId) {
        return gameRoomRepository.findByGameRoomId2(roomId).orElseThrow(
                ()-> new CustomException(NOT_EXIST_ROOMS)
        );
    }

    // 페이징 처리해서 모든 게임방 갖고 오기
    public Page<GameRoom> findGameRoomByPageable(Pageable pageable) {
        Page<GameRoom> gameRoomPage = gameRoomRepository.findAll(pageable);
        return gameRoomPage;
    }

    // 특정 키워드로 검색해서 게임방 가져오기
    public Page<GameRoom> findGameRoomByContainingKeyword(Pageable pageable, String keyword) {
        Page<GameRoom> gameRoomPage = gameRoomRepository.findByGameRoomNameContaining(pageable, keyword);
        return gameRoomPage;
    }

    // 게임방 리스트 형식으로 갖고 오기
    public List<GameRoom> findAllGameRoomList() {
        List<GameRoom> gameRoomList = gameRoomRepository.findAll();
        return gameRoomList;
    }

    // 게임방 저장하기
    public void saveGameRoom(GameRoom gameRoom) {
        gameRoomRepository.save(gameRoom);
    }

    // 게임방 삭제하기
    public void deleteGameRoom(GameRoom gameRoom) {
        gameRoomRepository.delete(gameRoom);
    }

    //////////////TODO GameRoomAttendee 관련
    // 멤버 객체로 참가자 정보 조회
    public GameRoomAttendee findAttendeeByMember(Member member) {
        GameRoomAttendee gameRoomAttendee = gameRoomAttendeeRepository.findByMember(member).orElseThrow(
                ()-> new CustomException(NOT_FOUND_ATTENDEE)
        );
        return gameRoomAttendee;
    }
    // 게임룸 객체로 참가자 찾아오기
    public List<GameRoomAttendee> findAttendeeByGameRoom(GameRoom gameRoom) {
        List<GameRoomAttendee> gameRoomAttendeeList = gameRoomAttendeeRepository.findByGameRoom(gameRoom);
        return gameRoomAttendeeList;
    }

    public List<GameRoomAttendee> findAttendeeByRoomId(Long roomId) {
        return gameRoomAttendeeRepository.findByGameRoom_GameRoomId(roomId);
    }

    // 멤버 Id로 참가자 객체 가져오기
    public GameRoomAttendee findAttendeeByMemberId(Long memberId) {
        return gameRoomAttendeeRepository.findById(memberId).orElseThrow(
                ()-> new CustomException(NOT_FOUND_ATTENDEE)
        );
    }

    // 참가자 저장
    public void saveGameRoomAttendee(GameRoomAttendee gameRoomAttendee) {
        gameRoomAttendeeRepository.save(gameRoomAttendee);
    }

    // 참가자 삭제
    public void deleteGameRoomAttendee(GameRoomAttendee gameRoomAttendee) {
        gameRoomAttendeeRepository.delete(gameRoomAttendee);
    }

    //////////////TODO Keywrod 관련
    // 키워드 랜덤으로 4개 가지고 오기
    public List<Keyword> findTop4KeywordByCategory(String category) {
        List<Keyword> keywordList = keywordRepository.findTop4ByCategory(category);
        return keywordList;
    }

    // 키워드 랜덤으로 3개 가지고 오기
    public List<Keyword> findTop3KeywordByCategory(String category) {
        List<Keyword> keywordList = keywordRepository.findTop3ByCategory(category);
        return keywordList;
    }

    //////////////TODO GameStartSet 관련
    // GameStartSet 저장하기
    public void saveGameStartSet(GameStartSet gameStartSet) {
        gameStartSetRepository.save(gameStartSet);
    }

    // RoomId로 GameStartSet 객체 찾아오기
    public GameStartSet findGameStartSetByRoomId(Long roomId) {
        return gameStartSetRepository.findByRoomId(roomId).orElseThrow(
                ()-> new CustomException(GAME_SET_NOT_FOUND)
        );
    }

    // GameStartSet 객체로 DB에서 삭제하기
    public void deleteGameStartSetByRoomId(Long roomId) {
        gameStartSetRepository.deleteByRoomId(roomId);
    }

    //////////////TODO Reward 관련
    // 리워드 저장하기
    public void saveReward(Reward reward) {
        rewardReposiroty.save(reward);
    }

    public List<Reward> findAllReward(Member member) {
        List<Reward> rewardList = rewardReposiroty.findByMember(member);
        return rewardList;
    }


}
