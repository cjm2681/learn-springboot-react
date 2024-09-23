package com.in28minutus.mockito.mockito_demo.business;

public class SomeBusinesslmpl {
	
	private DataService dataService;
	
	
	
	public SomeBusinesslmpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}



	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value > greatestValue)
				greatestValue = value;
		}
		return greatestValue;
	}
	
}

interface DataService {
	int[] retrieveAllData();
}