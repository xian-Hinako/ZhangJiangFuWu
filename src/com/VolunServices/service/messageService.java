package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Message;

public interface messageService {
	
	List<Message> FindAllMessage();
	
	int AddMessage(Message m);
	
	int DeleteMessage(int mid);
	
	//�����û�id����
	List<Message> FindMessageByUid(int uid);
	
	//�������ݲ���
	List<Message> FindMessageByMess(String content);
	
	//����ɾ��
	boolean DeleteSelectMessageS(String _parameter);

}
