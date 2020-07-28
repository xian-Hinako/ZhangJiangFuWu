package com.VolunServices.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.service.unpartService;

@Controller
public class unpartController {

	@Autowired
	private unpartService unpartservice;
	
	//查找全部报名参加活动的名单
	@RequestMapping("FindAllUnpart")
	public String FindAllUnpartC(Model m){
		List<Unpart> allUnpart = unpartservice.AllUnpart();		
		int allUnpartsize = allUnpart.size();  //记录总数
		m.addAttribute("allUnpart", allUnpart);
		m.addAttribute("allUnpartsize", allUnpartsize);
		return "base/base_allunpart";  //返回显示全部报名要参加活动的名单
	}
	
	
	//根据活动id查找参加同一活动的名单
	@RequestMapping("FindUnpartByAid")
	public String FindUnpartByAidC(int actId,Model m,HttpServletResponse response){
		List<Unpart> allUnpart = unpartservice.SellectByActId(actId);
		int allUnpartsize = allUnpart.size(); 
		m.addAttribute("allUnpart", allUnpart);
		m.addAttribute("allUnpartsize", allUnpartsize);
		return "base/base_allunpart";  //返回参加同一活动的名单
	}
	
	//根据主键查找
	@RequestMapping("FindUnpartByunpartid")
	public String FindUnpartByunpartidC(int unpartid,Model m){
		Unpart findUnpartByunpartid = unpartservice.FindUnpartByunpartid(unpartid);
		m.addAttribute("findUnpartByunpartid", findUnpartByunpartid);
		return "base/UpdateUnpart";
	}
	
	//志愿者查找自己报名的记录
//	@RequestMapping("FindUnpartByUid")
//	public String FindUnpartByUidC(int uid,Model m){
//		List<Unpart> findUnpartByUidS = unpartservice.FindUnpartByUidS(uid);
//		m.addAttribute("findUnpartByUidS", findUnpartByUidS);
//		return "";   //志愿者自己报名的活动的页面
//		
//	}
	
	@RequestMapping("UpdateUnpart")
	@ResponseBody
	public String UpdateUnpartC(@RequestBody Unpart up,HttpServletResponse response){
		String obj = null;
		boolean f = false;		
		int flag = unpartservice.UpdateUnpart(up);
		System.out.println("修改的up "+up);
		if(flag == 1){
			f = true;
		}
		obj = f+"";
		return obj;
//		return "redirect:/FindAllUnpart.do";
		
	}
	
	
	//管理员取消某志愿者参加某个活动
	@RequestMapping("CancelUser")
	public String CancelUserC(int unpartid){
//		int unpartId = unpartservice.selectByUidAndAid(un);
		int flag = unpartservice.DeleteUnpart(unpartid);
		System.out.println(flag);
		return "redirect:/FindAllUnpart.do";
	}
	
	//志愿者自己取消参加某个活动
		@RequestMapping("CancelUnpartBySelf")
		public String CancelUnpartBySelfC(int unpartid){
//			int unpartId = unpartservice.selectByUidAndAid(un);
			int flag = unpartservice.DeleteUnpart(unpartid);
			System.out.println(flag);
			return "redirect:/TooridinaryHome.do";
		}
	
	//管理员新增某用户报名某活动
	@RequestMapping("AddUnpart")
	@ResponseBody
	public String AddUnpartC(Unpart un,HttpServletRequest request,HttpServletResponse response){
		boolean flag = false;
		String obj = null;
		System.out.println("进入AddUnpart");
		String struid = request.getParameter("uid");
		String stractid = request.getParameter("actid");
		String strstatus = request.getParameter("status");
		System.out.println(struid+" "+stractid+" "+strstatus);
		int uid = 0;
   	    int actid = 0;
   	    int status = 0;
   	    try{
   		    uid = Integer.valueOf(uid);
   		    actid = Integer.valueOf(stractid);
   		    status = Integer.valueOf(strstatus);
//   	    	uid = Integer.valueOf(un.getUid());
//		    actid = Integer.valueOf(un.get);
//		    status = Integer.valueOf(strstatus);
   		    System.out.println(uid+" "+actid+" "+status);
   	    }catch (NumberFormatException e) {
			// TODO: handle exception
		}
   	    un.setUid(uid);
   	    un.setActid(actid);
   	    un.setStatus(status);
		int f = unpartservice.AddUnpart(un);
		if(f == 1){
			flag = true;
//			return "redirect:/FindAllUnpart.do";  //返回报名成功页面
		}
		obj = flag +"";
		return obj;
	}
	
	//某用户在志愿者端自己报名某活动
		@RequestMapping("VolunViewAddUnpart")
		public String VolunViewAddUnpartC(Unpart un){
			System.out.println("新增" + un.getUid());			
			int flag = unpartservice.AddUnpart(un);
			if(flag == 1){
				return "redirect:/FindAllUnpart.do";  //返回报名成功页面
			}
			else{
				return "redirect:/FindAllUnpart.do";  //返回报名不成功页面
			}
		}
	
	//批量删除
    @RequestMapping("DeleteSelectUnpart")
    @ResponseBody
    public String DeleteSelectUnpartC(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//   	 System.out.println(ids);
//   	 System.out.println(id);
    String obj = null;
   	 boolean b = unpartservice.DeleteSelectUnpartS(ids);
   	 System.out.println("unpart的批量删的b"+b);
   	 obj = b + "";
   	 return obj;
//   	 response.getWriter().print(b);   	 
   	 
     }
    
    //根据unpartid查找个人信息,用于修改
//    @RequestMapping("FindUnpartByunpartid")
//    @ResponseBody
//    public String FindUnpartByunpartid(int unpartid,Model m,HttpServletResponse response){
//    	Unpart findUnpartByunpartid = unpartservice.FindUnpartByunpartid(unpartid);
//    	m.addAttribute("findUnpartByunpartid", findUnpartByunpartid);
//    	return "base/UpdateUnpart";
//    }

	
}
