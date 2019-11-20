package com.java.parsing.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class ParsingAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//return "/WEB-INF/view/parsing/pXML.jsp";
		
		
		return "/WEB-INF/view/parsing/jqueryXML.jsp";
	}

}
