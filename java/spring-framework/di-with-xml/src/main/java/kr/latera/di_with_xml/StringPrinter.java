package kr.latera.di_with_xml;

public class StringPrinter implements Printer{
	private StringBuffer buffer = new StringBuffer(); 
	
	public void print(String message) {
		buffer.append(message);
	}
	
	@Override
	public String toString() {
		return buffer.toString();
	}
}
