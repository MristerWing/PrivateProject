package com.java.board.dao;

import java.util.List;
import java.util.Map;

import com.java.board.dto.BoardDto;

public interface BoardDao {
	public int boardWriteOk(BoardDto boardDto);

	public int findMaxGroupNumber();

	public int sequenceNumberUpdate(Map<String, Integer> sequenceAndGroupMap);

	public int getCount();

	public List<BoardDto> getBoardList(int startRow, int endRow);

	public BoardDto read(int boardNumber);

	public int update(BoardDto boardDto);

	public int delete(int boardNumber);

}
