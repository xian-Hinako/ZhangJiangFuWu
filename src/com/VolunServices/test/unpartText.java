package com.VolunServices.test;

import org.springframework.context.ApplicationContext;

import com.VolunServices.pojo.Unpart;
import com.VolunServices.service.unpartService;
import com.application.GetApplicationC;

public class unpartText {
	
	public static void main(String[] args) {
		GetApplicationC app = new GetApplicationC();
		ApplicationContext getAC = app.GetAC();
		unpartService bean = (unpartService) getAC.getBean("unpartServiceImpl");
		Unpart un = new Unpart(20,2,1,0);
		int updateUnpart = bean.UpdateUnpart(un);
		System.out.println(updateUnpart);
		System.out.println(un);
	}
}
