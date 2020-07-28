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

	//����ȫ������
	public List<Message> FindAllMessage() {
		List<Message> selectAllMess = messagemapper.selectAllMess();
		return selectAllMess;
	}
	
	//��������
	public int AddMessage(Message m) {
		int flag = messagemapper.insert(m);
		return flag;
	}

	//ɾ������
	public int DeleteMessage(int mid) {
		int flag = messagemapper.deleteByPrimaryKey(mid);
		return flag;
	}

	//����uid��������
	public List<Message> FindMessageByUid(int uid) {
		List<Message> selectMessByUid = messagemapper.selectMessByUid(uid);
		return selectMessByUid;
	}

	//�����������ݲ�������
	public List<Message> FindMessageByMess(String content) {
		List<Message> selectMessByCont = messagemapper.selectMessByCont(content);
		return selectMessByCont;
	}

	//����ɾ��
	public boolean DeleteSelectMessageS(String _parameter) {
		boolean flag = false;
		int fla = messagemapper.deleteSelectMessage(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}



}
