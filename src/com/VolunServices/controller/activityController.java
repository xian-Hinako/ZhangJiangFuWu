package com.VolunServices.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Page;
import com.VolunServices.pojo.Page10;
import com.VolunServices.pojo.User;
import com.VolunServices.service.activityService;
import com.VolunServices.service.unpartService;
import com.VolunServices.tools.transData;

@SessionAttributes("usersession") 
@Controller
public class activityController {
	
	@Autowired
	private activityService actservices;
	
	@Autowired
	private unpartService unpartservices;
	
	//首页
//	@RequestMapping("SomeActivity")
//	public String ListAllActivity(Model m){
//		List<Activity> allActivity = actservices.AllActivity();
//		m.addAttribute("allActivity", allActivity);
//		return "frame";
//	}
	
	//管理员看到的所有活动信息
	@RequestMapping("AllActivity")
	public String ListAllActivityC(Model m){
		List<Activity> allActivity = actservices.AllActivity();	
		int allActivitysize = allActivity.size();  //记录条数
		m.addAttribute("allActivity", allActivity);	
		m.addAttribute("allActivitysize", allActivitysize);
		return "base/AllActivity";
	}
	
	//新增发布
	@RequestMapping("AddActivity")
	@ResponseBody
	public String AddActivityC(@RequestBody Activity activity,HttpServletRequest request){
		boolean f = false;
		String obj = null;
//		String day = request.getParameter("day");
//		Timestamp time = Timestamp.valueOf(day);
//		activity.setDay(time);
		int flag = actservices.AddActivity(activity);
		if(flag == 1){
			f = true;
		}
		obj = f+"";
		System.out.println("发布活动"+flag);
//		return "redirect:/AllActivity.do";
		return obj;
	}
	

	//根据活动名称查找
	@RequestMapping("FindActivityByActName")
	public String FindActivityByActNameC(String actname,Model m){
		List<Activity> allActivity = actservices.FindActivity(actname);
		int allActivitysize = allActivity.size();    //记录总数
		m.addAttribute("allActivity", allActivity);
		m.addAttribute("allActivitysize", allActivitysize);
		return "base/AllActivity";
	}
	
//	//志愿者看到的活动信息
//	@RequestMapping("VolunViewAllACtivity")
//	public String VolunViewAllACtivityC(Model m){
//		List<Activity> VallActivity = actservices.AllActivity();		
//		for (Activity activity : VallActivity) {
//			int countNumberByActId = unpartservices.countNumberByActId(activity.getAid());   //计算每个活动报名的人数
//			int surplus = activity.getNumber() - countNumberByActId;  //将总人数-已报名的人数
//			activity.setNumber(surplus);    //将余量赋给number字段    
//		}
//	    m.addAttribute("VallActivity", VallActivity);
////		return "Volunteer/VolunActivity";   //志愿活动的页面
//	    return "redirect:VoulunPage.do";
//	}
	
	//志愿者分页功能
	@RequestMapping("listActivity")
    public ModelAndView listCategory(Page page) throws NullPointerException{   	
        ModelAndView mav = new ModelAndView();
      //获取系统当前时间 判断活动是否过期从而是否显示报名键
//      	Date d = new Date(0);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String strtime = sdf.format(d);
//        Timestamp time = Timestamp.valueOf(strtime);
        List<Activity> cs= actservices.list(page);
        for (Activity activity : cs) {
        	int countNumberByActId = unpartservices.countNumberByActId(activity.getAid());   //计算每个活动报名的人数
//			int surplus = activity.getNumber() - countNumberByActId;  //将总人数-已报名的人数
        	int surplus = 0;
			if(activity.getNumber() != null){
			     surplus = activity.getNumber() - countNumberByActId;  //将总人数-已报名的人数
			}
			activity.setNumber(surplus);    //将余量赋给number字段   
		}
        int total = actservices.total();
         
        page.caculateLast(total);
         
        // 放入转发参数
        mav.addObject("cs", cs);
//        mav.addObject("time", time);
        // 放入jsp路径
        mav.setViewName("Volunteer/VolunActivity");
        return mav;
    }
	
	
	//删除活动
	@RequestMapping("DeleteActivity")
	public String DeleteActivityC(int aid){
		int flag = actservices.DeleteActivity(aid);
		System.out.println("删除单条活动" + flag);
		if(flag == 1){
			int flag2 = unpartservices.DeleteByActId(aid);
			System.out.println("删除报名记录" + flag2);			
		}
		return "redirect:/AllActivity.do";
	}
	
	//根据aid查找活动
	@RequestMapping("FindActByAid")
	public String FindActByAidC(int aid,Model m){
		Activity selectByAid = actservices.SelectByAid(aid);
		m.addAttribute("selectByAid", selectByAid);
		return "base/UpdateActivity";
	}
	
	//修改活动信息
	@RequestMapping("UpdateActivity")
	@ResponseBody
	@Transactional
	public String UpdateActivityC(@RequestBody Activity activity, HttpServletRequest request,HttpServletResponse response) throws NumberFormatException{
		String obj = null;
		boolean flag = false;
//		String straid = request.getParameter("aid");
//		String aname = request.getParameter("aname");
//		String introduce = request.getParameter("introduce");
//		String actaddress = request.getParameter("actaddress");
//		String day = request.getParameter("day");  
//		String strduration = request.getParameter("duration");
//		String strnumber = request.getParameter("number");
//		String strstatus = request.getParameter("status");
//		System.out.println("strstatus"+strstatus);
//		Integer status = Integer.valueOf(strstatus);
//		String remark = request.getParameter("remark");
//		Integer aid = Integer.valueOf(straid);
//		Float duration = Float.valueOf(strduration);
//		Integer number = Integer.valueOf(strnumber);
//		
//		Timestamp time = Timestamp.valueOf(day);   //日期的转换
//		Activity act = new Activity(aid, aname, introduce, actaddress, time, duration, number, status, remark);
//		act.setDay(time);
		System.out.println("activity修改的activity"+activity);
//		activity.setStatus(activity.status);
		int f = actservices.UpdateAct(activity);
		System.out.println("修改的flag " + f);
		if(f == 1){
			flag = true;
		}
		obj = flag +"";
		System.out.println("updateActivity的obj"+obj);
		return obj;
//		return "redirect:/AllActivity.do";
	}
	
	//批量删除
    @RequestMapping("DeleteSelectActivity")
    @ResponseBody
    public String DeleteSelectMessageC(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//   	 System.out.println(ids);
//   	 System.out.println(id);
    String obj = null;
   	 boolean b = actservices.DeleteSelectActivityS(ids);
   	 System.out.println("批量删的b"+b);
//   	 response.getWriter().print(b);  
   	 obj = b + "";
   	 return obj;
     }
    
     
    
    //志愿者首页测试
    @RequestMapping("Text")
    public String Text(){	
    	return "index";
    }
    
    
    

}
