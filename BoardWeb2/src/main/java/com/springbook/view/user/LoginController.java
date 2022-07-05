package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController  {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO UserDAO){
			if(UserDAO.getUser(vo) != null) {
				return "getBoardList.do";
			}else {
				return "login.jsp";
			}
	}
}
