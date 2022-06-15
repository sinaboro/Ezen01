package com.saeyan.controller.action;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			String url = "/board/boardList.jsp";
			BoardDAO bDao = BoardDAO.getInstance();
			List<BoardVO> boardList  = bDao.selectAllBoards();
			request.setAttribute("boardList", boardList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}
	
}
