package com.VolunServices.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.User;
import com.VolunServices.service.activityService;
import com.VolunServices.service.unpartService;

@SessionAttributes("usersession")
@Controller
public class CheckJoin {
	
	@Autowired
	private activityService actservices;
	
	@Autowired
	private unpartService unpartservices;
		
	@RequestMapping("CheckJoinTime")
	@ResponseBody
	public int CheckJoinTimeC(@RequestParam("aid")int aid,HttpSession session,Model m,HttpServletResponse response){
		System.out.println("����CheckJoinTime��");		
		System.out.println("ǰ̨������aidΪ"+aid);
		boolean f = true;
		int flag = 5;
		User userssion = (User) session.getAttribute("usersession");   //��ȡ��¼���û�
		System.out.println("session�����"+userssion);
		Integer uid = userssion.getUid();   //��¼���û���uid
		Activity selectByAid = actservices.SelectByAid(aid);   //Ҫ�����Ļ
		
		//�鿴�����������
		int countNumberByActId = unpartservices.countNumberByActId(aid);   //����ÿ�������������
		int surplus = 0;
		if(selectByAid.getNumber() != null){
			surplus = selectByAid.getNumber() - countNumberByActId;  //��������-�ѱ���������
		}		
		if(surplus != 0){
			Timestamp time = selectByAid.getDay();    //Ҫ�����Ļ��ʱ��
			//�жϵ�ǰϵͳʱ����ʱ�䣬�鿴�Ƿ���ڣ������ڲ�����
			Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String strtime = sdf.format(d);
	        Timestamp systemtime = Timestamp.valueOf(strtime);
	      //��time>systemtime ��δ����
	        if(time.after(systemtime)){       	
	        	List<Unpart> findUnpartByUid = unpartservices.FindUnpartByUidS(uid);  //�û��Ѿ������Ļ
	    		//���listΪ��,��������
	    		if(findUnpartByUid == null){
	    			Unpart up = new Unpart();
	    			up.setUid(uid);
	    			up.setActid(aid);
	    			up.setStatus(selectByAid.getStatus());
	    			unpartservices.AddUnpart(up);
	    		}else{
	    			//����Ҫ�����Ļ���Ѿ������Ļ��ʱ��һһ�жϣ���ʱ���Ƿ��ͻ
	    			for (Unpart unpart : findUnpartByUid) {
	    				Integer actid = unpart.getActid();   //��ȡÿ�����aid
	    				if(actid == aid){
	    					flag = 4;
	    					System.out.println("���Ѿ������û!");
	    				}
	    				Activity selectByAid2 = actservices.SelectByAid(actid);  //��ȡ�Ѿ������Ļ��Ϣ
	    				Timestamp time2 = selectByAid2.getDay();  //ÿ�����ʱ��
	    				long s = (time.getTime() - time2.getTime())/(1000*60);  //����������ٷ���
	    				float hour = (float) (s/60);  //����������ٸ�Сʱ
	    				//hour>Ҫ�����Ļ��ʱ����������
	    				if(hour > selectByAid.getDuration()){
	    					f = true;
	    				}else{    //ֻҪ��һ��������������ʱ���ͻ
	    					if(flag != 4){
	    						flag = 0;
	    					}  					
	    					System.out.println("���ѱ�����ĳ���ʱ����û��ʱ���г�ͻ!");
	    					f = false;
	    					break;
	    				}
	    			}
	    		}	
	    		if(f != false){
	    				Unpart up = new Unpart();
	    				up.setUid(uid);
	    				up.setActid(aid);
	    				up.setStatus(selectByAid.getStatus());
	    				int addUnpart = unpartservices.AddUnpart(up);
	    				if(addUnpart == 1){
	    					flag = 1;
	    					System.out.println("�����ɹ�!");
	    				}else{
	    					flag = 2;
	    					System.out.println("����ʧ��!");		
	    				}			
	    			}   		
	        }else{
	        	f = false;
	        	flag = 3;
	        	System.out.println("�û�Ѿ�ʧЧ!");
	        }	
		}
		else{
			flag = 6;
		}		
        return flag;
		
	}
	
