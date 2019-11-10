package com.gmx0807.calendar.command;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmx0807.calendar.dao.CalendarDao;
import com.gmx0807.calendar.dto.EventDto;
import com.gmx0807.command.CommandAction;

public class EventAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		String attendee = request.getParameter("attendee");
		String loc = request.getParameter("loc");
		String explan = request.getParameter("explan");
		String title = request.getParameter("title");
		
		// parse date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startDate = format.parse(start);
		Date endDate = format.parse(end);
		
		EventDto eventDto = new EventDto();
		eventDto.setId(id);
		eventDto.setStartDate(startDate);
		eventDto.setEndDate(endDate);
		eventDto.setAttendee(attendee);
		eventDto.setLoc(loc);
		eventDto.setExplan(explan);
		eventDto.setTitle(title);
		
		int check = CalendarDao.getInstance().eventInsert(eventDto);
		logger.info(logMsg + check);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/calendar/event.jsp";
	}
}
