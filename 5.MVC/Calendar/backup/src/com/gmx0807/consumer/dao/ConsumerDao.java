package com.gmx0807.consumer.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.gmx0807.consumer.dto.ConsumerDto;
import com.gmx0807.myBatis.SqlManager;

/**
 * @개발자 KJS
 * @작성일 2019. 11. 7.
 * @설명 consumer 테이블 dao
 */

public class ConsumerDao {
	private static ConsumerDao instance = new ConsumerDao();
	private SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static ConsumerDao getInstance() {
		return instance;
	}

	private ConsumerDao() {
	}
	
	public int insert(ConsumerDto consumerDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.insert("consumerRegister", consumerDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public int checkID(String id) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.selectOne("consumerCheckID", id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public boolean login(String id, String password) {
		int check = 0;
		boolean login = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);

		try {
			session = sqlSessionFactory.openSession();
			check = session.selectOne("consumerLogin", map);
			if(check > 0) {
				login = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return login;
	}
	
	public ConsumerDto getConsumer(String id, String password) {
		ConsumerDto consumerDto = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);

		try {
			session = sqlSessionFactory.openSession();
			consumerDto = session.selectOne("consumerGetConsumer", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return consumerDto;
	}
	
	public int update(ConsumerDto consumerDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.update("consumerUpdate", consumerDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public int delete(String id) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.delete("consumerDelete", id);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check; 
	}
	
}
