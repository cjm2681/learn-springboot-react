package com.in28minutus.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinesslmplStupTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		DataService dataServiceStup = new DataServiceStup();
		SomeBusinesslmpl businessImpl = new SomeBusinesslmpl(dataServiceStup);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}

}


class DataServiceStup implements DataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {25, 15, 5};
	}
	
}