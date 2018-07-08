package kr.latera.hello_world;

public class Greeter {
	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public void greet() {
		System.out.println("Hello, " + name + "!");
	}
}
