package com.jafa.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		System.out.println("로그인 성공");
		System.out.println(auth.getAuthorities());
		List<String> roleName = new ArrayList<>();
//		Collection타입
		auth.getAuthorities().forEach(authority ->{
			roleName.add(authority.getAuthority());
		});
		if(roleName.contains("ROLE_ADMIN")) {
			System.out.println("관리자 로그인");
			response.sendRedirect(request.getContextPath()+"/security/admin");
			return;
		}
		if(roleName.contains("ROLE_MEMBER")) {
			System.out.println("회원 로그인");
			response.sendRedirect(request.getContextPath()+"/security/member");
			return;
		}	
		response.sendRedirect(request.getContextPath()+"/");
	}
}
