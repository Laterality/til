import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.latera.di_with_annot.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {Hello.class})
public class HelloBeanJUnitStringTest {
	
	// 1. IoC 컨테이너 생성
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void test1() {
		// 2. Hello Bean 가져오기
		Hello hello = (Hello)applicationContext.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
	}
	
	@Test
	public void test2() {
		// 빈을 다시 가져와서 첫 번째 빈과 비교
		// 스프링에서 빈 객체를 싱글턴으로 관리하므로 true가 출력
		Hello hello = (Hello)applicationContext.getBean("hello");
		Hello hello2 = applicationContext.getBean("hello", Hello.class);
		assertSame(hello, hello2);
	}
}
