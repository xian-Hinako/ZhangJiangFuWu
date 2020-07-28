package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Message;

public interface messageService {
	
	List<Message> FindAllMessage();
	
	int AddMessage(Message m);
	
	int DeleteMessage(int mid);
	
	//根据用户id查找
	List<Message> FindMessageByUid(int uid);
	
	//根据内容查找
	List<Message> FindMessageByMess(String content);
	
	//批量删除
	boolean DeleteSelectMessageS(String _parameter);

}
