package com.VolunServices.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.VolunServices.achieve.distinguishIp;
import com.VolunServices.achieve.getWebAddress;
import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.User;
import com.VolunServices.service.activityService;
import com.VolunServices.service.recordService;
import com.VolunServices.service.unpartService;
import com.VolunServices.service.userInfoService;
import com.VolunServices.service.userService;

@SessionAttributes("usersession")
@Controller
public class CommonController {
	
	@Autowired
	private userService userservice;
	
	@Autowired
	private userInfoService userInfoservice;
	
	@Autowired
	private recordService recordservice;
	
	@Autowired
	private unpartService unpartservice;
	
	@Autowired 
	private activityService activityservice;
	
	//首页显示的内容
	@RequestMapping("TooridinaryHome")
	public String TooridinaryHomeC(Model m,HttpSession session,HttpServletRequest request){
		User user = (User) session.getAttribute("usersession");
		int uid = user.getUid();      //有时从志愿活动返回首页会报空指针
		List<Activity> PreActivity = new ArrayList<Activity>();
		User findUserByName = userservice.FindUserByName(user.getUname());   //新增
        
		getWebAddress getwenaddress = new getWebAddress();		
		findUserByName.setNowaddress(userservice.GetDiliweizhi(getwenaddress.getIp(request)));
		System.out.println("地理位置"+userservice.GetDiliweizhi(getwenaddress.getIp(request)));
		
		Float total = (float) 0;
		if(recordservice.SelByUsId(uid).size() != 0){
			total= recordservice.totaltimeS(uid);  //新增
		}
		
		List<Unpart> selUnpartByuidPreTwoS = unpartservice.selUnpartByuidPreTwoS(uid);
		
		List<Record> findPreFour = recordservice.FindPreFour(uid);  //新增
		
		int activitytotal = activityservice.total();
		if(activitytotal <= 9){
			PreActivity = activityservice.AllActivity();
		}else{
			PreActivity = activityservice.FindPreNice();
		}
		
		ToordinaryHome toordinaryHome = new ToordinaryHome(findUserByName,total,findPreFour,selUnpartByuidPreTwoS,PreActivity);
		m.addAttribute("toordinaryHome", toordinaryHome);
				
		return "Volunteer/ordinaryHome";
	}
	
	//首页中个人的全部报名活动
	@RequestMapping("PersonUnpart")
	public String PersonUnpartC(Model m,HttpSession session){
		User user = (User) session.getAttribute("usersession");
		int uid = user.getUid();
		List<Unpart> PersonUnpartlist = unpartservice.FindUnpartByUidS(uid);
   	    m.addAttribute("PersonUnpartlist", PersonUnpartlist);
   	    return "Volunteer/UnpartByUid";
	}
	
	//首页中个人的全部服务记录
	@RequestMapping("PersonRecord")
	public String PersonRecordC(Model m,HttpSession session){
		User user = (User) session.getAttribute("usersession");
		int uid = user.getUid();
		System.out.println("session中的uid"+ uid);
		List<Record> PersonRecordlist = recordservice.SelByUsId(uid);
		for (Record record : PersonRecordlist) {
			System.out.println("PersonRecord"+record);
		}
		m.addAttribute("PersonRecordlist", PersonRecordlist);
		return "Volunteer/RecordByUid";
	}
	
	//检测用户是否登录
	@ResponseBody
	@RequestMapping("checklogin")
	public String checklogin(HttpSession session,HttpServletResponse response) throws IOException{
		boolean flag = false;
		String obj = null;
		User user = (User) session.getAttribute("usersession");
		System.out.println("进入checklogin");
		if(user == null){
			flag = true;
			System.out.println("O啦" +flag);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('你还没有登录,请先登录!');");
			out.println("history.back()");
			out.println("</script>");
			System.out.println("OK啦" +flag);
			return "redirect:/Userlogin.do";
		}
		return "redirect:/Userlogin.do";
	}
	

}
