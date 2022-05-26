package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddtionSevvlet01")
public class AddtionSevvlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = 20;
		int num2 = 10;
		int add = num1 +num2;
		
		PrintWriter out =  response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Addition");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(num1 + " + " + num2 + "=" + add);
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("num1 + num2  = " + add);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
