# Spring Fremework 방명록 예제

부스트코스 Full stack web developer 과정의 방명록 예제([링크](https://www.edwith.org/boostcourse-web/lecture/16772/))를 구현한 프로젝트입니다. 각 소스 코드 내에 설명을 주석으로 삽입하였습니다.

## 요구사항

* http://localhost:8080/guestbook 으로 접속
* index 페이지로 연결되고, index 페이지에서 list 페이지로 리다이렉트
* list 페이지에서 방명록을 보여주고, 새 방명록을 작성할 수 있음
* 방명록 작성 내용은 /write 에서 처리
* 방명록은 페이지로 나뉘어 있는데, 한 페이지에 최대 5개 까지의 방명록이 보여짐
* 또한 방명록 추가/삭제 시에는 요청한 클라이언트의 ip와 요청 내용(insert/delete)을 기록

## 구현 설명

db는 방명록 저장을 위한 `guestbook` 테이블과 요청 기록 저장을 위한 `log`테이블로 나눠 생성하였고, 각 테이블의 생성문은 다음과 같습니다.

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

Controller에서 요청을 받아 처리하고, 여러 Controller에서 중복 될 수 있는 공통된 비즈니스 로직(방명록 조회, 추가, 삭제 등)은 별도의 Service로 분리하여 Controller에서 공동으로 사용할 수 있도록 합니다.

결과적으로 요청의 처리는 다음과 같이 이루어집니다.

클라이언트 → |서버| → DispatcherServlet → Controller → Service

서비스에서 로직을 처리한 뒤에 컨트롤러가 이를 받아 클라이언트에게 돌려주는 형태가 됩니다.

본 구현에서는 Service의 역할을 하기 위한 `GuestbookService` 인터페이스를 정의하고, 이를 구현하는 `GuestbookServiceImpl` 클래스에서 구체적인 로직을 작성했습니다.

## P.S.

처음 Spring framework 버전을 `4.3.5.RELEASE`로 했을 때에 `RowMapper`클래스를 찾을 수 없는 현상이 발생해서 `4.3.7.RELEASE`로 변경했는데, 이번에는 `queryForObject(String, Map, Class<T>)`가 resolve되지 않는 현상이 생겨 지금의 버전으로 변경되었습니다. 

# Conclusion

요청을 처리하는 단계를 컨트롤러와 서비스계층으로 나눈 형태로 웹 
애플리케이션을 작성해봤습니다. 여러 컨트롤러에서 공통으로 사용하는 로직들을 
서비스로 분리하여 작성에 걸리는 시간이나 오류 발생 여지도 줄이고,
서비스에 작성되는 로직이 변경되는 경우에 대처하기도 쉽다는 장점을 가지게 됩니다.