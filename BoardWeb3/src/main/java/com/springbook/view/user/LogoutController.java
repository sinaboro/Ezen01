package com.springbook.view.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		
		session.invalidate();
		return "login.jsp";
	}
	
}
