package kr.latera.guestbook.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.latera.guestbook.dto.Guestbook;

@Repository
public class GuestbookDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);
	
	public GuestbookDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("guestbook")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Guestbook> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(GuestbookDaoSqls.SELECT_PAGING, params, rowMapper);
	}
	
	public Long insert(Guestbook guestbook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(GuestbookDaoSqls.DELETE_BY_ID, params);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(GuestbookDaoSqls.SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
