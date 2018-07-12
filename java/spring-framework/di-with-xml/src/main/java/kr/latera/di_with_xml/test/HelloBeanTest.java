package kr.latera.di_with_xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.latera.di_with_xml.Hello;
import kr.latera.di_with_xml.Printer;

public class HelloBeanTest {

	public static void main(String[] args) {
		// 1. IoC 컨테이너 생성
		ApplicationContext ac = new GenericXmlApplicationContext("config/beans.xml");
		
		// 2. Hello Bean 가져오기
		Hello hello = (Hello)ac.getBean("hello");
		System.out.println(hello.sayHello());
		hello.print();
		
		// 3. StringPrinter Bean 가져오기
		Printer printer = ac.getBean("consolePrinter", Printer.class);
		System.out.println(printer.toString());
		
		// 빈을 다시 가져와서 첫 번째 빈과 비교
		// 스프링에서 빈 객체를 싱글턴으로 관리하므로 true가 출력 
		Hello hello2 = ac.getBean("hello", Hello.class);
		System.out.println(hello == hello2);
	}

}
