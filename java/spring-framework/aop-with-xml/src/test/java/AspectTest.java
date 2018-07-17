import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.latera.aop.traceable.MyClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class AspectTest {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void testAspect() {
		MyClass c = applicationContext.getBean("myClass", MyClass.class);
		assertEquals(54, c.getSum(2, 10));
	}
	
}
