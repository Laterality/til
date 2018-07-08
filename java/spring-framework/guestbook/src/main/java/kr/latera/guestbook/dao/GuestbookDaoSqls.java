package kr.latera.guestbook.dao;

public class GuestbookDaoSqls {
	public static final String SELECT_PAGING = "select id, name, content, regdate from guestbook order by id desc limit :start, :limit";
	public static final String DELETE_BY_ID = "delete from guestbook where id=:id";
	public static final String SELECT_COUNT = "select count(*) from guestbook";
}
