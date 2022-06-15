package com.saeyan.controller.action;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void execute(HttpServletRequest request,  HttpServletResponse response) 
			throws ServletException, IOException;
				 
}
