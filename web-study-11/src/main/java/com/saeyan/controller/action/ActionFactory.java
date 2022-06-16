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
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardFromAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		return action;
	}
	

}
