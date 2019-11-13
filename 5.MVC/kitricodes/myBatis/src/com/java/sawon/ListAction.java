package com.java.sawon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class ListAction implements CommandAction {
 @Override
public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	// TODO Auto-generated method stub
	return "/WEB-INF/view/sawon/list.jsp";
}
}
