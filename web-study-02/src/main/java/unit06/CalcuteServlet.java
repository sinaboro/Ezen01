package unit06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcuteServlet")
public class CalcuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		int num1 =  Integer.parseInt(request.getParameter("n1"));
		int num2 =  Integer.parseInt(request.getParameter("n2"));
		
		PrintWriter out  = response.getWriter();
		out.println("이름 : " + name);
		out.print("<br>");
		out.println(num1 + " + " + num2 + " = " + (num1+num2) );
		out.print("<br>");
		out.println(num1 + " * " + num2 + " = " + (num1*num2) );
		out.print("<br>");
		out.println(num1 + " - " + num2 + " = " + (num1-num2) );
		out.print("<br>");
		out.println(num1 + " / " + num2 + " = " + (num1/num2) );
		out.print("<br>");
		
	}

}
