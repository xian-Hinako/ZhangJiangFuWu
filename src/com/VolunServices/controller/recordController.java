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
	
	//ͨ������Ա��������ˣ�����������������뵽record��   ����ʧ�ܺ���ô�ع��ָ�����
	@RequestMapping("AddSomeRecord")
	public String AddSomeRecordC(int actId){
		int count = 0;   //ͳ���Ƿ��unpart�ļ�¼ȫ�Ƶ�record��   ���ж�count == number
		int number = unpartser.countNumberByActId(actId);
		Activity activity = actser.SelectByAid(actId);   //����actId����activity
		System.out.println("activity"+activity);
		List<Unpart> NumberList = unpartser.SellectByActId(actId);   //�ҳ����˸û����������List
		for (Unpart unpart : NumberList) {
//			System.out.println(unpart.getUid()+"  "+unpart.getActid()+" "+activity.getDuration());
			Record re = new Record(unpart.getUid(),unpart.getActid(),activity.getDuration());
//			System.out.println(re);
			int flag = recordservice.AddRecord(re);
			if(flag ==1){
				int flagD = unpartser.DeleteUnpart(unpart.getUnpartid());
//				System.out.println("ɾ��unpart" +flagD);
				count ++;
			}
		}
		System.out.println("count"+count);
		if(count == number){
			return "redirect:/FindAllUnpart.do";  //������˳ɹ�ҳ��
		}
		else{
			return "redirect:/FindAllUnpart.do";  //������˳���ҳ��
		}
	}
	
	//ͨ������Ա�ĵ�����¼��ˣ��Ѹü�¼���뵽record�� 
		@RequestMapping("AddSingleRecord")
		public String AddSingleRecordC(int unpartid){
			Unpart unpart = unpartser.FindUnpartByunpartid(unpartid);
			Activity activity = actser.SelectByAid(unpart.getActid());   //����actId����activity
			System.out.println("activity"+activity);
			if(activity != null){
				System.out.println(unpart.getUid()+"  "+unpart.getActid()+" "+activity.getDuration());
			    Record re = new Record(unpart.getUid(),unpart.getActid(),activity.getDuration());
//			    System.out.println(re);
				int flag = recordservice.AddRecord(re);
				if(flag ==1){
					int flagD = unpartser.DeleteUnpart(unpartid);
//					System.out.println("ɾ��unpart" +flagD);
					return "redirect:/FindAllUnpart.do";  //������˳ɹ�ҳ��
				}
				else{
					return "redirect:/FindAllUnpart.do";  //������˳���ҳ��
				}
			}else{
				return "redirect:/FindAllUnpart.do";  //������˳���ҳ��
			}
		    
		}
		
	//����recordid����
	@RequestMapping("FindRecordByReid")
	public String FindRecordByReidC(int reacordid,Model m){
		System.out.println("����������");
		Record selByParyKey = recordservice.selByParyKey(reacordid);
		m.addAttribute("selByParyKey", selByParyKey);
		return "base/UpdateRecord";
	}
	
	//�޸ĵ���record��¼
	@RequestMapping("UpdateRecord")
	@ResponseBody 
	public String UpdateRecordC(@RequestBody Record record,HttpServletResponse response){
		String obj = null;
		boolean f = false;
		System.out.println("����UpdateRecord");
		System.out.println("Update record��keyIDΪ" + record.getReacordid());
		int flag = recordservice.UpdateRecord(record);
		System.out.println("�޸�record��flag" +flag);
		if(flag == 1){
			f = true;
			System.out.println("�޸ĺ��ʱ��"+record.getDuration());
		}
		obj = f + "";
		return obj;
	}
	
	//����actId�޸Ĺ��������Ķ�����¼
	@RequestMapping("UpdateByActId")
	public String UpdateByActIdC(int actid){
		String obj = null;
		boolean f = false;
		int flag = recordservice.UpdateByActId(actid);
		if(flag == 1){
			return "redirect:/AllRecord.do";  //�޸ĳɹ�ҳ��
		}
		else{
			return "redirect:/AllRecord.do";  //�޸�ʧ��ҳ��
		}
	}
	
	//����ȫ�������¼
	@RequestMapping("AllRecord")
	public String FindAllRecordC(Model m){
		List<Record> allRecord = recordservice.AllRecord();
		int allRecordsize = allRecord.size();  //��¼����
		m.addAttribute("allRecord", allRecord);
		m.addAttribute("allRecordsize", allRecordsize);
		return "base/base_list";
	}
	
	//ɾ��������¼
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
////			return "redirect:/AllRecord.do";  //����ʧ��ҳ��
//		}
		result = obj +"";
		return result;
	}
	
	//����ɾ��
     @RequestMapping("DeleteSelectRecord")
     @ResponseBody
     public String DeleteSelectRecord(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//    	 System.out.println(ids);
//    	 System.out.println(id);
    	 String obj  = null;
    	 boolean b = recordservice.DeleteSelectRecordS(ids);
    	 System.out.println("Record��b "+b);
    	 obj = b + "";
    	 return obj;
//    	 response.getWriter().print(b);   	 
    	 
      }
     
     //�����û�ID����
     @RequestMapping("SelectRecordByUid")
     public String SelectRecordByUidC(int uid,Model m,HttpServletResponse response){
    	 List<Record> allRecord = recordservice.SelByUsId(uid);
    	 int allRecordsize = allRecord.size();
    	 m.addAttribute("allRecord", allRecord);
    	 m.addAttribute("allRecordsize", allRecordsize);
    	 return "base/base_list";
     }
     
     //���Ӽ�¼1�Ĳ鿴�Ƿ��иû
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
    	 selectByAid = actser.SelectByAid(actid);  //�鿴�Ƿ��иû
    	 System.out.println(selectByAid);
    	 if(selectByAid == null){
    		 flag = false + "";
    	 }else{
    		 flag = true + "";
    	 }
    	 System.out.println("����Ƿ��иû��flag" + flag);
    	 return flag;
     }
     
     //�����޸�ʱ����Ƿ��и��û�
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
    	 System.out.println("����Ƿ��и��û���flag" + flag);
    	 return flag;
     }
     
     //�ֶ�����д���ӻ��¼
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
     
     //����uid������˵ķ���ʱ��
     @RequestMapping("Totaltime")
     public String TotaltimeC(HttpSession session,Model m){
    	 User user = (User) session.getAttribute("usersession");
    	 float total= recordservice.totaltimeS(user.getUid());
    	 System.out.println("total "+total);
    	 m.addAttribute("total", total);
    	 return "Volunteer/ordinaryHome";
     }
     
     //��ʾ���˼�¼��ǰ4��
//     @RequestMapping("FindPreFour")
//     public String FindPreFourC(HttpSession session,Model m){
//    	 User user = (User) session.getAttribute("user");
//    	 
//    	 return "Volunteer/ordinaryHome";
//     }


}
