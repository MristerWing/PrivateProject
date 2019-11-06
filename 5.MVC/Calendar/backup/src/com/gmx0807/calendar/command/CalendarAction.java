package com.gmx0807.calendar.command;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.command.CommandAction;

public class CalendarAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LocalDate today = LocalDate.now();
		//LocalDate today = LocalDate.of(2019, 12, 1); //nextMonth test
		int month = today.getMonthValue();
		int days = today.lengthOfMonth();
		int dayOfWeek = today.getDayOfWeek().getValue();
		int weekLessDay = days % 7;
		int lastMontLessDays = 6 - weekLessDay;
		//int everyWeek = days / 7;
		LocalDate dateLastMonth = LocalDate.of(today.getYear(), month -1, 1);
		int lastDays = dateLastMonth.lengthOfMonth();
		int lastMonthStartDay = lastDays - lastMontLessDays;
		boolean isSunday = false;
		if(dayOfWeek == 7) isSunday = true;

		request.setAttribute("month", month);
		request.setAttribute("days", days);
		request.setAttribute("lastMontStartDay", lastMonthStartDay);
		request.setAttribute("lastDays", lastDays);
		request.setAttribute("weekLessDay", weekLessDay);
		request.setAttribute("isSunday", isSunday);
		//request.setAttribute("everyWeek", everyWeek);

		logger.info(logMsg + month + "=" + days + "\t" + lastDays + "\t" + dayOfWeek);
		return "/WEB-INF/view/calendar/calendar.jsp";
	}

}
