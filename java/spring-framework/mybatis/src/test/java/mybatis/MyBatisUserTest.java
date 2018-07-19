package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import kr.latera.mybatis.dto.UserDto;
import kr.latera.mybatis.mapper.UserMapper; 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/beans.xml")
public class MyBatisUserTest {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void configTest() {
		
		// MyBatis 3.0 이전 방식, session 빈을 가져와서 네임스페이스 이름으로 호출
//		SqlSession session = context.getBean("sqlSession", SqlSession.class);
//		UserDto dto = session.selectOne("userNS.selectUserById", "jn3222");
		
		// Mapper 인터페이스를 활용하는 방식
		UserDto dto = userMapper.selectUserById("jn3222");
		System.out.println(dto);
		Assert.assertEquals("john", dto.getName());
	}
}
