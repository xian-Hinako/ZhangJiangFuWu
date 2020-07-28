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
	
	//����ɾ��
    boolean DeleteSelectActivityS(String _parameter);
    
     //��ҳ6��ѯȫ��
    List<Activity> list(Page page);
    
       
    //��¼����
    int total();
    
    //��ѯǰ9����¼
    List<Activity> FindPreNice();

}
