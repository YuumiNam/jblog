package com.bitacademy.jblog.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bitacademy.jblog.service.UserService;
import com.bitacademy.jblog.vo.UserVo;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// UserService userService = new UserService(); 이렇게 쓰면 안됨!! 새로운 객체를 생성해주는게 아닌 Autowired로 된 Service를 가져와야함
		UserVo authUser = userService.findUser(id, password);
		
		if(authUser == null) {
			request.setAttribute("id", id);
			request.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(request, response);
			
			return false;
		}
		
		System.out.println("Login : " + authUser);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		// System.out.println(session);
		
		response.sendRedirect(request.getContextPath());
		
		return false;
	}
	
	
}
