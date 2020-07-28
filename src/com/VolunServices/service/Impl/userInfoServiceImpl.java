package com.VolunServices.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VolunServices.mapper.UserinfoMapper;
import com.VolunServices.pojo.Userinfo;
import com.VolunServices.pojo.UserinfoExample;
import com.VolunServices.service.userInfoService;

@Service
public class userInfoServiceImpl implements userInfoService{

	@Autowired
	private UserinfoMapper usInmapper;
	
	@Override
	public List<Userinfo> AllUserInfo() {
		List<Userinfo> AllUsInnList = usInmapper.sellectAllUsIn();
		return AllUsInnList;
	}

	//修改用户个人信息
	public int UpdateUserInfo(Userinfo ui) {
		int flag = usInmapper.updateByPrimaryKey(ui);
		return flag;
	}

	@Override
	public int AddManagerInfo(Userinfo ui) {
		int flag = usInmapper.insert1(ui);
		return flag;
	}

	//根据名字查找
	public List<Userinfo> findUserInfo(String uiname) {
		List<Userinfo> sellusInByNaLi = usInmapper.sellectusInByName(uiname);
		return sellusInByNaLi;
	}

	//删除个人用户信息
	public int DeleteUserInfo(int uiId) {
		int flag = usInmapper.deleteByPrimaryKey(uiId);
		return flag;
	}

	//根据Id查找个人信息
	public Userinfo Persondetaild(int uiId) {
		Userinfo persondetaild = usInmapper.selectByPrimaryKey(uiId);
		return persondetaild;
	}

	//管理员注册
	public int AddManager(Userinfo ui) {
		return usInmapper.insertmanager(ui);
	}

	@Override
	public List<Userinfo> AllUserInfo(Userinfo userinfo) {
		UserinfoExample example = new UserinfoExample();
        return usInmapper.selectByExample(example);
	}

	@Override
	public boolean DeleteSelectUserIn(String _parameter) {
		boolean flag = false;
		  int fla = usInmapper.deleteSelectUserIn(_parameter);
		  if(fla == 1){
		   flag = true;
		  }
		  return flag;
	}
	
	@Override//添加一个用户
	public int AddUserInfo(Userinfo ui) {
		int flag = usInmapper.insert(ui);
		return flag;
	}
	
	public boolean loginList(Userinfo userinfo) {        
		List<Userinfo> login = usInmapper.loginList(userinfo);       
		int i = login.size();        
		System.out.print(i);        
		return i != 0;    
	}

}
