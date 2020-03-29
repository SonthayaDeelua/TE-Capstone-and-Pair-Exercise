package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {

	KataStringCalculator calculator = new KataStringCalculator();
	
	@Test
	public void test_for_empty_string_returns_0() {
		String empty = "";
		int x = 0;
		assertEquals(x, calculator.add(empty));
	}
	
	@Test
	public void test_for_1_when_string_1_is_input() {
		String one = "1";
		int x = 1;
		assertEquals(x, calculator.add(one));
	}
	@Test
	public void test_add_1_and_2_given_string_1_2() {
		String oneTwo = "1,2";
		int answer = 3;
		assertEquals(answer, calculator.add(oneTwo));
	}
	@Test
	public void test_add_5_7_12_returns_24() {
		String input = "5,7,12";
		int answer = 24;
		assertEquals(answer, calculator.add(input));
	}
	@Test
	public void test_add_6_2_1_8_returns_17() {
		String input = "6,2,1,8";
		int answer = 17;
		assertEquals(answer, calculator.add(input));
	}
	@Test
	public void test_add_string_5_n_3_2_returns_10() {
		String input = "5\n3,2";
		int answer = 10;
		assertEquals(answer, calculator.add(input));
	}
	@Test
	public void test_add_string_3_n_5_n_2_4_returns_14() {
		String input = "3\n5\n2,4";
		int answer = 14;
		assertEquals(answer, calculator.add(input));
	}
	@Test
	public void test_add_string_input_semicolon_n_1_2_returns_3() {
		String input = "//;\n1;2";
		int answer = 3;
		assertEquals(answer, calculator.add(input));
	}
	
	
}
