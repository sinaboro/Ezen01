package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.ActionFactory;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String command = request.getParameter("command");
			System.out.println("EmployeesServlet");
			ActionFactory af = ActionFactory.getInstance();
			Action action = af.getAction(command);
			
			if(action != null) {
				action.execute(request, response);
			}
					
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			doGet(request, response);
	}

}
