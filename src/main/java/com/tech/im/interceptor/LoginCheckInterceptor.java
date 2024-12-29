package com.tech.im.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

//요청이 이루어질 때 검증
public class LoginCheckInterceptor implements HandlerInterceptor{

	//preHandle 메소드는 컨트롤러의 요청이 실행되기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//현재 세션에 유저코드가 있는지 확인 _ 로그인 상태인지 확인하는 단계
		String user = (String) request.getSession().getAttribute("userCode");
		
		//비로그인 시 메인페이지로 이동
		if(user == null) {
			response.sendRedirect("/");
			return false;
		}
		//로그인 시 이동하려는 페이지로 이동가능
		return true;
		
	}
}
