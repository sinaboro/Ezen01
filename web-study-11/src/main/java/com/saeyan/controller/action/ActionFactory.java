package com.saeyan.controller.action;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}
		return action;
	}
	

}
