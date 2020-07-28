package com.VolunServices.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.VolunServices.mapper.UnpartMapper;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.service.unpartService;

@Service
@Transactional
public class unpartServiceImpl implements unpartService{
	
	@Autowired
	private UnpartMapper unpamapper;

	//ȫ��δ���м�¼
	public List<Unpart> AllUnpart() {
		List<Unpart> AllUnpa = unpamapper.selectAllUnpa();
		return AllUnpa;
	}

	//���ӻId����
	public List<Unpart> SellectByActId(int actId) {
		List<Unpart> selByActLis = unpamapper.selectbyActId(actId);
		return selByActLis;
	}

	//����δ���м�¼
	public int AddUnpart(Unpart up) {
		int flag = unpamapper.insert(up);
		return flag;
	}

	//�޸�δ���м�¼
	public int UpdateUnpart(Unpart up) {
		int flag = unpamapper.updateByPrimaryKey(up);
		return flag;
	}

	//ɾ��δ���м�¼
	public int DeleteUnpart(int upId) {
		int flag = unpamapper.deleteByPrimaryKey(upId);
		return flag;
	}

	//���ݻIdɾ������������(��ͨ������Ա�����)
	public int DeleteByActId(int actId) {
		int flag = unpamapper.deleteByActId(actId);
		return flag;
	}

	//����uid��aid����unpartId
	public int selectByUidAndAid(Unpart un) {
		int unpartId = unpamapper.selectByUidAndActId(un);
		return unpartId;
	}

	//����actIdͳ���ж����˱����û
	public int countNumberByActId(int actId) {
		int number = unpamapper.countUnpartIdByActId(actId);
		return number;
	}

	//����ɾ��
	public boolean DeleteSelectUnpartS(String _parameter) {
		boolean flag = false;
		int fla = unpamapper.deleteSelectUnpart(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}

	//������������
	public Unpart FindUnpartByunpartid(int unpartid) {
		Unpart selectByPrimaryKey = unpamapper.selectByPrimaryKey(unpartid);
		return selectByPrimaryKey;
	}

	//־Ը�߲����Լ��ı�����¼
	public List<Unpart> FindUnpartByUidS(int uid) {
		List<Unpart> findUnpartByUid = unpamapper.FindUnpartByUid(uid);
		return findUnpartByUid;
	}

	//����uid���Ҹ��˵�ǰ������¼
	public List<Unpart> selUnpartByuidPreTwoS(int uid) {
		List<Unpart> selUnpartByuidPreTwo = unpamapper.selUnpartByuidPreTwo(uid);
		return selUnpartByuidPreTwo;
	}
	
}
