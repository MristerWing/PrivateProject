package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;

public class LoginCheckAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		
		boolean isLogin = ConsumerDao.getInstance().login(id, password);
		logger.info(logMsg + isLogin);
		
		if(isLogin) {
			request.setAttribute("ID", id);
		} 
		
		return "/WEB-INF/view/consumer/loginCheck.jsp";
	}

}
