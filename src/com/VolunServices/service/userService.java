package com.VolunServices.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.VolunServices.pojo.User;

public interface userService {
	//用户注册
	int UserRegister(User newuser);
	
	//注销用户
	int UserLogout(int uid);
	
	//修改登陆密码
//	int UpdaetPass(User u);
	int UpdatePass(int uid, String newpassword);
	int UpUserPass(String uname, String newpassword);
	
	//忘记密码，重置密码
	boolean loginList(String uname, String phone);
	
	//用户登录
	User UserLogin(User u);
	User getByusernameAndPassword(String uname, String upassword);
	
	//查找全部用户
	List<User> AllUser();
	
	User FindUserByName(String name);
	User selectByPrimaryKey(int uid);
	
	int AccNameReId(String name);
	
	//连接user和userinfo表查询
	void fillUserByUid(User user);
	
	List<User> FindByIdentity(int i);
	
	//获取地理位置
	String GetDiliweizhi(String ip);
	
	//审核管理员
	int ManagerPass(User user);
	
	//检查旧密码是否正确
	String checkoldPasswordS(int uid);
	
	//根据用户名查找
	User FindByUname(String uname);
	
}
