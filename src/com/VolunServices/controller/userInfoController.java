package com.VolunServices.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.User;
import com.VolunServices.pojo.Userinfo;
import com.VolunServices.service.userInfoService;
import com.VolunServices.tools.transData;
import com.VolunServices.util.SendUtil;

import net.sf.json.util.WebUtils;

@SessionAttributes("usersession")
@Controller
public class userInfoController {

	@Autowired
	private userInfoService userInfoservice;
	
	//��ѯ�û�������Ϣ
	@RequestMapping("Persondetial")
	public String FindPersonC(Model m,HttpSession ht){
		User usersession = (User) ht.getAttribute("usersession");
		int uiId = usersession.getUid();
		System.out.println(uiId);
		Userinfo persondetaild = userInfoservice.Persondetaild(uiId);
		m.addAttribute("persondetaild", persondetaild);
		if(usersession.getIdentity() == 2 || usersession.getIdentity() == 0){
			return "Volunteer/my";
		}else{
			return "Volunteer/Perdetaild";
		}		
	}
	
	@RequestMapping("UpdateUserInfo") 
	@ResponseBody
	@Transactional
	public String UpdateUserInfoC(@RequestBody Userinfo userinfo,HttpServletRequest request) throws NumberFormatException{
		String obj = null;
		boolean flag = false;
//		String struiid = request.getParameter("uiid");
//		String uiname = request.getParameter("uiname");
//		String strsex = request.getParameter("sex");
//		String strbirthday = request.getParameter("birthday");
//		String aladdress = request.getParameter("aladdress");  
//		String tel = request.getParameter("tel");
//		String strpicture = request.getParameter("picture");
//		Integer uiid = Integer.valueOf(struiid);
//		Integer sex = Integer.valueOf(strsex);
//		Date birthday = java.sql.Date.valueOf(strbirthday);
//		byte b[] = strpicture.getBytes();      //Stringת��Ϊbyte[] 
//		userinfo = new Userinfo(uiid, uiname, sex, birthday, aladdress, tel, b);
		
//		userinfo.setPicture(null);	
		System.out.println("ǰ̨�������޸ĵ�userinfo "+userinfo);
		int f = userInfoservice.UpdateUserInfo(userinfo);
		System.out.println(userinfo);
		System.out.println("�޸ĵ�userinfo " + f);
		if(f == 1){
			flag = true;
		}
		obj = flag +"";
		System.out.println("updateuserinfo��obj"+obj);
//		return "redirect:Volunteer/volunteerlist";
		return obj;
	}
	
	//��ͼƬ�ϴ����޸�
	@RequestMapping("UpdateUserInfo2")
	public String UpdateUserInfoC2(Userinfo userinfo,HttpServletRequest request,MultipartFile photo) throws NumberFormatException, IllegalStateException, IOException{
		String obj = null;
		boolean flag = false;
		System.out.println("ǰ̨�������޸ĵ�userinfo "+userinfo);		
        String struiid = request.getParameter("uiid");
		String uiname = request.getParameter("uiname");
		String strsex = request.getParameter("sex");
		String strbirthday = request.getParameter("birthday");
		String aladdress = request.getParameter("aladdress");  
		String tel = request.getParameter("tel");
		Integer uiid = Integer.valueOf(struiid);
		Integer sex = Integer.valueOf(strsex);
		Date birthday = java.sql.Date.valueOf(strbirthday);
		userinfo.setUiid(uiid);
		userinfo.setUiname(uiname);
		userinfo.setSex(sex);
		userinfo.setBirthday(birthday);
		userinfo.setAladdress(aladdress);
		userinfo.setTel(tel);  		
		if(!photo.isEmpty()){
      //ʹ��UUID��ͼƬ����������ȥ���ĸ���-��
      		String name = UUID.randomUUID().toString().replaceAll("-", "");
      		//��ȡ�ļ�����չ��
      		String ext = FilenameUtils.getExtension(photo.getOriginalFilename());
      		//����ͼƬ�ϴ�·��
      		String url = request.getSession().getServletContext().getRealPath("/upload");
      		System.out.println(url);
      		//�Ծ���·���������������ͼƬ
      		photo.transferTo(new File(url+"/"+name + "." + ext));
      		//��ͼƬ�洢·�����浽���ݿ�
      		userinfo.setPicture("upload/"+name + "." + ext);
		}else{
			Userinfo persondetaild = userInfoservice.Persondetaild(uiid);
			userinfo.setPicture(persondetaild.getPicture());
		}
		int f = userInfoservice.UpdateUserInfo(userinfo);
		System.out.println(userinfo);
		System.out.println("�޸ĵ�userinfo " + f);
		return "redirect:/ToUpdatePerson.do";		
	}
	
	
	@RequestMapping("FindPersonById")
	public String FindPersonByIdC(Model m,int uiid){
//		String struiId = request.getParameter("uiId");
		Userinfo persondetaild = userInfoservice.Persondetaild(uiid);
		m.addAttribute("persondetaild", persondetaild);
		return "Volunteer/UpdateVolunteer";
	}
	
