package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Record;

public interface recordService {
	
	List<Record> AllRecord();
	
	List<Record> SelByUsId(int uid);
	
	List<Record> SelByActId(int actid);
	
	//根据服务时长查找大于或等于该时长的记录
	List<Record> SelByDura(float sum);
	
	int AddRecord(Record re);
	
	int UpdateRecord(Record re);
	
	int DeleteRecord(int reId);
	
	//统计每个user的时长
	Float CountDuration(int uid);
	
	//根据活动id修改关于该活动的所有活动
	int UpdateByActId(int actId);
	
	//批量删除
	boolean DeleteSelectRecordS(String _parameter);
	
	//根据主键查找
	Record selByParyKey(int recordid);
	
	//计算个人总服务时长
	Float totaltimeS(int uid);
	
	//查找个人服务记录的前4条
	List<Record> FindPreFour(int uid);

}
