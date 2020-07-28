package com.VolunServices.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.VolunServices.pojo.Activity;
import com.VolunServices.service.activityService;
import com.application.GetApplicationC;

public class activitytest {
	public static void main(String[] args) {
		GetApplicationC app = new GetApplicationC();
		ApplicationContext getAC = app.GetAC();
		activityService bean = (activityService) getAC.getBean("activityServicesImpl");
//		List<Activity> allActivity = bean.AllActivity();
//		for (Activity activity : allActivity) {
//			System.out.println(activity);
//		}
		Activity selectByAid = bean.SelectByAid(3);
		System.out.println(selectByAid);
	}

}
