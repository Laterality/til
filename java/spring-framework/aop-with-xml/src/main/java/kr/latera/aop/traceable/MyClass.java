package kr.latera.aop.traceable;

public class MyClass {
	
	public int getSum(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		
		return sum;
	}
	
	@Override
	public String toString() {
		return "Hello, World";
	}

}
