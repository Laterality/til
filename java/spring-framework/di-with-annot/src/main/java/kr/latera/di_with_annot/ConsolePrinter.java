package kr.latera.di_with_annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinter implements Printer {
	public void print(String message) {
		System.out.println(message);
	}
}
