package com.in28minutes.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");

	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");

	}
	
	@Test
	void test() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}

	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@AfterEach
	void AfterEach() {
		System.out.println("AfterEach");

	}
	
	@AfterAll
	static void AfterAll() {
		System.out.println("AfterAll");

	}


}
