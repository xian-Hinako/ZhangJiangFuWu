package com.VolunServices.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Page;
import com.VolunServices.pojo.Page10;


public interface activityService {
	
	List<Activity> AllActivity();
	
	int AddActivity(Activity a);
	
	int DeleteActivity(int aid);
	
	List<Activity> FindActivity(String aname);
	
	int UpdateAct(Activity a);
	
	Activity SelectByAid(int aid);
	
	//批量删除
    boolean DeleteSelectActivityS(String _parameter);
    
     //分页6查询全部
    List<Activity> list(Page page);
    
       
    //记录总数
    int total();
    
    //查询前9条记录
    List<Activity> FindPreNice();

}
