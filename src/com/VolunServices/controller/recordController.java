package com.VolunServices.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.User;
import com.VolunServices.service.activityService;
import com.VolunServices.service.recordService;
import com.VolunServices.service.unpartService;
import com.VolunServices.service.userService;

@Controller
public class recordController {
	
	@Autowired
	private recordService recordservice;
	
	@Autowired
	private unpartService unpartser;
	
	@Autowired
	private activityService actser;
	
	@Autowired
	private userService userservice;
	
	//通过管理员的批量审核，把整个活动的名单加入到record表   存在失败后怎么回滚恢复问题
	@RequestMapping("AddSomeRecord")
	public String AddSomeRecordC(int actId){
		int count = 0;   //统计是否把unpart的记录全移到record中   即判断count == number
		int number = unpartser.countNumberByActId(actId);
		Activity activity = actser.SelectByAid(actId);   //根据actId查找activity
		System.out.println("activity"+activity);
		List<Unpart> NumberList = unpartser.SellectByActId(actId);   //找出报了该活动的名单集合List
		for (Unpart unpart : NumberList) {
//			System.out.println(unpart.getUid()+"  "+unpart.getActid()+" "+activity.getDuration());
			Record re = new Record(unpart.getUid(),unpart.getActid(),activity.getDuration());
//			System.out.println(re);
			int flag = recordservice.AddRecord(re);
			if(flag ==1){
				int flagD = unpartser.DeleteUnpart(unpart.getUnpartid());
//				System.out.println("删除unpart" +flagD);
				count ++;
			}
		}
		System.out.println("count"+count);
		if(count == number){
			return "redirect:/FindAllUnpart.do";  //返回审核成功页面
		}
		else{
			return "redirect:/FindAllUnpart.do";  //返回审核出错页面
		}
	}
	
	//通过管理员的单条记录审核，把该记录加入到record表 
		@RequestMapping("AddSingleRecord")
		public String AddSingleRecordC(int unpartid){
			Unpart unpart = unpartser.FindUnpartByunpartid(unpartid);
			Activity activity = actser.SelectByAid(unpart.getActid());   //根据actId查找activity
			System.out.println("activity"+activity);
			if(activity != null){
				System.out.println(unpart.getUid()+"  "+unpart.getActid()+" "+activity.getDuration());
			    Record re = new Record(unpart.getUid(),unpart.getActid(),activity.getDuration());
//			    System.out.println(re);
				int flag = recordservice.AddRecord(re);
				if(flag ==1){
					int flagD = unpartser.DeleteUnpart(unpartid);
//					System.out.println("删除unpart" +flagD);
					return "redirect:/FindAllUnpart.do";  //返回审核成功页面
				}
				else{
					return "redirect:/FindAllUnpart.do";  //返回审核出错页面
				}
			}else{
				return "redirect:/FindAllUnpart.do";  //返回审核出错页面
			}
		    
		}
		
	//根据recordid查找
	@RequestMapping("FindRecordByReid")
	public String FindRecordByReidC(int reacordid,Model m){
		System.out.println("进来查找啦");
		Record selByParyKey = recordservice.selByParyKey(reacordid);
		m.addAttribute("selByParyKey", selByParyKey);
		return "base/UpdateRecord";
	}
	
	//修改单条record记录
	@RequestMapping("UpdateRecord")
	@ResponseBody 
	public String UpdateRecordC(@RequestBody Record record,HttpServletResponse response){
		String obj = null;
		boolean f = false;
		System.out.println("进来UpdateRecord");
		System.out.println("Update record的keyID为" + record.getReacordid());
		int flag = recordservice.UpdateRecord(record);
		System.out.println("修改record的flag" +flag);
		if(flag == 1){
			f = true;
			System.out.println("修改后的时长"+record.getDuration());
		}
		obj = f + "";
		return obj;
	}
	
	//根据actId修改关于这个活动的多条记录
	@RequestMapping("UpdateByActId")
	public String UpdateByActIdC(int actid){
		String obj = null;
		boolean f = false;
		int flag = recordservice.UpdateByActId(actid);
		if(flag == 1){
			return "redirect:/AllRecord.do";  //修改成功页面
		}
		else{
			return "redirect:/AllRecord.do";  //修改失败页面
		}
	}
	
	//查找全部服务记录
	@RequestMapping("AllRecord")
	public String FindAllRecordC(Model m){
		List<Record> allRecord = recordservice.AllRecord();
		int allRecordsize = allRecord.size();  //记录总数
		m.addAttribute("allRecord", allRecord);
		m.addAttribute("allRecordsize", allRecordsize);
		return "base/base_list";
	}
	
