package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Userinfo;


public interface userInfoService {
	
	//查找全部
	List<Userinfo> AllUserInfo();
	
	//查找全部
	List<Userinfo> AllUserInfo(Userinfo userinfo);
	
	//修改用户信息
	int UpdateUserInfo(Userinfo ui);
	
	//增加用户
	int AddUserInfo(Userinfo ui);
	
	//查找用户个人信息
	List<Userinfo> findUserInfo(String uiname);
	
	//删除用户信息
	int DeleteUserInfo(int uiId);
	
	//根据Id查找个人信息
	Userinfo Persondetaild(int uiId);	
	
	//管理员注册
	int AddManager(Userinfo ui);
	
	//批量删除
    boolean DeleteSelectUserIn(String _parameter);
    
    //添加一个管理员
    int AddManagerInfo(Userinfo ui);
    
  //忘记密码后重置密码
  	boolean loginList(Userinfo userinfo);
	
}
