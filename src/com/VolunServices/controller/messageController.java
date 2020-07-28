package com.VolunServices.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.VolunServices.pojo.Message;
import com.VolunServices.pojo.User;
import com.VolunServices.service.messageService;

@SessionAttributes("usersession") 
@Controller
public class messageController {

	@Autowired
	private messageService messageservice;
	
	//管理员查找全部评论
	@RequestMapping("FindAllMessage")
	public String FindAllMessageC(Model m){
		List<Message> findAllMessage = messageservice.FindAllMessage();
		int findAllMessagesize = findAllMessage.size();  //记录总数
		m.addAttribute("findAllMessage", findAllMessage);
		m.addAttribute("findAllMessagesize", findAllMessagesize);
		return "base/Message";  //返回显示全部评论的页面
	}
	
	//志愿者页面的全部评论
	@RequestMapping("AllMessage")
	public String AllMessageC(Model m,HttpSession session){
		List<Message> AllMessage = messageservice.FindAllMessage();
		User user = (User) session.getAttribute("usersession");
		m.addAttribute("AllMessage", AllMessage);
		if(user != null){
			m.addAttribute("user", user);
		}
		return "VolunVoice";  //返回显示全部评论的页面
	}
	
	//增加新的评论
	@RequestMapping("AddNewMessage")
	@ResponseBody
	public String AddNewMessageC(HttpServletRequest request,HttpSession session,HttpServletResponse response){
//		String strtime = request.getParameter("time");
		String obj = null;
		boolean flag = false;
		User user = (User) session.getAttribute("usersession");
		String content = request.getParameter("content");
		System.out.println("message的content "+content);
		Message m = new Message();
		m.setUid(user.getUid());
		m.setContent(content);
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strtime = sdf.format(d);
        Timestamp time = Timestamp.valueOf(strtime);
        m.setTime(time);
		int f = messageservice.AddMessage(m);
		if(f == 1){
			flag = true;
		}
		obj = flag +"";
		return obj;
//		PrintWriter out = null;				
//		try {
//			out = response.getWriter();
//			response.reset(); 
//			response.setCharacterEncoding("UTF-8");
//			response.setHeader("Content-type", "text/html;charset=UTF-8"); 
//			if(f==1){
//				out.print("<script>alert('Publication success!');</script>");
//			}else{
//				out.print("<script>alert('Publication failed!');</script>");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(out != null){
//				out.flush();
//				out.close();
//			}
//		}
//		return "redirect:/FindAllMessage.do";
	}
	
	//根据mid删除评论
	@RequestMapping("DeleteMessage")
	public String DeleteMessageC(int mid,HttpSession session){
		int flag = messageservice.DeleteMessage(mid);
		User usersession = (User) session.getAttribute("usersession");
		if (usersession.getIdentity() == 1 || usersession.getIdentity() == 3) {   //身份为管理员时候
			return "redirect:/FindAllMessage.do";
		}
		else{   //普通志愿者
			return "redirect:/AllMessage.do";
		}
	}
	
	//根据关键字模糊查询
	@RequestMapping("FindMessByKey")
	public String FindMessByKeyC(String key,Model m){
		List<Message> findAllMessage = messageservice.FindMessageByMess(key);
		int findAllMessagesize = findAllMessage.size();  //记录总数
		m.addAttribute("findAllMessage", findAllMessage);
		m.addAttribute("findAllMessagesize", findAllMessagesize);
		return "base/Message";  //返回搜索结果页面
	}
	
	//批量删除
    @RequestMapping("DeleteSelectMessage")
    @ResponseBody
    public String DeleteSelectMessageC(HttpServletRequest request,String ids,HttpServletResponse response,String id) throws IOException {
//   	 System.out.println(ids);
//   	 System.out.println(id);
    String obj = null;
   	 boolean b = messageservice.DeleteSelectMessageS(ids);
   	 System.out.println("message的b "+b);
   	 obj = b + "";
//   	 response.getWriter().print(b);  
   	 return obj;
     }
}
