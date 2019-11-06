package com.java.guest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.guest.dto.GuestDto;
import com.java.myBatis.SqlManager;

public class GuestDao {
	private static GuestDao instance = new GuestDao();
	private SqlSessionFactory sqlFSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static GuestDao getInstance() {
		return instance;
	}
	
	private GuestDao() {}
	
	public int insert(GuestDto guestDto) {
		int check = 0;
		
		try {
			session = sqlFSessionFactory.openSession();
			check = session.insert("guestInsert", guestDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return check;
	}
	
	public List<GuestDto> guestList(int startRow, int endRow) {
		List<GuestDto> arrayList = new ArrayList<GuestDto>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		try {
			session = sqlFSessionFactory.openSession();
			arrayList = session.selectList("guestListSelect", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return arrayList;
	}
	
	public int getCount() {
		int count = 0;
		
		try {
			session = sqlFSessionFactory.openSession();
			count = session.selectOne("guestCountSelect");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return count;
	}
	
	public int delete(int num) {
		int check = 0;
		
		try {
			session = sqlFSessionFactory.openSession();
			check = session.delete("guestDelete", num);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return check;
	}
	
	public GuestDto update(int num) {
		GuestDto guestDto = null;
		
		try {
			session = sqlFSessionFactory.openSession();
			guestDto = session.selectOne("guestSelect", num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return guestDto;
	}
	
	public int updateOk(GuestDto guestDto) {
		int check = 0;
		
		try {
			session = sqlFSessionFactory.openSession();
			check = session.update("guestUpdate", guestDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return check;
	}
}
