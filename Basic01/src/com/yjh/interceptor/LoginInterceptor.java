package com.yjh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjh.po.Manager;
/**
 * ����������
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//��ȡ�����url
		String url = request.getRequestURI();
		//URL�����˵�¼�����⣬������url���������ؿ���
		if(url.indexOf("/login")>=0) {
			return true;
		}
		//��ȡsession
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("MANAGER_SESSION");
		//�ж�Seesion��û��ֵ
		if(manager!=null) {
			return true;
		}
		//�����ϵ�
		request.setAttribute("msg", "�㻹û�е�¼�����ȵǵ�¼��");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
