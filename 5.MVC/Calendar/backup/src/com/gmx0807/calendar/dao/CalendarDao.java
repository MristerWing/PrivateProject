package com.gmx0807.calendar.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gmx0807.calendar.dto.EventDto;
import com.gmx0807.myBatis.SqlManager;

/**
 * @개발자 KJS
 * @작성일 2019. 11. 8.
 * @설명 
 */

public class CalendarDao {
	private static CalendarDao instance = new CalendarDao();
	SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	SqlSession session;
	
	private CalendarDao () {}
	
	public static CalendarDao getInstance() {
		return instance;
	}
	
	// event
	public int eventInsert(EventDto eventDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.insert("eventRegister", eventDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public List<EventDto> getEventList(String id) {
		List<EventDto> eventList = null;
		
		try {
			session = sqlSessionFactory.openSession();
			eventList = session.selectList("eventGetList", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return eventList;
	}
 	
	
	//alram
}
