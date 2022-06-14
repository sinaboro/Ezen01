package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/productUpdate.do")
public class productUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String code = request.getParameter("code");
			
			ProductDAO pDao = ProductDAO.getInstance();
			MemberVO pVo =  pDao.selectProductByCode(code);
			
			request.setAttribute("product", pVo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 
		 //cos file upload 하기 위해서
		 ServletContext context = getServletContext();
		 String path = context.getRealPath("upload");
		 String encType = "utf-8";
		 int sizeLimit = 20*1024*1024;
		 MultipartRequest multi = new MultipartRequest(
				 request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		 
		 String code = multi.getParameter("code");
		 String name = multi.getParameter("name");
		 String price = multi.getParameter("price");
		 String description = multi.getParameter("description");
		 String pictureUrl = multi.getFilesystemName("pictureUrl");
		 
		 if( pictureUrl ==null) {
			 pictureUrl = multi.getParameter("nonmakeImg");
		 }
		 
		 MemberVO pVo = new MemberVO();
		 pVo.setCode(Integer.parseInt(code));
		 pVo.setPrice(Integer.parseInt(price));
		 pVo.setName(name);
		 pVo.setDescription(description);
		 pVo.setPictureurl(pictureUrl);
		 
		 ProductDAO pDao = ProductDAO.getInstance();
		 int result = pDao.updateProduct(pVo);
		 
		 if(result == 1)
			 response.sendRedirect("ProductList.do");
		 else
			 response.sendRedirect("productWrite.jsp");
		 
	}

}
