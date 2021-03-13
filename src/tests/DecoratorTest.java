package tests;

import decorator.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecoratorTest {

	@Test
	void test() {
		Jersey jersey = new ChelseaJersey();
		String expected = "Chelsea";
		String actual = jersey.getDescription();
		assertEquals(expected, actual);
		
		Jersey jersey2 = new ArsenalJersey();
		jersey2 = new NameCustomization(jersey2);
		String expected2 = "Arsenal, Name";
		String actual2 = jersey2.getDescription();
		assertEquals(expected2, actual2);
		
		Jersey jersey3 = new LiverpoolJersey();
		jersey3 = new NumberCustomization(jersey3);
		String expected3 = "Liverpool, Number";
		String actual3 = jersey3.getDescription();
		assertEquals(expected3, actual3);
		
		Jersey jersey4 = new ManchesterCityJersey();
		jersey4 = new NameCustomization(jersey4);
		jersey4 = new NumberCustomization(jersey4);
		String expected4 = "Manchester City, Name, Number";
		String actual4 = jersey4.getDescription();
		assertEquals(expected4, actual4);
	}

}
