package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;
import com.gmx0807.consumer.dto.ConsumerDto;

public class UpdateAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		String password = request.getParameter("password");
		
		ConsumerDto consumerDto = ConsumerDao.getInstance().getConsumer(id, password);
		
		request.setAttribute("consumerDto", consumerDto);
		
		return "/WEB-INF/view/consumer/update.jsp";
	}

}
