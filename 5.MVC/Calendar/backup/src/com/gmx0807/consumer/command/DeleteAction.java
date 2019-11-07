package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;

public class DeleteAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		
		int check = ConsumerDao.getInstance().delete(id);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/consumer/delete.jsp";
	}

}
