package com.gmx0807.consumer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmx0807.command.CommandAction;
import com.gmx0807.consumer.dao.ConsumerDao;
import com.gmx0807.consumer.dto.ConsumerDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String findPassword = request.getParameter("findPassword");
		
		ConsumerDto consumerDto = new ConsumerDto();
		consumerDto.setId(id);
		consumerDto.setPassword(password);
		consumerDto.setEmail(email);
		consumerDto.setFindPassword(findPassword);
		
		int check = ConsumerDao.getInstance().update(consumerDto);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/consumer/updateOk.jsp";
	}

}
