package com.java.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.java.board.dto.BoardDto;
import com.java.db.ConnectionProvider;
import com.java.db.JDBCUtil;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
	}

	public int insert(BoardDto boardDto) {
		int value = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		writeNumber(conn, boardDto);

		try {
			String sql = "insert into board values" + "(board_board_number_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, boardDto.getWriter());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getEmail());
			pstmt.setString(4, boardDto.getContent().replace("\r\n", "<br/>"));
			pstmt.setString(5, boardDto.getPassword());

			pstmt.setTimestamp(6, new Timestamp(boardDto.getWriteDate().getTime()));
			pstmt.setInt(7, boardDto.getReadCount());
			pstmt.setInt(8, boardDto.getGroupNumber());
			pstmt.setInt(9, boardDto.getSequenceNumber());
			pstmt.setInt(10, boardDto.getSequenceLevel());

			value = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return value;
	}

	private void writeNumber(Connection conn, BoardDto boardDto) {
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = null;

			// Root
			if (boardNumber == 0) {
				// 보드 테이블 값 탐색, 가장 높은 그룹 넘버 뽑아옴
				sql = "select max(group_number) from board";
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					boardDto.setGroupNumber(rs.getInt(1) + 1);
				}
			}
			// 답글 - 글순서, 글레벨
			else {
				// 그룹 넘버와 일치하면서 현재 자신의 글순서 보다 큰번호는 +1
				sql = "update board set sequence_number = sequence_number + 1 where group_number = ? and sequence_number > ?";
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, groupNumber);
				pstmt.setInt(2, sequenceNumber);
				pstmt.executeUpdate();

				boardDto.setSequenceNumber(sequenceNumber + 1); // 1
				boardDto.setSequenceLevel(sequenceLevel + 1); // 1
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

	}

	public int getCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) from board";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				count = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return count;
	}

	public ArrayList<BoardDto> getBoardList(int startRow, int endRow) {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select J.* from \r\n" + "(select rownum rn, I.* from\r\n"
					+ "(select * from board ORDER by group_number DESC, sequence_number asc) I) J\r\n"
					+ "where J.rn BETWEEN ? and ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));

				boardList.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return boardList;
	}

	public BoardDto read(int boardNumber) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// off auto-commit -> try-catch(if get exception rollback) -> commit

			// update
			String sqlUp = "Update board set read_count = read_count + 1 where board_number = ?";
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sqlUp);
			pstmt.setInt(1, boardNumber);
			pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();

			// select
			String sqlSelect = "select * from board where board_number = ?";
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, boardNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDto = new BoardDto();

				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
			}

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtil.rollBack(conn);
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return boardDto;
	}
	
	public BoardDto getBoard(int boardNumber) {
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from board where board_number = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDto = new BoardDto();

				boardDto.setBoardNumber(rs.getInt("board_number"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setPassword(rs.getString("password"));
				boardDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				boardDto.setReadCount(rs.getInt("read_count"));
				boardDto.setGroupNumber(rs.getInt("group_number"));
				boardDto.setSequenceNumber(rs.getInt("sequence_number"));
				boardDto.setSequenceLevel(rs.getInt("sequence_level"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return boardDto;
	}
	
	public int update(BoardDto boardDto) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "Update board set writer = ?, subject = ?, content = ?, write_date =? where board_number = ? and password = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getWriter());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			pstmt.setTimestamp(4, new Timestamp(boardDto.getWriteDate().getTime()));
			pstmt.setInt(5, boardDto.getBoardNumber());
			pstmt.setString(6, boardDto.getPassword());
			check = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return check;
	}
	
	public int delete(int boardNumber) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from board where board_number = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return check;
	}
}
