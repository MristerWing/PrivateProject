package com.java.fileBoard.dao;

import java.util.List;
import java.util.Map;

import com.java.fileBoard.dto.FileBoardDto;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote fileBoard DAO Interface
 */
public interface FileBoardDao {
	public int insert(FileBoardDto fileBoardDto);

	public int findMaxGroupNumber();

	public int sequenceNumberUpdate(Map<String, Integer> sequenceAndGroupMap);

	public int getCount();

	public List<FileBoardDto> getBoardList(int startRow, int endRow);

	public FileBoardDto read(int boardNumber);

	public FileBoardDto getBoard(int boardNumber);

	public int update(FileBoardDto fileBoardDto);

	public int delete(int boardNumber);
}
