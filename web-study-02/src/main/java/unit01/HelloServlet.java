package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/he")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html><body><h1>");
		out.print("Hello Servlet 김대철님 안녕하세요!!");
		out.print("</h1></body></html>");
		
		out.close();
	}

}
