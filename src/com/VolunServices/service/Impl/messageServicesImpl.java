package com.VolunServices.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VolunServices.mapper.MessageMapper;
import com.VolunServices.pojo.Message;
import com.VolunServices.service.messageService;

@Service
public class messageServicesImpl implements messageService{
	
	@Autowired
	private MessageMapper messagemapper;

	//查找全部评论
	public List<Message> FindAllMessage() {
		List<Message> selectAllMess = messagemapper.selectAllMess();
		return selectAllMess;
	}
	
	//增加评论
	public int AddMessage(Message m) {
		int flag = messagemapper.insert(m);
		return flag;
	}

	//删除评论
	public int DeleteMessage(int mid) {
		int flag = messagemapper.deleteByPrimaryKey(mid);
		return flag;
	}

	//根据uid查找评论
	public List<Message> FindMessageByUid(int uid) {
		List<Message> selectMessByUid = messagemapper.selectMessByUid(uid);
		return selectMessByUid;
	}

	//根据评论内容查找评论
	public List<Message> FindMessageByMess(String content) {
		List<Message> selectMessByCont = messagemapper.selectMessByCont(content);
		return selectMessByCont;
	}

	//批量删除
	public boolean DeleteSelectMessageS(String _parameter) {
		boolean flag = false;
		int fla = messagemapper.deleteSelectMessage(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}



}
