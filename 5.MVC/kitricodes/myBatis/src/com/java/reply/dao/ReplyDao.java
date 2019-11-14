package com.java.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.myBatis.SqlManager;
import com.java.reply.dto.ReplyDto;

public class ReplyDao {
	private static ReplyDao instance = new ReplyDao();
	private SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static ReplyDao getInstance() {
		return instance;
	}
	
	private ReplyDao() {}
	
	public int insert(ReplyDto replyDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.insert("replyInsert", replyDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public int getBunho() {
		int bunho = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			bunho = session.selectOne("replyGetBunho");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bunho;
	}
	
	public List<ReplyDto> getReplyList() {
		List<ReplyDto> replyList = null;
		
		try {
			session = sqlSessionFactory.openSession();
			replyList = session.selectList("replyGetList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return replyList;
	}
	
	public int delete(int bunho) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.delete("replyDelete", bunho);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public ReplyDto getReply(int bunho) {
		ReplyDto replyDto = null;
		
		try {
			session = sqlSessionFactory.openSession();
			replyDto = session.selectOne("replyGetDto", bunho);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return replyDto;
	}
	
	public int update(ReplyDto replyDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.update("replyUpdate", replyDto);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
}
