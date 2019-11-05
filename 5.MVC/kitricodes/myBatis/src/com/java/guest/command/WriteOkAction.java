package com.java.guest.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class WriteOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		GuestDto guestDto = new GuestDto();
		guestDto.setName(request.getParameter("name"));
		guestDto.setPassword(request.getParameter("pwd"));
		guestDto.setMessage(request.getParameter("message"));
		guestDto.setWriteDate(new Date());
		
		logger.info(logMsg + guestDto.toString());
		
		int check = GuestDao.getInstance().insert(guestDto);
		
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/guest/writeOk.jsp";
	}

}
