# mybatis

ORM 프레임워크 MyBatis를 사용하는 예제입니다.

3.0 버전부터 지원되는 Mapper 인터페이스를 사용하여 DB로부터 데이터를 가져옵니다.

테이블 생성에 사용한 SQL문은 다음과 같습니다.

```sql
create table user(
	userid varchar(30) not null,
    name varchar(100) not null,
    gender varchar(10),
    city varchar(30),
    primary key(userid)
);
```