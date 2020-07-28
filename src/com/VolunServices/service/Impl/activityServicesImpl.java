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

	//����ȫ���
	public List<Activity> AllActivity() {
		List<Activity> ActivityAll = actmapper.sellectAll();
		return ActivityAll;
	}
	

	//���ӻ
	public int AddActivity(Activity a) {
		int flag = actmapper.insert(a);
		return flag;
	}

	//ɾ���
	public int DeleteActivity(int aid) {
		int flag = actmapper.deleteByPrimaryKey(aid);
		return flag;
	}

	//���ݻ����ģ�����һ
	public List<Activity> FindActivity(String aname) {
		List<Activity> ActByName = actmapper.sellectByName(aname);
		return ActByName;
	}

	//�޸Ļ��Ϣ
	public int UpdateAct(Activity a) {
		int flag = actmapper.updateByPrimaryKey(a);
		return flag;
	}

	//����aid����
	public Activity SelectByAid(int aid) {
		System.out.println(aid);
		Activity activity = actmapper.selectByPrimaryKey(aid);
		return activity;
	}
	
	//����ɾ��
	public boolean DeleteSelectActivityS(String _parameter) {
		boolean flag = false;
		int fla = actmapper.deleteSelectActivity(_parameter);
		if(fla == 1){
			flag = true;
		}
		return flag;
	}
	
	  //��ҳ
	//��ҳ��ѯȫ��
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
