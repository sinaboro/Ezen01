package com.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDAO;
import com.movie.dto.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/movieWrite.do")
public class movieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("movie/movieWrite.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("images");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024;  //20mb
		
		MultipartRequest multi = new MultipartRequest(
					request, path,  sizeLimit, encType, new DefaultFileRenamePolicy()
				);
		String title = multi.getParameter("title");
		int price  = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");
		String poster = multi.getFilesystemName("poster");
		
		MovieVO pVo = new MovieVO();
		pVo.setTitle(title);
		pVo.setPrice(price);
		pVo.setDirector(director);
		pVo.setActor(actor);
		pVo.setSynopsis(synopsis);
		pVo.setPoster(poster);
		
		MovieDAO pDao = MovieDAO.getInstance();
		int result = pDao.insertMovie(pVo);
		if( result == 1) {
				response.sendRedirect("movieList.do");
		}else{
				response.sendRedirect("/movie/movieWrite.jsp");
		}
	}

}
