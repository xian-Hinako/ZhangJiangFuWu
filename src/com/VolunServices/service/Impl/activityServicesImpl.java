package com.VolunServices.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.VolunServices.mapper.ActivityMapper;
import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Page;
import com.VolunServices.pojo.Page10;
import com.VolunServices.service.activityService;

@Service
public class activityServicesImpl implements activityService{
	
	@Autowired
	private ActivityMapper actmapper;

	//查找全部活动
	public List<Activity> AllActivity() {
		List<Activity> ActivityAll = actmapper.sellectAll();
		return ActivityAll;
	}
	

	//增加活动
	public int AddActivity(Activity a) {
		int flag = actmapper.insert(a);
		return flag;
	}

	//删除活动
	public int DeleteActivity(int aid) {
		int flag = actmapper.deleteByPrimaryKey(aid);
		return flag;
	}

	//根据活动名称模糊查找活动
	public List<Activity> FindActivity(String aname) {
		List<Activity> ActByName = actmapper.sellectByName(aname);
		return ActByName;
	}

	//修改活动信息
	public int UpdateAct(Activity a) {
		int flag = actmapper.updateByPrimaryKey(a);
		return flag;
	}

	//根据aid查找
	public Activity SelectByAid(int aid) {
		System.out.println(aid);
		Activity activity = actmapper.selectByPrimaryKey(aid);
		return activity;
	}
	
	//批量删除
	public boolean DeleteSelectActivityS(String _parameter) {
		boolean flag = false;
		int fla = actmapper.deleteSelectActivity(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}
	
	  //分页
	//分页查询全部
	@Override
    public List<Activity> list(Page page) {
        // TODO Auto-generated method stub
        return actmapper.list(page);
    }
 
    @Override
    public int total() {
        return actmapper.selectCount();
    }

    
	@Override
	public List<Activity> FindPreNice() {
		List<Activity> selectPreNice = actmapper.selectPreNice();
		return selectPreNice;
	}
	



}
