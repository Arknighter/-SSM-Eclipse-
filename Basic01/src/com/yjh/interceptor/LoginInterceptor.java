package com.yjh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yjh.po.Manager;
/**
 * 登入拦截器
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
		//获取请求的url
		String url = request.getRequestURI();
		//URL：除了登录请求外，其他的url都进行拦截控制
		if(url.indexOf("/login")>=0) {
			return true;
		}
		//获取session
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("MANAGER_SESSION");
		//判断Seesion有没有值
		if(manager!=null) {
			return true;
		}
		//不符合的
		request.setAttribute("msg", "你还没有登录，请先登登录！");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

}
