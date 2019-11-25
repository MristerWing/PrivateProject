package com.java.dao;

import java.util.List;

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

	@Override
	public List<FriendDto> printAll() {
		List<FriendDto> friendList;

		friendList = sqlSessionTemplate.selectList("friendSelectAll");

		return friendList;
	}

	@Override
	public List<FriendDto> searchAndPrint(String name) {
		List<FriendDto> friendList;

		friendList = sqlSessionTemplate.selectList("friendSelectSearch", name);

		return friendList;
	}

	@Override
	public int update(FriendDto friendDto) {
		int check = 0;

		check = sqlSessionTemplate.update("friendUpdate", friendDto);

		return check;
	}

	@Override
	public int delete(int num) {
		int check = 0;

		check = sqlSessionTemplate.delete("friendDelete", num);

		return check;
	}

}