	//删除单条记录
	@RequestMapping("DeleteRecord")
	@ResponseBody
	public String DeleteRecordC(int reacordid,HttpServletResponse response){
		String result = null;
		boolean obj = true;
		int flag = recordservice.DeleteRecord(reacordid);
		if(flag == 1){
			obj = true;
//			return "redirect:/AllRecord.do";
		}
//		else{
////			return "redirect:/AllRecord.do";  //返回失败页面
//		}
		result = obj +"";
		return result;
	}
	
	//批量删除
     @RequestMapping("DeleteSelectRecord")
     @ResponseBody
     public String DeleteSelectRecord(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//    	 System.out.println(ids);
//    	 System.out.println(id);
    	 String obj  = null;
    	 boolean b = recordservice.DeleteSelectRecordS(ids);
    	 System.out.println("Record的b "+b);
    	 obj = b + "";
    	 return obj;
//    	 response.getWriter().print(b);   	 
    	 
      }
     
     //根据用户ID查找
     @RequestMapping("SelectRecordByUid")
     public String SelectRecordByUidC(int uid,Model m,HttpServletResponse response){
    	 List<Record> allRecord = recordservice.SelByUsId(uid);
    	 int allRecordsize = allRecord.size();
    	 m.addAttribute("allRecord", allRecord);
    	 m.addAttribute("allRecordsize", allRecordsize);
    	 return "base/base_list";
     }
     
     //增加记录1的查看是否有该活动
     @ResponseBody
     @RequestMapping("CheckActivity")
     public String CheckActivityC(HttpServletResponse response,HttpServletRequest request){
    	 String stractid = request.getParameter("actid");
    	 Integer actid = 0;
    	 try{
    		 actid = Integer.valueOf(stractid);
    	 }catch (NumberFormatException e) {
			// TODO: handle exception
		}    	 
    	 String flag = null;
    	 Activity selectByAid = null;
    	 selectByAid = actser.SelectByAid(actid);  //查看是否有该活动
    	 System.out.println(selectByAid);
    	 if(selectByAid == null){
    		 flag = false + "";
    	 }else{
    		 flag = true + "";
    	 }
    	 System.out.println("检查是否有该活动的flag" + flag);
    	 return flag;
     }
     
     //增加修改时检查是否有该用户
     @ResponseBody
     @RequestMapping("checkuid")
 	 public String checkuidC(HttpServletResponse response,HttpServletRequest request){
    	 String struid = request.getParameter("uid");
    	 Integer uid = 0;
    	 try{
    		 uid = Integer.valueOf(struid);
    	 }catch (NumberFormatException e) {
			// TODO: handle exception
		}    	 
    	 String flag = null;
    	 User selectByuid = null;
    	 selectByuid = userservice.selectByPrimaryKey(uid);
    	 System.out.println(selectByuid);
    	 if(selectByuid == null){
    		 flag = false + "";
    	 }else{
    		 flag = true + "";
    	 }
    	 System.out.println("检查是否有该用户的flag" + flag);
    	 return flag;
     }
     
     //手动自填写增加活动记录
     @RequestMapping("SingleAddRecord")
     @ResponseBody
     public String SingleAddRecordC(@RequestBody Record record){
    	 String obj = null;
         boolean flag = false;
//         String struid = request.getParameter("uid");
//         String stractid = request.getParameter("actid");
//         String strduration = request.getParameter("duration");
//         Integer uid = 0;
//    	 Integer actid = 0;
//    	 float duration = 0;
//    	 try{
//    		 uid = Integer.valueOf(uid);
//    		 actid = Integer.valueOf(stractid);
//    		 duration = Float.valueOf(strduration);
//    	 }catch (NumberFormatException e) {
//			// TODO: handle exception
//		}
//    	 re.setUid(uid);
//    	 re.setActid(actid);
//    	 re.setDuration(duration);
    	 int addRecord = recordservice.AddRecord(record);
    	 if(addRecord == 1){
    		 flag = true;
    	 }
    	 obj = flag +"";
//    	 return "redirect:/AllRecord.do";
    	 return obj;
     }
     
     //根据uid计算个人的服务时长
     @RequestMapping("Totaltime")
     public String TotaltimeC(HttpSession session,Model m){
    	 User user = (User) session.getAttribute("usersession");
    	 float total= recordservice.totaltimeS(user.getUid());
    	 System.out.println("total "+total);
    	 m.addAttribute("total", total);
    	 return "Volunteer/ordinaryHome";
     }
     
     //显示个人记录的前4条
//     @RequestMapping("FindPreFour")
//     public String FindPreFourC(HttpSession session,Model m){
//    	 User user = (User) session.getAttribute("user");
//    	 
//    	 return "Volunteer/ordinaryHome";
//     }


}
