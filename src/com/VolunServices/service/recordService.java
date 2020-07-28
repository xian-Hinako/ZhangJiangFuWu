package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Record;

public interface recordService {
	
	List<Record> AllRecord();
	
	List<Record> SelByUsId(int uid);
	
	List<Record> SelByActId(int actid);
	
	//���ݷ���ʱ�����Ҵ��ڻ���ڸ�ʱ���ļ�¼
	List<Record> SelByDura(float sum);
	
	int AddRecord(Record re);
	
	int UpdateRecord(Record re);
	
	int DeleteRecord(int reId);
	
	//ͳ��ÿ��user��ʱ��
	Float CountDuration(int uid);
	
	//���ݻid�޸Ĺ��ڸû�����л
	int UpdateByActId(int actId);
	
	//����ɾ��
	boolean DeleteSelectRecordS(String _parameter);
	
	//������������
	Record selByParyKey(int recordid);
	
	//��������ܷ���ʱ��
	Float totaltimeS(int uid);
	
	//���Ҹ��˷����¼��ǰ4��
	List<Record> FindPreFour(int uid);

}
