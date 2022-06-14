package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.ProductDAO;

@WebServlet("/productDelete.do")
public class productDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int code =  Integer.parseInt(request.getParameter("code"));
			//ProductDAO pDao = ProductDAO.getInstance();
		//	int result = pDao.productDelete(code);
			int result = ProductDAO.getInstance().productDelete(code); 
			if(result==1) {
				response.sendRedirect("ProductList.do");
			}else {
				System.out.println("삭제실패");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
