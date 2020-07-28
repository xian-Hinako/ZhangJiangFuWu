package com.VolunServices.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.SessionAttributes;

import com.VolunServices.pojo.User;

@SessionAttributes("usersession")
 public class LoginFilter implements Filter {
	 @Override
	    public void destroy() {
	        // TODO Auto-generated method stub

	    }

	 @Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			// TODO 对全栈url进行过滤
			//将request和response对象强转为http类型
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			//获取访问的地址
			String url = req.getRequestURI();
			System.out.println(url);
			//获取session中的对象判断是否登录
			//拦截所有的 .do 请求但不包含Text.do
			//jsp文件已经放到web-inf下 不用过滤 只过滤 .do请求即可
			if(url.contains(".do")&&!url.contains("Text.do")&&!url.contains("Userlogin.do")&&!url.contains("AllMessage.do")&&!url.contains("listActivity.do")&&!url.contains("ToRegisterAndGetAddress.do")&&!url.contains("RegisterUser.do")&&!url.contains("UserNameAjax2.do")) {
				//获取session
				HttpSession session = req.getSession();
				User user=(User) session.getAttribute("usersession");
				
				if(user==null){
					resp.sendRedirect("Userlogin.do");
					return;
				}
				
			}
			
			//继续执行过滤连的剩余部分
			chain.doFilter(req, resp);
		}

	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	        // TODO Auto-generated method stub

	    }
}
