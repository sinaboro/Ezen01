package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

import util.DBManager;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		String url = "/board/boardView.jsp";
		
		String num = request.getParameter("num");
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		result = bDao.updateReadCount(num);
		
	//	System.out.println("result : " + result);  //카운트 증가 확인
		
		BoardVO vo  = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
