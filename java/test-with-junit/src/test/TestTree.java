package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import kr.latera.test_with_junit.Tree;

public class TestTree {
	
	@Test
	public void testTaste1() {
		Tree t = new Tree();
		Tree.Apple a = t.getApple();
		
		assertEquals("Good", a.getTaste());
	}
	
	@Test
	public void testTaste2() {
		Tree t = new Tree();
		Tree.Apple a = t.getApple();
		
		assertNotEquals("Bad", a.getTaste());
	}
	
	@Test
	public void testTaste3() {
		Tree t = new Tree();
		Tree.Apple a = t.getApple();
		
		assertEquals("Delicious", a.getTaste());
	}
}
