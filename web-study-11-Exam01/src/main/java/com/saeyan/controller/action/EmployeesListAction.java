package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.EmployeesDAO;
import com.saeyan.dto.EmployeesVO;

public class EmployeesListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employees/employeesList.jsp";
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		List<EmployeesVO> employeesList  = eDao.selectAllBoards();
		request.setAttribute("employeesList", employeesList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
