package com.VolunServices.test;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.VolunServices.pojo.User;
import com.VolunServices.service.userService;
import com.VolunServices.service.Impl.userServiceImpl;
import com.application.GetApplicationC;

public class usertest {
	public static void main(String[] args) {
		GetApplicationC app = new GetApplicationC();
		ApplicationContext getAC = app.GetAC();
		userService uservice = (userService) getAC.getBean("userServiceImpl");
//		User u = new User("a123","a123");
//		System.out.println("µÇÂ¼·½·¨  "+uservice.UserLogin(u));
		
		List<User> allUser = uservice.AllUser();
		for (User user : allUser) {
			System.out.println(user);
		}

		
	}

}
