package com.java.sawon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.myBatis.SqlManager;

public class SawonDao {
	private static SawonDao instance = new SawonDao();
	private SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static SawonDao getInstance() {
		return instance;
	}
	
	private SawonDao() {}
	
	public List<SawonDto> select(String departmentName) {
		List<SawonDto> sawonList = null;
		
		try {
			session = sqlSessionFactory.openSession();
			sawonList = session.selectList("sawonSelect", departmentName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return sawonList;
	}
}
