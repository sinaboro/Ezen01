package com.springbook.view.controller;

public class ViewResolver {
	public String prefix, suffix;

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getView(String viewName) {  //      ./login.jsp
		return prefix + viewName + suffix;
	}
	
}
