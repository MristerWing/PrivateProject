package com.gmx0807.consumer.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;
import com.gmx0807.consumer.dto.ConsumerDto;

public class RegisterOkAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String findPassword = request.getParameter("findPassword");
		String name = request.getParameter("name");
		Date registerDate = new Date();
		
		ConsumerDto consumerDto = new ConsumerDto(id, password, email, findPassword, name, registerDate);
		
		int check = ConsumerDao.getInstance().insert(consumerDto);
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/consumer/registerOk.jsp";
	}

}