	//�����ݵ�update����ҳ��
	@RequestMapping("ToUpdatePerson")
	public String ToUpdatePersonC(Model m,HttpSession session){
//		String struiId = request.getParameter("uiId");
		User user = (User) session.getAttribute("usersession");
		Integer uiid = user.getUid();
		int indentity = user.getIdentity();
		Userinfo persondetaild = userInfoservice.Persondetaild(uiid);
		String Photo = persondetaild.getPicture();
		m.addAttribute("persondetaild", persondetaild);
//		m.addAttribute("Photo", Photo);
		m.addAttribute("indentity", indentity);   //Ϊ�˷ֱ��޸���������ĸ�ҳ��
		if(indentity == 2 || indentity == 0){
			return "base/UpdateManagerhelf";
		}else{
			return "base/UpdateManagerhelf";
		}		
	}
	
	//ɾ��
		@RequestMapping("deleteUser")
		@ResponseBody
		public String deleteUser(int uiid,HttpServletResponse response) {
			String result = null;
			boolean obj = true;
			if(userInfoservice.DeleteUserInfo(uiid) == 1) {
				obj = true;
			}
			result = obj + "";
			return result;
		}
		
		 //����ɾ��
	    @RequestMapping("DeleteSelectUserInf")
	    @ResponseBody
	    public String DeleteSelectUserIn(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
	     String obj  = null;
	     boolean b = userInfoservice.DeleteSelectUserIn(ids);
	     System.out.println("Record��b "+b);
	     obj = b + "";
	     return obj;      
	     }
		
	    //�޸��������Ϣ����frameҳ��
	    @RequestMapping("Toframe")
	    public String ToframeC(){
	    	return "base/frame";
	    }
	    
	  //�ֻ�������û�����������
		@ResponseBody    
		@RequestMapping(value = "/sendme", method = RequestMethod.GET)    
		public ModelAndView sendme(@RequestParam(value = "uiname") String uiname,
				@RequestParam(value = "tel") String tel, HttpServletRequest request)throws HttpException, IOException {  
			
			ModelAndView model = new ModelAndView();        
			String str = request.getParameter("uiname");  
			
			uiname = new String(str.getBytes("iso-8859-1"),"UTF-8");
			System.out.println("�ֻ�������û�����������"+uiname);
			Userinfo userinfo = new Userinfo(uiname,tel);
			boolean flag = userInfoservice.loginList(userinfo);
			System.out.println("�ֻ���֤"+flag);
			if (flag) {            
				HashMap<String,String> hashMap = SendUtil.getMessageStatus(tel);            
				String result = hashMap.get("result"); 
				System.out.println("hashMap"+hashMap);
				if (result.trim().equals("1")) {                
					String code = hashMap.get("code");                
					HttpSession session = request.getSession();                
					session.setAttribute(tel+"code",code);                
					session.setMaxInactiveInterval(60*5);                
					model.addObject("flag","���ͳɹ�");            
				} else {                
					model.addObject("flag", "����ʧ��");            
				}            
					model.addObject("uiname",uiname);            
					model.addObject("tel",tel);
					model.setViewName("FindPassword");
				} else {            
					model.addObject("flag1", "�û������ֻ����벻��ȷ");            
					model.addObject("uiname", uiname);            
					model.addObject("tel",tel);
					System.out.println("��֤ʧ��");
					model.setViewName("FindPassword");        
				}        
					return model;    
				}
	
	
}
