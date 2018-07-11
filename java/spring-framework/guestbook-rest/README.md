# guestbook-rest

`@RestController`에 대해 공부하기 위해 기존의 guestbook 프로젝트에 Api 컨트롤러를 추가로 작성하였습니다.

## 구현 설명

guestbook 프로젝트와의 차이는 config 패키지의 `GuestbookApiController` 클래스를 추가로 작성한 부분으로, 앞서 pom.xml에 jackson 라이브러리를 추가함으로써 Spring에서 요청/응답 메시지 변환을 위한 MessageConvertor로 jackson 라이브러리를 사용합니다. 기존의 컨트롤러와는 달리 뷰를 통해 응답하는 형태가 아니라 처리 결과로 응답할 데이터만을 MessageConvertor로 변환하여 전송합니다.