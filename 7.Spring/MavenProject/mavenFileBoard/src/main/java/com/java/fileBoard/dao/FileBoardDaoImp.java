package com.java.fileBoard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.java.fileBoard.dto.FileBoardDto;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote fileBoard DAO
 */
public class FileBoardDaoImp implements FileBoardDao {
	private SqlSessionTemplate sqlSessionTemplate;

	public FileBoardDaoImp() {
	}

	public FileBoardDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insert(FileBoardDto fileBoardDto) {
		if (fileBoardDto.getFileName() != null)
			return sqlSessionTemplate.insert(
					"mapper.FileboardMapper.fileBoardInsertFile", fileBoardDto);
		else
			return sqlSessionTemplate.insert(
					"mapper.FileboardMapper.fileBoardInsert", fileBoardDto);
	}

	@Override
	public int findMaxGroupNumber() {
		return sqlSessionTemplate
				.selectOne("mapper.FileboardMapper.fileBoardGroupNumberMax");
	}

	@Override
	public int sequenceNumberUpdate(Map<String, Integer> sequenceAndGroupMap) {
		return sqlSessionTemplate.update(
				"mapper.FileboardMapper.fileSequenceNumberUpdate",
				sequenceAndGroupMap);
	}

	@Override
	public int getCount() {
		return sqlSessionTemplate
				.selectOne("mapper.FileboardMapper.fileBoardCount");
	}

	@Override
	public List<FileBoardDto> getBoardList(int startRow, int endRow) {
		Map<String, Integer> rowMap = new HashMap<String, Integer>();
		rowMap.put("startRow", startRow);
		rowMap.put("endRow", endRow);

		return sqlSessionTemplate
				.selectList("mapper.FileboardMapper.fileBoardList", rowMap);
	}

	@Override
	public FileBoardDto read(int boardNumber) {
		sqlSessionTemplate.update("fileBoardReadCountUpdate", boardNumber);

		return sqlSessionTemplate.selectOne("fileBoardReadSelect", boardNumber);
	}

	@Override
	public FileBoardDto getBoard(int boardNumber) {
		return sqlSessionTemplate.selectOne("fileBoardGetBoard", boardNumber);
	}

	@Override
	public int update(FileBoardDto fileBoardDto) {
		return sqlSessionTemplate.update("fileBoardUpdate", fileBoardDto);
	}

	@Override
	public int delete(int boardNumber) {
		return sqlSessionTemplate.delete("fileBoardDelete", boardNumber);
	}
}
