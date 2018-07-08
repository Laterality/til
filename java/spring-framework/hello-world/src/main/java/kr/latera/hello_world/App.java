package kr.latera.hello_world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Greeter greeter = (Greeter)ac.getBean("greeter");
		greeter.setName("World");
		greeter.greet();
	}

}