	@RequestMapping("CheckJoinTime2")
	public String CheckJoinTime2C(@RequestBody int aid,HttpSession session,Model m){
		System.out.println("����CheckJoinTime��");
		System.out.println("ǰ̨������aidΪ"+aid);
		int obj = 5;    
		boolean f = true;
		User userssion = (User) session.getAttribute("usersession");   //��ȡ��¼���û�
		System.out.println("session�����"+userssion);
		Integer uid = userssion.getUid();   //��¼���û���uid
		Activity selectByAid = actservices.SelectByAid(aid);   //Ҫ�����Ļ
		Timestamp time = selectByAid.getDay();    //Ҫ�����Ļ��ʱ��
		//�жϵ�ǰϵͳʱ����ʱ�䣬�鿴�Ƿ���ڣ������ڲ�����
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strtime = sdf.format(d);
        Timestamp systemtime = Timestamp.valueOf(strtime);
         //��time>systemtime ��δ����
        if(time.after(systemtime)){
        	List<Unpart> findUnpartByUid = unpartservices.FindUnpartByUidS(uid);  //�û��Ѿ������Ļ
    		//���listΪ��,��������
    		if(findUnpartByUid == null){
    			Unpart up = new Unpart();
    			up.setUid(uid);
    			up.setActid(aid);
    			up.setStatus(selectByAid.getStatus());
    			unpartservices.AddUnpart(up);
    		}else{
    			//����Ҫ�����Ļ���Ѿ������Ļ��ʱ��һһ�жϣ���ʱ���Ƿ��ͻ
    			for (Unpart unpart : findUnpartByUid) {
    				Integer actid = unpart.getActid();   //��ȡÿ�����aid
    				if(selectByAid.getAid() == actid){
    					System.out.println("���ѱ����û!");
    					obj = 4;
    					f = false;
    					break;
    				}else{
    					Activity selectByAid2 = actservices.SelectByAid(actid);  //��ȡ�Ѿ������Ļ��Ϣ
    				    Timestamp time2 = selectByAid2.getDay();  //ÿ�����ʱ��
    				    long s = (time.getTime() - time2.getTime())/(1000*60);  //����������ٷ���
    				    float hour = (float) (s/60);  //����������ٸ�Сʱ
    				    //hour>Ҫ�����Ļ��ʱ����������
    				    if(hour > selectByAid.getDuration()){
    					   f = true;
    				    }else{    //ֻҪ��һ��������������
    					   f = false;
    					   break;
    				    }
    				}   				
    			}
    		}	
    		if(f == false && obj !=4){
    			System.out.println("���ѱ�����ĳ���ʱ����û��ʱ���г�ͻ!");
//    			attr.addFlashAttribute("message", "���ѱ�����ĳ���ʱ����û��ʱ���г�ͻ!");
    			obj = 0;
    		}else{
    				Unpart up = new Unpart();
    				up.setUid(uid);
    				up.setActid(aid);
    				up.setStatus(selectByAid.getStatus());
    				int addUnpart = unpartservices.AddUnpart(up);
    				if(addUnpart == 1){
    					System.out.println("�����ɹ�!");
//    					redirectAttributes.addFlashAttribute("message", "�����ɹ�!");
    					obj = 1;

    				}else{
    					System.out.println("����ʧ��!");	
//    					attr.addFlashAttribute("message", "����ʧ��!");
    					obj = 2;
    				}			
    		}
        }else{
        	f = false;
        	System.out.println("�û�Ѿ�ʧЧ!");
//        	attr.addFlashAttribute("message", "�û�Ѿ�ʧЧ!");
        	obj = 3;
        }										
//		return obj;
        return "redirect:/listActivity.do";
	}
	
	
}
