package com.java.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.java.board.dto.BoardDto;
import com.java.myBatis.SqlManager;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	private SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;

	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
	}

	public int insert(BoardDto boardDto) {
		int value = 0;

		writeNumber(boardDto);

		try {
			session = sqlSessionFactory.openSession();
			value = session.insert("boardInsert", boardDto);
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return value;
	}

	private void writeNumber(BoardDto boardDto) {
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();

		try {
			// Root
			if (boardNumber == 0) {
				// 보드 테이블 값 탐색, 가장 높은 그룹 넘버 뽑아옴
				int boardGroupNumberMax = 0;
				session = sqlSessionFactory.openSession();
				boardGroupNumberMax = session.selectOne("boardGroupNumberMax");

				if (boardGroupNumberMax > 0) {
					boardDto.setGroupNumber(boardGroupNumberMax + 1);
				}
			}
			// 답글 - 글순서, 글레벨
			else {
				// 그룹 넘버와 일치하면서 현재 자신의 글순서 보다 큰번호는 +1
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("group_number", groupNumber);
				map.put("sequence_number", sequenceNumber);
				
				session = sqlSessionFactory.openSession();
				session.update("SequenceNumberUpdate", map);
				session.commit();
				
				boardDto.setSequenceNumber(sequenceNumber + 1); // 1
				boardDto.setSequenceLevel(sequenceLevel + 1); // 1
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public int getCount() {
		int count = 0;
			
		try {
			session = sqlSessionFactory.openSession();
			count = session.selectOne("boardCount");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return count;
	}

	public List<BoardDto> getBoardList(int startRow, int endRow) {
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		try {
			session = sqlSessionFactory.openSession();
			boardList = session.selectList("boardList", map);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return boardList;
	}

	public BoardDto read(int boardNumber) {
		BoardDto boardDto = null;

		try {
			// off auto-commit -> try-catch(if get exception rollback) -> commit

			// update
			session = sqlSessionFactory.openSession();
			session.update("boardReadCountUpdate", boardNumber);
			session.commit();
			
			// select
			boardDto = session.selectOne("boardReadSelect", boardNumber);

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}

		return boardDto;
	}
	
	public BoardDto getBoard(int boardNumber) {
		BoardDto boardDto = null;

		try {
			session = sqlSessionFactory.openSession();
			boardDto = session.selectOne("boardGetBoard", boardNumber);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return boardDto;
	}
	
	public int update(BoardDto boardDto) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.update("boardUpdate", boardDto);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
	
	public int delete(int boardNumber) {
		int check = 0;
		
		try {
			session = sqlSessionFactory.openSession();
			check = session.delete("boardDelete", boardNumber);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return check;
	}
}
