package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@WebServlet(name = "action", urlPatterns = { "*.do" })
public class DispatcherServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() {
		System.out.println("DispatcherServlet Init()-------------------------");
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri ==> " + uri + " : " +  path);
	
		//2. HandlerMapping을 통해서 path에 해당하는 Controller를 검색한다.
		Controller ctrl = handlerMapping.getController(path);
		//3. 검색된 Controller를 실행
		String viewName = ctrl.handleRequest(request, response); // login
		
		//4. ViewResolver를 통해 viewName에 해당하는 화면을 검색
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);  //./login.jsp
			System.out.println("view======> " + view);
		}else {
			view = viewName;
		}
		//5. 검색된 화면으로 이동
		response.sendRedirect(view);
	}
	
	/*private void process(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		request.setCharacterEncoding("utf-8");
		//1. 클라이언트의 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("uri ==> " + uri + " : " +  path);
		//2. 클라이언트의 요청 path에 따라 적절히 분기처리한다.
		if(path.equals("/login.do")) {
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
				response.sendRedirect("getBoardList.do");
			}else{
				response.sendRedirect("login.jsp");
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			request.setCharacterEncoding("utf-8");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String regDate = request.getParameter("regDate");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			//vo.setRegDate(regDate);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			request.setCharacterEncoding("utf-8");

			int seq = Integer.parseInt(request.getParameter("seq")); 
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			vo.setTitle(title);
			vo.setContent(content);
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			request.setCharacterEncoding("utf-8");

			String seq =  request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			request.setCharacterEncoding("utf-8");
			String seq = request.getParameter("seq");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
		
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			response.sendRedirect("getBoard.jsp");
			
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			
			request.setCharacterEncoding("utf-8");
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			//3. 검색 결과를 세센에 저장하고 목록 화면으로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			response.sendRedirect("getBoardList.jsp");
		}
	}*/

}
