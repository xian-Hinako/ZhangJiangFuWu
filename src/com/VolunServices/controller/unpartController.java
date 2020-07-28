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
	
	//����ȫ�������μӻ������
	@RequestMapping("FindAllUnpart")
	public String FindAllUnpartC(Model m){
		List<Unpart> allUnpart = unpartservice.AllUnpart();		
		int allUnpartsize = allUnpart.size();  //��¼����
		m.addAttribute("allUnpart", allUnpart);
		m.addAttribute("allUnpartsize", allUnpartsize);
		return "base/base_allunpart";  //������ʾȫ������Ҫ�μӻ������
	}
	
	
	//���ݻid���Ҳμ�ͬһ�������
	@RequestMapping("FindUnpartByAid")
	public String FindUnpartByAidC(int actId,Model m,HttpServletResponse response){
		List<Unpart> allUnpart = unpartservice.SellectByActId(actId);
		int allUnpartsize = allUnpart.size(); 
		m.addAttribute("allUnpart", allUnpart);
		m.addAttribute("allUnpartsize", allUnpartsize);
		return "base/base_allunpart";  //���زμ�ͬһ�������
	}
	
	//������������
	@RequestMapping("FindUnpartByunpartid")
	public String FindUnpartByunpartidC(int unpartid,Model m){
		Unpart findUnpartByunpartid = unpartservice.FindUnpartByunpartid(unpartid);
		m.addAttribute("findUnpartByunpartid", findUnpartByunpartid);
		return "base/UpdateUnpart";
	}
	
	//־Ը�߲����Լ������ļ�¼
//	@RequestMapping("FindUnpartByUid")
//	public String FindUnpartByUidC(int uid,Model m){
//		List<Unpart> findUnpartByUidS = unpartservice.FindUnpartByUidS(uid);
//		m.addAttribute("findUnpartByUidS", findUnpartByUidS);
//		return "";   //־Ը���Լ������Ļ��ҳ��
//		
//	}
	
	@RequestMapping("UpdateUnpart")
	@ResponseBody
	public String UpdateUnpartC(@RequestBody Unpart up,HttpServletResponse response){
		String obj = null;
		boolean f = false;		
		int flag = unpartservice.UpdateUnpart(up);
		System.out.println("�޸ĵ�up "+up);
		if(flag == 1){
			f = true;
		}
		obj = f+"";
		return obj;
//		return "redirect:/FindAllUnpart.do";
		
	}
	
	
	//����Աȡ��ĳ־Ը�߲μ�ĳ���
	@RequestMapping("CancelUser")
	public String CancelUserC(int unpartid){
//		int unpartId = unpartservice.selectByUidAndAid(un);
		int flag = unpartservice.DeleteUnpart(unpartid);
		System.out.println(flag);
		return "redirect:/FindAllUnpart.do";
	}
	
	//־Ը���Լ�ȡ���μ�ĳ���
		@RequestMapping("CancelUnpartBySelf")
		public String CancelUnpartBySelfC(int unpartid){
//			int unpartId = unpartservice.selectByUidAndAid(un);
			int flag = unpartservice.DeleteUnpart(unpartid);
			System.out.println(flag);
			return "redirect:/TooridinaryHome.do";
		}
	
	//����Ա����ĳ�û�����ĳ�
	@RequestMapping("AddUnpart")
	@ResponseBody
	public String AddUnpartC(Unpart un,HttpServletRequest request,HttpServletResponse response){
		boolean flag = false;
		String obj = null;
		System.out.println("����AddUnpart");
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
//			return "redirect:/FindAllUnpart.do";  //���ر����ɹ�ҳ��
		}
		obj = flag +"";
		return obj;
	}
	
	//ĳ�û���־Ը�߶��Լ�����ĳ�
		@RequestMapping("VolunViewAddUnpart")
		public String VolunViewAddUnpartC(Unpart un){
			System.out.println("����" + un.getUid());			
			int flag = unpartservice.AddUnpart(un);
			if(flag == 1){
				return "redirect:/FindAllUnpart.do";  //���ر����ɹ�ҳ��
			}
			else{
				return "redirect:/FindAllUnpart.do";  //���ر������ɹ�ҳ��
			}
		}
	
	//����ɾ��
    @RequestMapping("DeleteSelectUnpart")
    @ResponseBody
    public String DeleteSelectUnpartC(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//   	 System.out.println(ids);
//   	 System.out.println(id);
    String obj = null;
   	 boolean b = unpartservice.DeleteSelectUnpartS(ids);
   	 System.out.println("unpart������ɾ��b"+b);
   	 obj = b + "";
   	 return obj;
//   	 response.getWriter().print(b);   	 
   	 
     }
    
    //����unpartid���Ҹ�����Ϣ,�����޸�
//    @RequestMapping("FindUnpartByunpartid")
//    @ResponseBody
//    public String FindUnpartByunpartid(int unpartid,Model m,HttpServletResponse response){
//    	Unpart findUnpartByunpartid = unpartservice.FindUnpartByunpartid(unpartid);
//    	m.addAttribute("findUnpartByunpartid", findUnpartByunpartid);
//    	return "base/UpdateUnpart";
//    }

	
}
