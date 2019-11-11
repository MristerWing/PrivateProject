package com.gmx0807.calendar.command;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gmx0807.calendar.dao.CalendarDao;
import com.gmx0807.calendar.dto.EventDto;
import com.gmx0807.command.CommandAction;

public class CalendarAction implements CommandAction {

	@Override
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// get id
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");

		// get pageYear
		int year = getPageYear(request.getParameter("year"));

		// get Pageday
		LocalDate today = getPageDay(request.getParameter("month"), year);
		logger.info(logMsg + today);

		// date
		int month = today.getMonthValue();
		int days = today.lengthOfMonth();
		int dayOfWeek = today.getDayOfWeek().getValue();
		LocalDate dateLastMonth = LocalDate.of(year, month == 1 ? 12 : month - 1, 1);
		int lastDays = dateLastMonth.lengthOfMonth();
		int lastMonthStartDay = lastDays - (dayOfWeek - 1);
		boolean isSunday = false;
		if (dayOfWeek == 7)
			isSunday = true;

		// get time
		int hour = LocalTime.now().getHour();
		int minute = LocalTime.now().getMinute();
		minute -= minute % 10;

		// get event
		if (id != null) {
			List<EventDto> eventList = CalendarDao.getInstance().getEventList(id);
			// logger.info(logMsg + eventList.toString());
			HashMap<Integer, HashMap<Integer, Queue<Integer>>> printCalendarEventMap = getEventMap(eventList, month, lastDays);
			logger.info(logMsg + printCalendarEventMap.toString());

			request.setAttribute("eventList", eventList);
			request.setAttribute("printCalendarEventMap", printCalendarEventMap);
		}

		// get alarm

		// set request
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("days", days);
		request.setAttribute("lastMontStartDay", lastMonthStartDay);
		request.setAttribute("lastDays", lastDays);
		request.setAttribute("isSunday", isSunday);
		request.setAttribute("hour", hour);
		request.setAttribute("minute", minute);

		logger.info(logMsg + month + "=" + days + "\t" + lastDays);
		logger.info(logMsg + lastMonthStartDay);
		return "/WEB-INF/view/calendar/calendar.jsp";
	}

	private int getPageYear(String pageYear) {
		int year = 0;

		if (pageYear != null) {
			year = Integer.parseInt(pageYear);
		} else {
			year = LocalDate.now().getYear();
		}

		return year;
	}

	private LocalDate getPageDay(String pageMonth, int year) {
		LocalDate today = null;

		if (pageMonth != null) {
			int getMonth = Integer.parseInt(pageMonth);

			if (getMonth == 13) {
				today = LocalDate.of(++year, 1, 1);
			} else if (getMonth == 0) {
				today = LocalDate.of(--year, 12, 1);
			} else {
				today = LocalDate.of(year, getMonth, 1);
			}
		} else {
			today = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
		}

		return today;
	}

	// 이벤트 코드에 해당하는 날짜들의 큐를 생성한다. 이후 출력에서 사용
	private HashMap<Integer, HashMap<Integer, Queue<Integer>>> getEventMap(List<EventDto> evantList, int month, int lastDays) {
		HashMap<Integer, Queue<Integer>> map = new HashMap<Integer, Queue<Integer>>();
		HashMap<Integer, HashMap<Integer, Queue<Integer>>> eventMap = new HashMap<Integer, HashMap<Integer, Queue<Integer>>>();

		for (EventDto dto : evantList) {
			Queue<Integer> eventdays = new LinkedList<Integer>();

			LocalDateTime startDate = LocalDateTime.ofInstant(dto.getStartDate().toInstant(), ZoneId.systemDefault());
			LocalDateTime endDate = LocalDateTime.ofInstant(dto.getEndDate().toInstant(), ZoneId.systemDefault());

			if (startDate.getMonthValue() == month) {
				// 큐에 이벤트에 해당하는 날짜를 추가
				if (startDate.getMonth() == endDate.getMonth()) {
					for (int i = startDate.getDayOfMonth(); i <= endDate.getDayOfMonth(); i++) {
						eventdays.offer(i);
					}
					map.put(month, eventdays);
				}

				// 이번달 ~ 다른달 이벤트
				else {
					Queue<Integer> eventdays2 = new LinkedList<Integer>();
					if (startDate.getDayOfMonth() > endDate.getDayOfMonth()) {

						// this month
						for (int i = startDate.getDayOfMonth(); i <= lastDays; i++) {
							eventdays.offer(i);
						}
						map.put(month, eventdays);

						// next month
						for (int i = 1; i <= endDate.getDayOfMonth(); i++) {
							eventdays2.offer(i);
						}
						map.put(month + 1, eventdays2);
					} 
					
					// long event
					else {

					}
				}
			}
			logger.info(logMsg + map.toString());
			eventMap.put(dto.getEventCode(), map);
			map = new HashMap<Integer, Queue<Integer>>();
		}

		return eventMap;
	}
}
