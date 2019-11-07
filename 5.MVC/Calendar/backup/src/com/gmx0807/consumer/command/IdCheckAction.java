package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;

public class IdCheckAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("ID");
		int check = ConsumerDao.getInstance().checkID(id);
		logger.info(logMsg + check);
		
		request.setAttribute("ID", id);
		request.setAttribute("check", check);
		return "/WEB-INF/view/consumer/idCheck.jsp";
	}

}
