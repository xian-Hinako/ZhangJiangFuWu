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
			// TODO ��ȫջurl���й���
			//��request��response����ǿתΪhttp����
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			//��ȡ���ʵĵ�ַ
			String url = req.getRequestURI();
			System.out.println(url);
			//��ȡsession�еĶ����ж��Ƿ��¼
			//�������е� .do ���󵫲�����Text.do
			//jsp�ļ��Ѿ��ŵ�web-inf�� ���ù��� ֻ���� .do���󼴿�
			if(url.contains(".do")&&!url.contains("Text.do")&&!url.contains("Userlogin.do")&&!url.contains("AllMessage.do")&&!url.contains("listActivity.do")&&!url.contains("ToRegisterAndGetAddress.do")&&!url.contains("RegisterUser.do")&&!url.contains("UserNameAjax2.do")) {
				//��ȡsession
				HttpSession session = req.getSession();
				User user=(User) session.getAttribute("usersession");
				
				if(user==null){
					resp.sendRedirect("Userlogin.do");
					return;
				}
				
			}
			
			//����ִ�й�������ʣ�ಿ��
			chain.doFilter(req, resp);
		}

	    @Override
	    public void init(FilterConfig arg0) throws ServletException {
	        // TODO Auto-generated method stub

	    }
}
