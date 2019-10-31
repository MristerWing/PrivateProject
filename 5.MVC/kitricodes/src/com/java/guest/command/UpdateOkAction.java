package com.java.guest.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		GuestDto guestDto = new GuestDto();
		guestDto.setNum(Integer.parseInt(request.getParameter("num")));
		//guestDto.setPassword(request.getParameter("pwd"));
		guestDto.setMessage(request.getParameter("message"));
		guestDto.setWriteDate(new Date());
		logger.info(logMsg + guestDto.toString());
		
		int check = GuestDao.getInstance().updateOk(guestDto);
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/view/guest/updateOk.jsp";
	}

}
