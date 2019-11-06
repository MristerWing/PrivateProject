package com.calendar.calendar.command;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calendar.command.CommandAction;

public class CalendarAction implements CommandAction {
	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		int days = today.lengthOfMonth();
		
		request.setAttribute("month", month);
		request.setAttribute("days", days);
		
		logger.info(logMsg + month + "=" + days);
		return "/WEB-INF/view/calendar/calendar.jsp";
	}
}
