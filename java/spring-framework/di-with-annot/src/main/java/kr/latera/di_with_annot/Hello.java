package kr.latera.di_with_annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Hello {
	
	@Value("Spring")
	private String name;
	
	@Autowired
	@Qualifier("stringPrinter")
	private Printer printer;
	
	public String sayHello() { return "Hello " + name; }
	public void print() { this.printer.print(sayHello()); }
}
