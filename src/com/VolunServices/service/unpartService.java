package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Unpart;

public interface unpartService {
	
	//ȫ��δ���еļ�¼
	List<Unpart> AllUnpart();
	
	//���ݻ�����ҵļ�¼
	List<Unpart> SellectByActId(int actId);
	
	//���Ӽ�¼
	int AddUnpart(Unpart up);
	
	//�޸�δ���еļ�¼
	int UpdateUnpart(Unpart up);
	
	//ɾ��δ���еļ�¼
	int DeleteUnpart(int upId);
	
	//���ݻIdɾ����������
	int DeleteByActId(int actId);
	
	//����uid��aid����unpartId
	int selectByUidAndAid(Unpart un);
	
	//����actIdͳ���ж����˱����û
	int countNumberByActId(int actId);
	
	//����ɾ��
	boolean DeleteSelectUnpartS(String _parameter);
	
	//������������
	Unpart FindUnpartByunpartid(int unpartid);
	
	//־Ը�߲����Լ��ı�����¼
	List<Unpart> FindUnpartByUidS(int uid);
	
	//����uid���Ҹ��˵�ǰ������¼
	List<Unpart> selUnpartByuidPreTwoS(int uid);

}
