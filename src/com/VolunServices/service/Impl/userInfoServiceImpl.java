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

	//�޸��û�������Ϣ
	public int UpdateUserInfo(Userinfo ui) {
		int flag = usInmapper.updateByPrimaryKey(ui);
		return flag;
	}

	@Override
	public int AddManagerInfo(Userinfo ui) {
		int flag = usInmapper.insert1(ui);
		return flag;
	}

	//�������ֲ���
	public List<Userinfo> findUserInfo(String uiname) {
		List<Userinfo> sellusInByNaLi = usInmapper.sellectusInByName(uiname);
		return sellusInByNaLi;
	}

	//ɾ�������û���Ϣ
	public int DeleteUserInfo(int uiId) {
		int flag = usInmapper.deleteByPrimaryKey(uiId);
		return flag;
	}

	//����Id���Ҹ�����Ϣ
	public Userinfo Persondetaild(int uiId) {
		Userinfo persondetaild = usInmapper.selectByPrimaryKey(uiId);
		return persondetaild;
	}

	//����Աע��
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
	
	@Override//���һ���û�
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
