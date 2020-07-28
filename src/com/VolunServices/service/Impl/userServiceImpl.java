package com.VolunServices.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.VolunServices.achieve.distinguishIp;
import com.VolunServices.mapper.UserMapper;
import com.VolunServices.pojo.UserExample;
import com.VolunServices.pojo.Userinfo;
import com.VolunServices.pojo.User;
import com.VolunServices.service.userInfoService;
import com.VolunServices.service.userService;

@Service
public class userServiceImpl implements userService {

	List<User> AllUser = new ArrayList<User>();
	@Autowired
	private UserMapper usermapper;
	
	@Autowired
	private userInfoService userInFoService;

	// 用户注册
	public int UserRegister(User newuser) {
		int flag = usermapper.insert(newuser);
		return flag;
	}
	
	//用户登录
	public User getByusernameAndPassword(String uname, String upassword) {
		
		   UserExample userExample = new UserExample();
		   userExample.createCriteria().andUnameEqualTo(uname).andUpasswordEqualTo(upassword);
		   System.out.println("1get" + userExample);
			List<User> result = (List<User>) usermapper.selectByExample(userExample);
			if (result.isEmpty())
				return null;
			System.out.println("111"+result.get(0));
			return result.get(0);//获取用户信息
		}

	// 注销用户
	public int UserLogout(int uid) {
		int flag = usermapper.deleteByPrimaryKey(uid);
		return flag;
	}

	// 修改登陆密码
	public int UpdaetPass(User u) {
		int flag = usermapper.updateByPrimaryKey(u);
		return flag;
	}

	  //用户登录(OK) 
	  public User UserLogin(User user) { 
		  
		 return usermapper.loginByname(user);
	}
	  
	// 全部用户(OK)
	public List<User> AllUser() {
		AllUser = usermapper.selectAll();
		return AllUser;
	}

	// 根据账号名查找是否存在
//	public int FindUserByName(String name) {
//		int flag = usermapper.selectByName(name);
//		return flag;
//	}
	@Override
	public User FindUserByName(String username) {
		 UserExample userExample = new UserExample();
		 userExample.createCriteria().andUnameEqualTo(username);
		 if(usermapper.selectByExample(userExample).isEmpty()) return null;
		 return usermapper.selectByExample(userExample).get(0);
	}

	// 根据名返回Id
	public int AccNameReId(String name) {
		return usermapper.selectByNameReId(name);
	}
	
	//查找不同身份的集合
	public List<User> FindByIdentity(int i) {
		return usermapper.selectIdentity(i);
	}

	//获取地理位置
	public String GetDiliweizhi(String ip) {
		String address = null;
		distinguishIp diliweizhi = new distinguishIp();	
		try{
			Object getaddress = distinguishIp.getaddress(ip);
			address = getaddress.toString();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return address;
	}

	// 修改登陆密码
	public int UpdatePass(int uid, String newpassword) {
		User user = usermapper.selectByPrimaryKey(uid);
		user.setUpassword(newpassword);		
		return usermapper.updateByPrimaryKey(user);
	}

	@Override
	public boolean loginList(String uname, String phone) {
		List<User> login = usermapper.loginList(uname,phone);        
		int i = login.size();        
		System.out.print(i);        
		return i != 0; 
	}

	@Override
	public User selectByPrimaryKey(int uid) {
		return usermapper.selectByPrimaryKey(uid);
	}

	@Override
	public void fillUserByUid(User user) {
		System.out.println(user.getUid());
		Userinfo userinfo = userInFoService.Persondetaild(user.getUid());
		System.out.println(userinfo.getSex());
		user.setUserinfor(userinfo);		
	}

	@Override
	public int ManagerPass(User user) {
		int flag = usermapper.ManagerPass(user);
		return flag;
	}

	@Override
	public String checkoldPasswordS(int uid) {
		String password = usermapper.checkoldPassword(uid);
		return password;
	}
	
	//重置密码
		public int UpUserPass(String uname, String newpassword) {
			User user = usermapper.selectByName(uname);
			user.setUpassword(newpassword);
			return usermapper.updateByUname(user);
		}

		//根据用户名查找
		public User FindByUname(String uname) {
			
			return usermapper.selectByName(uname);
		}

}
