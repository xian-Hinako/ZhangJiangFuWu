package com.VolunServices.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.VolunServices.pojo.User;

public interface userService {
	//�û�ע��
	int UserRegister(User newuser);
	
	//ע���û�
	int UserLogout(int uid);
	
	//�޸ĵ�½����
//	int UpdaetPass(User u);
	int UpdatePass(int uid, String newpassword);
	int UpUserPass(String uname, String newpassword);
	
	//�������룬��������
	boolean loginList(String uname, String phone);
	
	//�û���¼
	User UserLogin(User u);
	User getByusernameAndPassword(String uname, String upassword);
	
	//����ȫ���û�
	List<User> AllUser();
	
	User FindUserByName(String name);
	User selectByPrimaryKey(int uid);
	
	int AccNameReId(String name);
	
	//����user��userinfo���ѯ
	void fillUserByUid(User user);
	
	List<User> FindByIdentity(int i);
	
	//��ȡ����λ��
	String GetDiliweizhi(String ip);
	
	//��˹���Ա
	int ManagerPass(User user);
	
	//���������Ƿ���ȷ
	String checkoldPasswordS(int uid);
	
	//�����û�������
	User FindByUname(String uname);
	
}
