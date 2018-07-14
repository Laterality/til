package kr.latera.test_with_junit;

public class Tree {
	
	public Apple getApple() {
		return new Apple();
	}
	
	public class Apple {
		private String taste;
		
		public Apple() { 
			taste = "Good";
		}
		
		public String getTaste() {
			return taste;
		}
	}
}
