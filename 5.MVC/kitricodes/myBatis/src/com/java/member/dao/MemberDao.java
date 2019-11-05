package com.java.member.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;
import com.java.myBatis.SqlManager;

public class MemberDao {

	// Singleton, use one instance
	private static MemberDao instance = new MemberDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();

	// SqlsessionFactoryBulider() --> SqlSessionFactory --> sqlSession
	private SqlSession session;

	public static MemberDao getInstance() { // MemberDao.getInstance()
		return instance;
	}

	private MemberDao() {
	}

	public int insert(MemberDto memberDto) {
		int chk = 0;

		try {
			session = sqlSessionFactory.openSession();
			chk = session.insert("insert", memberDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return chk;
	}

	public int idCheck(String id) {
		int result = 0;

		try {
			session = sqlSessionFactory.openSession();
			String checkId = session.selectOne("idcheck", id);
			if (checkId != null)
				result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public List<ZipcodeDto> zipcodeReader(String dong) {
		List<ZipcodeDto> result = new ArrayList<ZipcodeDto>();

		try {
			session = sqlSessionFactory.openSession();
			result = session.selectList("zipcode", dong);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public String login(String id, String pwd) {
		String result = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);

		try {
			session = sqlSessionFactory.openSession();
			result = session.selectOne("login", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public MemberDto update(String id) {
		MemberDto result = new MemberDto();

		try {
			session = sqlSessionFactory.openSession();
			result = session.selectOne("update_select", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public int updateOk(MemberDto memberDto) {
		int result = 0;
		try {
			session = sqlSessionFactory.openSession();
			result = session.update("updateOk", memberDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	public int deleteOk(String id, String password) {
		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);

		try {
			session = sqlSessionFactory.openSession();
			result = session.delete("delete", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

}
