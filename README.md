![나몰닭깃헙상단이미지](https://user-images.githubusercontent.com/117756400/216939133-6d703bcf-80ce-4939-ada5-a583af07185e.jpg)

<br /> <br />

## 🐔 나만 모른 닭
<div align=center>

***내 머리에 있는 거 뭐야? 나만 몰라?***  
”양세찬 게임” 혹은 “콜 마이 네임”으로 불리는 키워드 맞추기 게임!  
최대한 *헷갈리게 답변*하고 최대한 *날카롭게 질문*하세요!  
<br />
![나몰닭상단이미지](https://user-images.githubusercontent.com/117756400/216971099-fff770a8-8462-4ad0-91f1-64463703bf5f.png)  
</div>

```
런닝맨에 나온 양세찬 게임으로 유명한 [콜 마이 네임] 게임을 웹으로 구현했습니다.  
스무고개처럼 상대 플레이어에게 질문을 하면서 나의 키워드를 맞춰보세요!  
친구들과 함께 편하고 가볍게 즐길 수 있는 게임입니다.
```

<br /> <br />

## 🛠 기술 스택

### Backend Tech Stack  
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">  <img src="https://img.shields.io/badge/websocket-FFCD00?style=for-the-badge&logo=websocket&logoColor=white">  <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white">  <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
<br /> <br />

### Infrastructure  
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">  <img src="https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"> <br /> <img src="https://img.shields.io/badge/amazon ec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">  <img src="https://img.shields.io/badge/amazon s3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">  <img src="https://img.shields.io/badge/amazon rds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white">  <img src="https://img.shields.io/badge/amazon cloudfront-FF4F8B?style=for-the-badge&logo=amazonaws&logoColor=white">  <img src="https://img.shields.io/badge/amazon route53-7D929E?style=for-the-badge&logo=amazonaws&logoColor=white"> <br /> <img src="https://img.shields.io/badge/aws codedeploy-FF9E9F?style=for-the-badge&logo=amazonaws&logoColor=white">  <img src="https://img.shields.io/badge/github actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white">
<br /> <br />
  
### Team Collaboration Tool  
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">  <img src="https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white">  <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white">
<br />


<br /><br />

## 🔗 나만 모른 닭 서비스 및 노션
[🐔나만 모른 닭🐔](https://namoldak.com)
<br />
[🐔나만 모른 닭 노션🐔](https://colossal-chokeberry-fec.notion.site/39515b59c604426494e905a62410ce3b)

<br /> <br />

## 📢 주요 서비스 기능
<ul>
<li> 런닝맨의 양세찬 게임(aka. call my name 게임)을 온라인에서도 즐길 수 있게 구현하였습니닭🐔 </li>
<li> 텍스트 채팅뿐만 아니라 음성/화상 채팅으로도 서로 대화를 나누며 게임을 즐길 수 있습니닭🐔 </li>
<li> 게임도 하고 게시판을 이용해 다른 유저들과 소통도 할 수 있습니닭🐔 </li>
</ul>

<br /> <br />

## 📽 시연 영상
<div align=center>

![나몰닭gif16초](https://user-images.githubusercontent.com/117756400/216956662-5a0793e8-ab46-44b2-99bc-7c2c7d3f92e6.gif)
</div>

<br /> <br />

## ⚙️ 서비스 아키텍쳐
![나몰닭-아키텍쳐2](https://user-images.githubusercontent.com/117756400/216894689-8921deef-c813-42ca-a8f2-6e58f34fd4b8.jpg)

<br /> <br />

## 🪄 핵심 기술
- 실시간 채팅을 위한 Web Socket
  - 화상 및 음성 채팅을 위한 WebRTC
  - 다양한 브라우저 환경을 지원하기 위한 SockJS
  - pub/sub 기반의 편리한 웹소켓 관리를 위한 메세징 프로토콜 STOMP
- Refresh Token의 생명 주기 관리를 위한 서브 데이터베이스로의 Redis 사용
- 개발자 편의 및 생산성 증가를 위한 자동화 배포 CI/CD
- AWS CloudFront를 이용한 S3 이미지 엔드포인트 보안 강화
- Intersection-observer API를 사용한 댓글 무한 스크롤
- OAuth 2.0 소셜 로그인을 통한 편리한 접근성 제공

<br /> <br />

## 📝 기술적 의사 결정
<details>
<summary>기술적 의사 결정</summary>
<div markdown="1">

| 기술 | 도입 이유 | 후보군 | 의견 조율 및 기술 결정 |  
|:---:|---|---|---|
| WebRTC (Mesh) | 실시간 화상 및 음성 채팅 | Mesh / SFU / MCU | - 실시간성이 가장 낮고 중앙 서버에서 데이터 혼합 및 가공에 많은 비용이 요구되는 MCU는 제외하고 Mesh와 SFU 방식을 놓고 고민<br />- 서비스 특성 상, 한 게임룸의 최대 인원이 4명인 점을 고려했을 때 peer간의 직접 연결이 클라이언트에 부하를 심하게 주지 않을 것이라고 판단했고, 서버를 거치는 일 없이 바로 peer끼리 정보를 주고 받는 것이 실시간성이 중요한 게임 서비스에 적합하다고 판단 |
| Redis | Refresh Token을 저장하기 위한 DB 선정 | Redis / MySQL | - 일정 시간 이후 만료되어야 하는 Refresh Token이므로 기본적으로 데이터의 유효기간(time to live)을 지정할 수 있는 Redis에 저장하는 게 적합하다고 판단<br />- 토큰 생명 주기 관리에 용이한 Redis를 Refresh Token 전용 서브 DB로 선정 |
| Github Action & AWS CodeDeploy | 지속적 통합과 지속적 배포를 통한 업무 효율 상승을 위해 도입 | Jenkins /<br />Github Action / Travis CI | - 현재 프로젝트 관리를 깃허브를 통하여 진행하고 있고, 소규모 프로젝트이고 추가적인 설치 과정 없이 Github에서 제공하는 환경에서 CI 작업이 가능하기 때문에 Github Action을 사용하는 것이 용이할 거라 생각함<br />- 프로젝트 규모를 생각했을 때 초기 설정이 적고 편의성이 높아 리소스를 줄이는 방향으로 진행. 따라서 Github Action과 AWS에서 제공하는 Code Deploy를 이용하여 자동화 배포를 하기로 결정 |
| Refresh Token | 유저 정보 보안 | 클라이언트에 저장(local storage vs cookie) / 서버에 저장 | - 리프레시 토큰이 클라이언트에 노출된다면 리프레시 토큰의 장점인 보안적인 이점이 없다고 판단하였고, 액세스 토큰 만으로도 서버에 리프레시 발급 요청이 가능한 로직이기 때문에 서버에만 저장하는 방향으로 의견 조율<br />- 리프레시 토큰을 서버(Redis)에 저장하고, 액세스 토큰 만료 10분 전에 재발급 요청을 보내는 api를 액세스 토큰을 담아 요청하는 방식으로 구현함. |
| STOMP & SockJS | 텍스트 채팅 및 다양한 브라우저에서의 일관성 | Only WebSocket / SockJS + STOMP | - 여러 브라우저에서 동일한 기능을 안정적으로 제공할 수 있어야 하기에 SockJS를 사용하고, 여러 방을 생성하여 그 방마다의 채팅을 관리해야 하기 때문에 Topic을 구독함으로 별도의 세션 관리가 필요없는 STOMP를 사용해 채팅을 구현하는 것으로 의견 조율<br />- WebSocket Configuration에서 Endpoint에 SockJS를 사용할 수 있게 설정하고, 메시지 브로커를 통해 pub/sub 엔드포인트를 설정하여 url로 간단히 공급과 구독을 적용할 수 있게 구현함. 또한 대상 Topic(게임 방)을 구독한 사람들을 대상으로 게임 진행에 관련한 메세지를 공급하는 방식으로 구현 |
<div>
</details>
<br /> <br />

## ⚽ 트러블 슈팅
- S3 이미지 엔드포인트 노출
- 자동화 배포 Build 파일 실행 이슈
- Header에 있는 Refresh Token
- 동시성 제어를 위한 Pessimistic Lock

<br /> <br />

## 🗨️ User Feedback
1. 닉네임 변경
    - 기존에 닉네임을 cookie 에 담아 관리하고 있었는데 닉네임 변경 api를 호출하고 변경된 닉네임을 주기로 함  
2. 카메라 기본 상태 off로 설정
    - 각각의 유저 정보를 객체로서 저장하여 요소로 가지는 배열에 유저 객체를 처음 할당할 때 카메라 On/Off를 설정하는 프로퍼티의 값을 true에서 false로 변경 
3. 게임 종료 시 키워드 알림
    - 컴포넌트 최상단 scope에 키워드를 저장할 let 변수 선언 후 게임 시작 시 서버로부터 받아온 키워드 데이터를 해당 변수에 할당하여 게임종료시 해당 변수 사용하여 키워드 화면에 출력  
4. 커뮤니티 페이지 카테고리 설정 방식 변경
    - 카테고리의 경우 [자유게시판]과 [내가 쓴 피드백]은 drop down으로, [내가 쓴 게시판]의 경우엔 버튼으로 따로 구성되어있어서 불편하다는 피드백을 받음.  
    - 모든 카테고리를 drop down으로 변경  
5. 카카오톡 회원탈퇴 (서비스 연결 끊기)
    - 카카오 로그인 시 백엔드 서버에서 전달하는 토큰에 카카오 access token을 추가하고, 카카오톡 연결 끊기 api로 해당 토큰을 전송하여 서비스 연결 끊기 요청  
6. 버튼 중복 클릭 방지
    - debounce와 동일한 기능을 하는 커스텀 훅을 만들어서 버튼을 여러 번 눌렀을 때 특정 시간(0.3초)동안 액션이 없는 경우 함수가 호출되도록 변경  
7. 게임 플레이 시 효과음
    - howler.js 라이브러리를 사용하여 삽입한 src가 플레이되는 커스텀 훅을 만들어서 게임 중 효과음이 나오도록 변경  

<br /> <br />

## ⌛ 시간이 더 있었다면 도전했을 기술들
- 대용량 트래픽 처리
- 
<br /> <br />

## 🧑🏻‍💻 개발 기간 & 조원
✔️ 2022.12.30 - 2022.02.09
<br />
✔️ 멤버 이름 클릭 시, 해당 멤버의 깃허브를 방문하실 수 있습니다.
<br />
| [김아영](https://github.com/isladaisy) | [조소영](https://github.com/littlezero48) | [차이진](https://github.com/leejincha) | [홍윤재](https://github.com/PigletHong) |
|:---:|:---:|:---:|:---:|
| ![내캐릭터](https://user-images.githubusercontent.com/117756400/216781592-6934710c-1e4a-43dd-aeb9-2117b5fed5f4.png) | ![소영님캐릭터](https://user-images.githubusercontent.com/117756400/216781599-b9559a95-20d8-4b76-90a4-12151263a203.png) | ![이진님캐릭터](https://user-images.githubusercontent.com/117756400/216889730-6221074f-7875-46c4-96c0-a516a7262ff9.png) | ![윤재님캐릭터](https://user-images.githubusercontent.com/117756400/216895789-d84c1ac7-16ec-42e8-ac42-d0b5a50ae9d0.png) |
| SPRING | SPRING | SPRING | SPRING |

<br /> <br /> <br />
