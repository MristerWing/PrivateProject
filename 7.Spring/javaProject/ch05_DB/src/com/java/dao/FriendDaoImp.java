package com.java.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.dto.FriendDto;

public class FriendDaoImp implements FriendDao {
	private SqlSessionTemplate sqlSessionTemplate; // SqlSessionFactory +

	public FriendDaoImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insert(FriendDto friendDto) {
		int check = 0;

		// sqlSessionTemplate.getSqlSessionFactory().openSession();
		check = sqlSessionTemplate.insert("friendInsert", friendDto);

		return check;
	}

}
