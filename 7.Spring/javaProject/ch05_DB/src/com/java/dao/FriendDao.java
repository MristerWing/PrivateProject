package com.java.dao;

import java.util.List;

import com.java.dto.FriendDto;

public interface FriendDao {
	public int insert(FriendDto friendDto);

	public List<FriendDto> printAll();

	public List<FriendDto> searchAndPrint(String name);

	public int update(FriendDto friendDto);

	public int delete(int num);
}
