package com.java.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.board.dto.BoardDto;

/**
 * @author KimJinsu
 * @Date 2019.11.26
 * @apiNote DB연동을 위한 DAO객체
 */

@Component
public class BoardDaoImp implements BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int boardWriteOk(BoardDto boardDto) {
		return sqlSessionTemplate.insert("boardInsert", boardDto);
	}

	@Override
	public int findMaxGroupNumber() {
		return sqlSessionTemplate.selectOne("boardGroupNumberMax");
	}

	@Override
	public int sequenceNumberUpdate(Map<String, Integer> sequenceAndGroupMap) {
		return sqlSessionTemplate.update("sequenceNumberUpdate",
				sequenceAndGroupMap);
	}

	@Override
	public int getCount() {
		return sqlSessionTemplate.selectOne("boardCount");
	}

	@Override
	public List<BoardDto> getBoardList(int startRow, int endRow) {
		Map<String, Integer> rowMap = new HashMap<String, Integer>();
		rowMap.put("startRow", startRow);
		rowMap.put("endRow", endRow);

		return sqlSessionTemplate.selectList("boardList", rowMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public BoardDto read(int boardNumber) {
		BoardDto boardDto = null;
		sqlSessionTemplate.update("boardReadCountUpdate", boardNumber);

		boardDto = sqlSessionTemplate.selectOne("boardReadSelect", boardNumber);

		return boardDto;
	}

	@Override
	public int update(BoardDto boardDto) {
		return sqlSessionTemplate.update("boardUpdate", boardDto);
	}

	@Override
	public int delete(int boardNumber) {
		return sqlSessionTemplate.delete("boardDelete", boardNumber);
	}

}
