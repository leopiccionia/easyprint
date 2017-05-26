package io.github.leopiccionia.easyprint.test;

import io.github.leopiccionia.easyprint.EasyString;
import junit.framework.*;

public class EasyStringTest extends TestCase{
	
	public void testVarargs(){
		EasyString s = new EasyString(2, " + ", 3, " = ", 2 + 3);
		assertEquals(s.toString(), "2 + 3 = 5");
	}
	
	public void testArrays(){
		Object params[] = {"Hello", ", ", "world", "!"};
		EasyString greeting = new EasyString(params);
		assertEquals(greeting.toString(), "Hello, world!");
	}
	
	public void testNulls(){
		EasyString s = new EasyString("an", null, "ed");
		assertEquals(s.toString(), "annulled");
	}
	
	public void testConcatArray(){
		Integer arr[] = {1, 2, 3, 4};
		EasyString s = EasyString.concat(" < ", (Object[])arr);
		assertEquals(s.toString(), "1 < 2 < 3 < 4");
	}
	
	public void testConcartVarargs(){
		EasyString s = EasyString.concat(" < ", 1, 2, 3, 4);
		assertEquals(s.toString(), "1 < 2 < 3 < 4");
	}
	
	public void testConcatEmpty(){
		Integer arr[] = {};
		EasyString s = EasyString.concat(" < ", (Object[])arr);
		assertEquals(s.toString(), "");
	}

	public void testAppendTwoStrings(){
		String foo = "foo";
		String bar = "bar";
		EasyString s = new EasyString(foo).append(bar);
		assertEquals(s.toString(), "foobar");
	}
	
	public void testAppendTwoEasyStrings(){
		EasyString foo = new EasyString("foo");
		EasyString bar = new EasyString("bar");
		assertEquals(foo.append(bar).toString(), "foobar");
	}
	
	public void testAppendStringToEasyString(){
		EasyString foo = new EasyString("foo");
		String bar = "bar";
		assertEquals(foo.append(bar).toString(), "foobar");
	}
	
	public void testAppendMutability(){
		EasyString foo = new EasyString("foo");
		EasyString bar = foo.append("bar");
		assertSame(foo, bar);
	}
	
	public void testRepeat(){
		EasyString ellipsis = EasyString.repeat(".", 3);
		assertEquals(ellipsis.toString(), "...");
	}
}
