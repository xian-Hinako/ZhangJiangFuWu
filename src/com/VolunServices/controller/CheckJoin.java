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
		System.out.println("进来CheckJoinTime了");		
		System.out.println("前台传来的aid为"+aid);
		boolean f = true;
		int flag = 5;
		User userssion = (User) session.getAttribute("usersession");   //获取登录的用户
		System.out.println("session里面的"+userssion);
		Integer uid = userssion.getUid();   //登录的用户的uid
		Activity selectByAid = actservices.SelectByAid(aid);   //要报名的活动
		
		//查看活动的名额余量
		int countNumberByActId = unpartservices.countNumberByActId(aid);   //计算每个活动报名的人数
		int surplus = 0;
		if(selectByAid.getNumber() != null){
			surplus = selectByAid.getNumber() - countNumberByActId;  //将总人数-已报名的人数
		}		
		if(surplus != 0){
			Timestamp time = selectByAid.getDay();    //要报名的活动的时间
			//判断当前系统时间与活动时间，查看是否过期，若过期不允许
			Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String strtime = sdf.format(d);
	        Timestamp systemtime = Timestamp.valueOf(strtime);
	      //当time>systemtime 即未过期
	        if(time.after(systemtime)){       	
	        	List<Unpart> findUnpartByUid = unpartservices.FindUnpartByUidS(uid);  //用户已经报名的活动
	    		//如果list为空,则允许报名
	    		if(findUnpartByUid == null){
	    			Unpart up = new Unpart();
	    			up.setUid(uid);
	    			up.setActid(aid);
	    			up.setStatus(selectByAid.getStatus());
	    			unpartservices.AddUnpart(up);
	    		}else{
	    			//根据要报名的活动与已经报名的活动的时间一一判断，看时间是否冲突
	    			for (Unpart unpart : findUnpartByUid) {
	    				Integer actid = unpart.getActid();   //获取每个活动的aid
	    				if(actid == aid){
	    					flag = 4;
	    					System.out.println("你已经报名该活动!");
	    				}
	    				Activity selectByAid2 = actservices.SelectByAid(actid);  //获取已经报名的活动信息
	    				Timestamp time2 = selectByAid2.getDay();  //每个活动的时间
	    				long s = (time.getTime() - time2.getTime())/(1000*60);  //计算相隔多少分钟
	    				float hour = (float) (s/60);  //计算相隔多少个小时
	    				//hour>要报名的活动的时长就允许报名
	    				if(hour > selectByAid.getDuration()){
	    					f = true;
	    				}else{    //只要有一个不符都不允许即时间冲突
	    					if(flag != 4){
	    						flag = 0;
	    					}  					
	    					System.out.println("你已报名的某活动的时间与该活动的时间有冲突!");
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
	    					System.out.println("报名成功!");
	    				}else{
	    					flag = 2;
	    					System.out.println("报名失败!");		
	    				}			
	    			}   		
	        }else{
	        	f = false;
	        	flag = 3;
	        	System.out.println("该活动已经失效!");
	        }	
		}
		else{
			flag = 6;
		}		
        return flag;
		
	}
	
	@RequestMapping("CheckJoinTime2")
	public String CheckJoinTime2C(@RequestBody int aid,HttpSession session,Model m){
		System.out.println("进来CheckJoinTime了");
		System.out.println("前台传来的aid为"+aid);
		int obj = 5;    
		boolean f = true;
		User userssion = (User) session.getAttribute("usersession");   //获取登录的用户
		System.out.println("session里面的"+userssion);
		Integer uid = userssion.getUid();   //登录的用户的uid
		Activity selectByAid = actservices.SelectByAid(aid);   //要报名的活动
		Timestamp time = selectByAid.getDay();    //要报名的活动的时间
		//判断当前系统时间与活动时间，查看是否过期，若过期不允许
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strtime = sdf.format(d);
        Timestamp systemtime = Timestamp.valueOf(strtime);
         //当time>systemtime 即未过期
        if(time.after(systemtime)){
        	List<Unpart> findUnpartByUid = unpartservices.FindUnpartByUidS(uid);  //用户已经报名的活动
    		//如果list为空,则允许报名
    		if(findUnpartByUid == null){
    			Unpart up = new Unpart();
    			up.setUid(uid);
    			up.setActid(aid);
    			up.setStatus(selectByAid.getStatus());
    			unpartservices.AddUnpart(up);
    		}else{
    			//根据要报名的活动与已经报名的活动的时间一一判断，看时间是否冲突
    			for (Unpart unpart : findUnpartByUid) {
    				Integer actid = unpart.getActid();   //获取每个活动的aid
    				if(selectByAid.getAid() == actid){
    					System.out.println("你已报名该活动!");
    					obj = 4;
    					f = false;
    					break;
    				}else{
    					Activity selectByAid2 = actservices.SelectByAid(actid);  //获取已经报名的活动信息
    				    Timestamp time2 = selectByAid2.getDay();  //每个活动的时间
    				    long s = (time.getTime() - time2.getTime())/(1000*60);  //计算相隔多少分钟
    				    float hour = (float) (s/60);  //计算相隔多少个小时
    				    //hour>要报名的活动的时长就允许报名
    				    if(hour > selectByAid.getDuration()){
    					   f = true;
    				    }else{    //只要有一个不符都不允许
    					   f = false;
    					   break;
    				    }
    				}   				
    			}
    		}	
    		if(f == false && obj !=4){
    			System.out.println("你已报名的某活动的时间与该活动的时间有冲突!");
//    			attr.addFlashAttribute("message", "你已报名的某活动的时间与该活动的时间有冲突!");
    			obj = 0;
    		}else{
    				Unpart up = new Unpart();
    				up.setUid(uid);
    				up.setActid(aid);
    				up.setStatus(selectByAid.getStatus());
    				int addUnpart = unpartservices.AddUnpart(up);
    				if(addUnpart == 1){
    					System.out.println("报名成功!");
//    					redirectAttributes.addFlashAttribute("message", "报名成功!");
    					obj = 1;

    				}else{
    					System.out.println("报名失败!");	
//    					attr.addFlashAttribute("message", "报名失败!");
    					obj = 2;
    				}			
    		}
        }else{
        	f = false;
        	System.out.println("该活动已经失效!");
//        	attr.addFlashAttribute("message", "该活动已经失效!");
        	obj = 3;
        }										
//		return obj;
        return "redirect:/listActivity.do";
	}
	
	
}
