import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.latera.aop_with_annot.MyClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class AspectTest {
	
	@Autowired
	ApplicationContext ac;
	
	@Test
	public void getSumTest() {
		MyClass mc = ac.getBean("myClass", MyClass.class);
		Assert.assertEquals(54, mc.getSum(2, 10));
	}
	
}
