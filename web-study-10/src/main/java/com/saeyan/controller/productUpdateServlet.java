package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String code = request.getParameter("code");
			
			ProductDAO pDao = ProductDAO.getInstance();
			ProductVO pVo =  pDao.selectProductByCode(code);
			
			request.setAttribute("product", pVo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
