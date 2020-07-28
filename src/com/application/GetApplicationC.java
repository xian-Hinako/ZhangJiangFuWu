package com.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetApplicationC {
	
	private ApplicationContext ac;
	public ApplicationContext GetAC(){
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
