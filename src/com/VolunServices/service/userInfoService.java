package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Userinfo;


public interface userInfoService {
	
	//����ȫ��
	List<Userinfo> AllUserInfo();
	
	//����ȫ��
	List<Userinfo> AllUserInfo(Userinfo userinfo);
	
	//�޸��û���Ϣ
	int UpdateUserInfo(Userinfo ui);
	
	//�����û�
	int AddUserInfo(Userinfo ui);
	
	//�����û�������Ϣ
	List<Userinfo> findUserInfo(String uiname);
	
	//ɾ���û���Ϣ
	int DeleteUserInfo(int uiId);
	
	//����Id���Ҹ�����Ϣ
	Userinfo Persondetaild(int uiId);	
	
	//����Աע��
	int AddManager(Userinfo ui);
	
	//����ɾ��
    boolean DeleteSelectUserIn(String _parameter);
    
    //���һ������Ա
    int AddManagerInfo(Userinfo ui);
    
  //�����������������
  	boolean loginList(Userinfo userinfo);
	
}
