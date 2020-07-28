package com.VolunServices.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.apache.commons.httpclient.HttpException;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.VolunServices.achieve.distinguishIp;
import com.VolunServices.achieve.getWebAddress;
import com.VolunServices.pojo.Activity;
import com.VolunServices.pojo.Record;
import com.VolunServices.pojo.Unpart;
import com.VolunServices.pojo.User;
import com.VolunServices.pojo.Userinfo;
import com.VolunServices.pojo.people;
import com.VolunServices.service.activityService;
import com.VolunServices.service.recordService;
import com.VolunServices.service.unpartService;
import com.VolunServices.service.userInfoService;
import com.VolunServices.service.userService;
import com.VolunServices.tools.countAge;
import com.VolunServices.util.MyTools;
import com.VolunServices.util.SendUtil;

@SessionAttributes("usersession") 
@Controller
public class userController {
	
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
	
	private String passwordF = null;
	private boolean checkPass = false;
	
	//��¼
	 @RequestMapping("Userlogin")
	    public String login(User user,Model model, HttpSession session,HttpServletResponse response,HttpServletRequest request) {
	        System.out.println("user:" + user.getUname() + "password:" + user.getUpassword());
	        try {
				if(MyTools.isStringEmpty(user.getUname(), user.getUpassword())) {
					model.addAttribute("msg", "��������Ϊ��");
	                return "login";
				}
				User user1 = userservice.getByusernameAndPassword(user.getUname(), user.getUpassword());
				if (user1 != null) {
					session.setAttribute("usersession", user1); 
		        	if(user1.getIdentity() == 1 || user1.getIdentity() == 3) {		//1Ϊ����Ա 3Ϊ��������Ա        		
		        		User findUserByName = userservice.FindUserByName(user.getUname());   //����
		        		model.addAttribute("findUserByName", findUserByName);  //����
			            return "base/frame";
		        	}
		        		session.setAttribute("user", user1);
		        		int uid = user1.getUid();
		        		List<Activity> PreActivity = new ArrayList<Activity>();
		        		User findUserByName = userservice.FindUserByName(user.getUname());   //����
		        		
		        		distinguishIp d = new distinguishIp();
		        		getWebAddress getwenaddress = new getWebAddress();
		        		findUserByName.setNowaddress(userservice.GetDiliweizhi(getwenaddress.getIp(request)));
		        		System.out.println("��¼�ĵ���λ��"+userservice.GetDiliweizhi(getwenaddress.getIp(request)));
		        		
		        		Float total = (float) 0;
		        		if(recordservice.SelByUsId(uid).size() != 0){
		        			total= recordservice.totaltimeS(uid);  //����
		        		}
		        		
		        		List<Unpart> selUnpartByuidPreTwoS = unpartservice.selUnpartByuidPreTwoS(uid);
		        		
		        		List<Record> findPreFour = recordservice.FindPreFour(uid);  //����
		        		
		        		int activitytotal = activityservice.total();
		        		if(activitytotal <= 9){
		        			PreActivity = activityservice.AllActivity();
		        		}else{
		        			PreActivity = activityservice.FindPreNice();
		        		}
		        		ToordinaryHome toordinaryHome = new ToordinaryHome(findUserByName,total,findPreFour,selUnpartByuidPreTwoS,PreActivity);
		        		model.addAttribute("toordinaryHome", toordinaryHome);
		        		
		        		return "Volunteer/ordinaryHome";
		        }else {
		        	model.addAttribute("msg", "������˺�������󣬵�¼ʧ��");
		        	return "login";
		        }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "redirect:/index.jsp"; 
	    }
		
		//����ע��
		@RequestMapping(value="logout")
		public String logout(HttpSession session,SessionStatus sessionStatus) {
			session.removeAttribute("usersession");  //����������ȡ��httpsession�е�usersession����
			session.invalidate();  //Ȼ������httpsessionʧЧ
			sessionStatus.setComplete();  //����ǵ���sessionStatus����
//			return "redirect:/index.jsp";
			return "index";
		}
		
		//ע��
		@RequestMapping("RegisterUser")
	    public String register(User user,Userinfo ui, Model m,HttpServletRequest request) {
			System.out.println(user.getUname());
			String tel = request.getParameter("tel");
			int flag = userservice.UserRegister(user);
			ui.setUiid(userservice.AccNameReId(user.getUname()));
			ui.setUiname(user.getUname());
			ui.setTel(tel);
	        if (flag == 1 && userInfoservice.AddUserInfo(ui) == 1) {
	        	m.addAttribute("msg", "ע��ɹ�");
		        return "redirect:/tgls/login.jsp";
	        }
	        m.addAttribute("msg", "ע��ʧ��");
            return "redirect:/register";
	    }
		
		//��ӹ���Ա
		@RequestMapping("AddManager")
		public String AddManager(User user,Userinfo ui,Model m,HttpServletRequest request){
			user.setIdentity(1);
			int flag = userservice.UserRegister(user);			
			ui.setPicture(null);
	        if (flag == 1) {
	        	ui.setUiid(userservice.AccNameReId(user.getUname()));
	        	int addManager = userInfoservice.AddManager(ui);
	        	if(addManager == 1){
	        		m.addAttribute("msg", "ע��ɹ�");
			        return "redirect:/managerlist.do";
	        	}	        	
	        }
	        m.addAttribute("msg", "ע��ʧ��");
            return "base/AddManager";
		}
		
    // �첽�ж��û����Ƿ����
	    @RequestMapping("UserNameAjax")
	    @ResponseBody
	    public Object testregisterCheckUserName(@RequestBody Map<String, String> req_map) {
	        String uname = req_map.get("uname");
	        Map<String, Integer> respMap = new HashMap<>();
	        if (userservice.FindUserByName(uname) == null) {
	            respMap.put("flag", 1);
	        } else {
	            respMap.put("flag", 0);
	        }
	        return respMap;
	    }
	    
	    // �첽�ж��û����Ƿ����
	    @ResponseBody
	    @RequestMapping("UserNameAjax2")	    
	    public String testregisterCheckUserName2(@RequestParam String uname,HttpServletRequest request,HttpServletResponse response) {
	    	boolean f = true;
	        uname = request.getParameter("uname");
	        User findUserByName = userservice.FindUserByName(uname);	        
	        if (findUserByName != null) {
	            f = false;
	        }
	        String flag = f +"";
	        return flag;
	    }
	
	  //��ʾ�����˺���Ϣ
	  @RequestMapping("myDetail")
	  public String myDetail(Model model, HttpSession session) {
		  User user = (User)session.getAttribute("usersession");
		  if (user == null) {
		      model.addAttribute("msg", "δ��¼");
		      return "redirect:/tgls/login.jsp";
		  } else {
		      userservice.fillUserByUid(user);
		      model.addAttribute("user", user);
		      System.out.println(user.getUserinfor()+""+user.getUid());
		      return "Volunteer/my";
		     }
	}
	

	  //�޸�����
/*	  @RequestMapping("Updatepassend")
	  @ResponseBody
	  public String Updatepassend(@RequestParam("uid") int uid,@RequestParam("oldpassword") String oldpassword,
		@RequestParam("password1") String password1,@RequestParam("password2") String password2, Model model){
		  String result = null;
		  boolean obj = true;
		  System.out.println("ȷ��Ҫ�޸�������"+uid);
		  User user = userservice.selectByPrimaryKey(uid);
		  System.out.println(user.getUpassword());
		  if(user.getUpassword().equals(oldpassword)) {
			  userservice.UpdatePass(uid, password1);
			  System.out.println(user.getUpassword());
			  if(user.getUpassword().equals(password2)) {
				  model.addAttribute("msg", "�޸�����ɹ���");
				  obj = true;
			  }else {
				  model.addAttribute("msg", "�������벻һ��");
			  }
		  }else {
			  model.addAttribute("msg", "�����������������ȷ������");
		  }
		  User user1 = userservice.selectByPrimaryKey(uid);
			result = obj + " "+user1.getUpassword()+ ""+"You can log out and log back in again!";
			return result;
//		  return "redirect:/tgls/login.jsp";//�����ض����ԭ����ҳ��
	  }	  
 */
	  
	  //�޸�����
	  @RequestMapping("Updatepassend")
	  @ResponseBody
	  public String Updatepassend(@RequestParam("uid") int uid,@RequestParam("password2") String password2,HttpSession session,SessionStatus sessionStatus){
		  String result = null;
		  boolean obj = false;
		  System.out.println("ȷ��Ҫ�޸�������"+uid);
		  User user = userservice.selectByPrimaryKey(uid);
		  System.out.println(user.getUpassword());
	//	  if(user.getUpassword().equals(oldpassword)) {
			  userservice.UpdatePass(uid, password2);
		//	  System.out.println(user.getUpassword());
			  if(userservice.UpdatePass(uid, password2) == 1) {
				  //�޸ĳɹ�
				  obj = true;
					session.removeAttribute("usersession");  //����������ȡ��httpsession�е�usersession����
					session.invalidate();  //Ȼ������httpsessionʧЧ
					sessionStatus.setComplete();  //����ǵ���sessionStatus����
			  }else {
				  //�޸�ʧ��
				  obj = false;				  
//				  model.addAttribute("msg", "�������벻һ��");
			  }
//		  }else {
//			  model.addAttribute("msg", "�����������������ȷ������");
//		  }
//		  User user1 = userservice.selectByPrimaryKey(uid);
//			result = obj + " "+user1.getUpassword()+ ""+"You can log out and log back in again!";
			 result = obj +"";
			return result;
	  }
	  
	//��������
	  @RequestMapping(value = "/comparecode", method = RequestMethod.GET)    
		 public ModelAndView comparecode(@RequestParam(value = "code") String code, User u,HttpServletRequest request, HttpServletResponse response) throws IOException {        
			 ModelAndView model = new ModelAndView();        
			 String str1 = request.getParameter("uiname");        
			 String str2 = request.getParameter("upassword"); 
//			 String str1 = request.getParameter("uiname");        
//			 String str2 = request.getParameter("tel"); 
			 String uname = new String(str1.getBytes("iso-8859-1"), "UTF-8");        
			 userservice.UpUserPass(uname,str2);        
			 HttpSession session = request.getSession();//����session 
			 User findByUname = userservice.FindByUname(uname);
			 Userinfo persondetaild = userInfoservice.Persondetaild(findByUname.getUid());
			 String sessionCode = (String) session.getAttribute(persondetaild.getTel()+"code");        
			 System.out.println(sessionCode);
			 System.out.println("��֤�ɹ�");
			 if (code.equals(sessionCode)) {            
				 model.addObject("result", "�޸�����ɹ�");        
			} else {            
				 model.addObject("result", "��֤�벻��ȷ");            
//				 model.setViewName("Volunteer/FindPassword"); 
				 model.setViewName("FindPassword"); 
				 }        
//			 model.setViewName("Volunteer/login");       
			 model.setViewName("login"); 
			 return model;    
		 }
	
	//���Ҹ����˻���Ϣ
	@RequestMapping("FindUser")
	public String FindUserC(HttpSession session,Model m,HttpServletRequest request){
		User user = (User) session.getAttribute("usersession");
		User findUserByName = userservice.FindUserByName(user.getUname());
		distinguishIp d = new distinguishIp();

		getWebAddress getwenaddress = new getWebAddress();
		String nowaddress = (String) d.getaddress(getwenaddress.getIp(request));
		findUserByName.setNowaddress(nowaddress);
		System.out.println("��ַΪ"+nowaddress);
		m.addAttribute("findUserByName", findUserByName);
		return "Volunteer/ordinaryHome";
	}
	
	@RequestMapping("managerlist")
	public String managerlistC(Model m) throws Exception{
		countAge getage = new countAge();
//		List managerlist = new ArrayList<people>();
		List managerlist = new ArrayList<Userinfo>();
		List<User> userlist = userservice.FindByIdentity(1);
		List<User> userlist2 = userservice.FindByIdentity(3);
		userlist.addAll(userlist2);
		for (User user : userlist) {
			int age = 0;
			Userinfo p = userInfoservice.Persondetaild(user.getUid());
			System.out.println(p);
			if(p == null){
				continue;
			}
			//��������
//			System.out.println(p.getBirthday());
			if(p.getBirthday() == null){
				age = 0;
			}else{				
				Date turndate = getage.turndate(p.getBirthday());
				age = countAge.getAge(turndate); 
			}
//			System.out.println("age "+age);
			people peo = new people(p.getUiid(), p.getUiname(), p.getSex(), age, p.getAladdress(), p.getTel(), p.getPicture());
			System.out.println(peo);
			managerlist.add(peo);
//			managerlist.add(p);
		}
		int managerlistsize = managerlist.size();   //�����ж�������¼
		m.addAttribute("managerlist", managerlist);
		m.addAttribute("managerlistsize", managerlistsize);
		return "base/managerlist";   //����Ա���Ͻ�
	}

	@RequestMapping("volunteerlist")
	public String volunteerlistC(Model m) throws Exception{
		countAge getage = new countAge();
		List<User> userlist = userservice.FindByIdentity(2);
		List<User> userlist2 = userservice.FindByIdentity(0);   //δͨ����˵Ĺ���Ա
//		userlist.removeAll(userlist2);
		userlist.addAll(userlist2);
		List volunteerlist = new ArrayList<Userinfo>();
		for (User user : userlist) {
			int age = 0;
			Userinfo p = userInfoservice.Persondetaild(user.getUid());
//			System.out.println(p);
			if(p == null){
				continue;
			}
			//��������
//			System.out.println(p.getBirthday());
			if(p.getBirthday() == null){
				age = 0;
			}else{				
				Date turndate = getage.turndate(p.getBirthday());
				age = countAge.getAge(turndate); 
			}
//			System.out.println("age "+age);
			people peo = new people(p.getUiid(), p.getUiname(), p.getSex(), age, p.getAladdress(), p.getTel(), p.getPicture());
//			System.out.println(peo);
//			volunteerlist.add(userInfoservice.Persondetaild(user.getUid()));
			volunteerlist.add(peo);
		}
		int volunteerlistsize = volunteerlist.size();  //��¼����
		m.addAttribute("volunteerlist", volunteerlist);
		m.addAttribute("volunteerlistsize", volunteerlistsize);
		return "Volunteer/volunteerlist";   //����Ա���Ͻ���
	}
	
	//����ע��ҳ�沢�һ�ȡ����λ��
	@RequestMapping("ToRegisterAndGetAddress")
	public String ToRegisterAndGetAddressC(Model m,HttpServletRequest request){

		getWebAddress getwenaddress = new getWebAddress();
		String getDiliweizhi = userservice.GetDiliweizhi(getwenaddress.getIp(request));
		m.addAttribute("getDiliweizhi", getDiliweizhi);
		return "register";
	}
	
	//��ѯδ��˵Ĺ���Ա
		@RequestMapping("NoAuditUser")
		public String FindNoAuditUser(User user,Model m,HttpSession ht){
			List<User> Auser = userservice.FindByIdentity(0);
			int Ausersize = Auser.size();      //��¼����
			m.addAttribute("NoAuditU", Auser);
			m.addAttribute("Ausersize", Ausersize);
			return "base/NoAuditUser";
		}
		
	//��������Ա��˹���Ա����(��Ϊ����Ա)
	@RequestMapping("AuditUser")
	public String AuditUser(Integer uid){
		User selectByPrimaryKey = userservice.selectByPrimaryKey(uid);
		User user = new User(uid,1);
		int flag = userservice.ManagerPass(user);
		return "redirect:/NoAuditUser.do";
	}
	
	//��������Ա��˹���Ա����(�������Ϊ����Ա,�����ͨ־Ը��)
		@RequestMapping("UnpassAuditUser")
		public String UnpassAuditUser(Integer uid){
			User selectByPrimaryKey = userservice.selectByPrimaryKey(uid);
			User user = new User(uid,2);
			int flag = userservice.ManagerPass(user);
			return "redirect:/NoAuditUser.do";
		}
	
	//�����ݵ��޸�����ҳ��
	@RequestMapping("ToUpdatePassword")
	public String ToUpdatePassword(HttpSession session,Model m){
		User user = (User) session.getAttribute("usersession");
		int uidpass = user.getUid();
		int identity = user.getIdentity();
		m.addAttribute("uidpass", uidpass);
		m.addAttribute("identity", identity);
		String oldpassword = user.getUpassword();
		m.addAttribute("oldpassword", oldpassword);
		if(user.getIdentity() == 2 || user.getIdentity() == 0){
			return "Volunteer/VolunteerUpdatePass";
		}else{
			return "Volunteer/UpdatePassword";
		}		
	}
	
	
	//�������ľ������Ƿ���ȷ
	@RequestMapping("checkOldPassword")
//	@ResponseBody
	public String checkOldPasswordC(HttpSession session,Model m){
		User usersession = (User) session.getAttribute("usersession");
		String oldpassword = usersession.getUpassword();
		m.addAttribute("oldpassword", oldpassword);
		if(usersession.getIdentity() == 2 || usersession.getIdentity() == 0){
			return "Volunteer/VolunteerUpdatePass";
		}else{
			return "Volunteer/UpdatePassword";
		}
	}
	

		
}
