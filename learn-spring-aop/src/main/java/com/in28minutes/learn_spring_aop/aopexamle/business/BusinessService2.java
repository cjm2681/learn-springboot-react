package com.in28minutes.learn_spring_aop.aopexamle.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28minutes.learn_spring_aop.aopexamle.data.DataService2;


@Service
public class BusinessService2 {
	
	private DataService2 dataService2;
	
	

	public BusinessService2(DataService2 dataService1) {
		this.dataService2 = dataService1;
	}



	public int calculateMin() {
		int[] data = dataService2.retrieveData();
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		throw new RuntimeException("Something Went Wrong");
		
		return Arrays.stream(data).min().orElse(0);
		
		
	}
	
}
