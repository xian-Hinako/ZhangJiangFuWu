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

	//全部未进行记录
	public List<Unpart> AllUnpart() {
		List<Unpart> AllUnpa = unpamapper.selectAllUnpa();
		return AllUnpa;
	}

	//更加活动Id查找
	public List<Unpart> SellectByActId(int actId) {
		List<Unpart> selByActLis = unpamapper.selectbyActId(actId);
		return selByActLis;
	}

	//增加未进行记录
	public int AddUnpart(Unpart up) {
		int flag = unpamapper.insert(up);
		return flag;
	}

	//修改未进行记录
	public int UpdateUnpart(Unpart up) {
		int flag = unpamapper.updateByPrimaryKey(up);
		return flag;
	}

	//删除未进行记录
	public int DeleteUnpart(int upId) {
		int flag = unpamapper.deleteByPrimaryKey(upId);
		return flag;
	}

	//根据活动Id删除报名的名单(即通过管理员的审核)
	public int DeleteByActId(int actId) {
		int flag = unpamapper.deleteByActId(actId);
		return flag;
	}

	//根据uid和aid查找unpartId
	public int selectByUidAndAid(Unpart un) {
		int unpartId = unpamapper.selectByUidAndActId(un);
		return unpartId;
	}

	//根据actId统计有多少人报名该活动
	public int countNumberByActId(int actId) {
		int number = unpamapper.countUnpartIdByActId(actId);
		return number;
	}

	//批量删除
	public boolean DeleteSelectUnpartS(String _parameter) {
		boolean flag = false;
		int fla = unpamapper.deleteSelectUnpart(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}

	//根据主键查找
	public Unpart FindUnpartByunpartid(int unpartid) {
		Unpart selectByPrimaryKey = unpamapper.selectByPrimaryKey(unpartid);
		return selectByPrimaryKey;
	}

	//志愿者查找自己的报名记录
	public List<Unpart> FindUnpartByUidS(int uid) {
		List<Unpart> findUnpartByUid = unpamapper.FindUnpartByUid(uid);
		return findUnpartByUid;
	}

	//根据uid查找个人的前两条记录
	public List<Unpart> selUnpartByuidPreTwoS(int uid) {
		List<Unpart> selUnpartByuidPreTwo = unpamapper.selUnpartByuidPreTwo(uid);
		return selUnpartByuidPreTwo;
	}
	
}
