package com.VolunServices.service;

import java.util.List;

import com.VolunServices.pojo.Unpart;

public interface unpartService {
	
	//全部未进行的记录
	List<Unpart> AllUnpart();
	
	//根据活动名查找的记录
	List<Unpart> SellectByActId(int actId);
	
	//增加记录
	int AddUnpart(Unpart up);
	
	//修改未进行的记录
	int UpdateUnpart(Unpart up);
	
	//删除未进行的记录
	int DeleteUnpart(int upId);
	
	//根据活动Id删除报名名单
	int DeleteByActId(int actId);
	
	//根据uid和aid查找unpartId
	int selectByUidAndAid(Unpart un);
	
	//根据actId统计有多少人报名该活动
	int countNumberByActId(int actId);
	
	//批量删除
	boolean DeleteSelectUnpartS(String _parameter);
	
	//根据主键查找
	Unpart FindUnpartByunpartid(int unpartid);
	
	//志愿者查找自己的报名记录
	List<Unpart> FindUnpartByUidS(int uid);
	
	//根据uid查找个人的前两条记录
	List<Unpart> selUnpartByuidPreTwoS(int uid);

}
