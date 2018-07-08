# geustbook

부스트코스 Full stack web developer 과정의 방명록 예제([링크](https://www.edwith.org/boostcourse-web/lecture/16772/))를 구현한 프로젝트입니다.

## 구현 설명

* http://localhost:8080/guestbook 으로 접속 시 index.jsp로 응답
* index.jsp는 페이지를 /list 로 리다이렉트
* /list에서는 작성된 방명록을 보여주고, 방명록을 작성할 수 있음
* 방명록 작성과 삭제시에는 DB에 로그를 남김

구현에 사용된 테이블은 총 2개로, 방명록을 관리하기 위한 `guestbook` 테이블과 로그를 관리하기 위한 `log` 테이블입니다. 작성에 사용한 DDL은 다음과 같습니다. 

```sql
create table guestbook (
	id bigint(20) unsigned not null auto_increment,
    name varchar(255) not null,
    content text,
    regdate datetime,
    primary key(id)
);
    
create table log (
	id bigint(20) unsigned not null auto_increment,
    ip varchar(255) not null,
    method varchar(10) not null,
    regdate datetime,
    primary key(id)
);
```

요청을 받아 응답하는 컨트롤러와 실질적인 비즈니스 로직이 처리되는 서비스로 구성 
요소를 나눔으로써 이러한 계층 구조의 아키텍처가 설계/구현상에서 어떤 이점이 있는지를 확이하는 프로젝트입니다.