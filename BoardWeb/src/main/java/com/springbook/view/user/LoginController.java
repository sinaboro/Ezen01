package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.view.controller.Controller;
import com.springbook.view.controller.HandlerMapping;
import com.springbook.view.controller.ViewResolver;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
			System.out.println("로그인 처리");
			String id = request.getParameter("id");
			String passwrod = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(passwrod);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			if(user != null){
				//센션등록
				return "getBoardList.do";
			}else{
				return "login";
			}
	}
}
