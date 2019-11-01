package com.java.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.java.db.ConnectionProvider;
import com.java.db.JDBCUtil;
import com.java.guest.dto.GuestDto;

public class GuestDao {
	private static GuestDao instance = new GuestDao();
	
	public static GuestDao getInstance() {
		return instance;
	}
	
	private GuestDao() {}
	
	public int insert(GuestDto guestDto) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into guest values" + "(guest_num_seq.nextval, ?, ?, ?, ?)";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, guestDto.getName());
			pstmt.setString(2, guestDto.getPassword());
			pstmt.setString(3, guestDto.getMessage());
			pstmt.setTimestamp(4, new Timestamp(guestDto.getWriteDate().getTime()));
			
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return check;
	}
	
	public ArrayList<GuestDto> guestList(int startRow, int endRow) {
		ArrayList<GuestDto> arrayList = new ArrayList<GuestDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from\r\n" + 
					"(select rownum as rn, page.* from\r\n" + 
					"(select * from guest ORDER BY num DESC) page) list\r\n" + 
					"where list.rn BETWEEN ? and ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GuestDto guestDto = new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message"));
				guestDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				
				arrayList.add(guestDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return arrayList;
	}
	
	public int getCount() {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from guest";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return count;
	}
	
	public int delete(int num) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from guest where num = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return check;
	}
	
	public GuestDto update(int num) {
		GuestDto guestDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from guest where num = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				guestDto = new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message"));
				guestDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return guestDto;
	}
	
	public int updateOk(GuestDto guestDto) {
		int check = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update guest set message = ?, write_date = ? where num = ?"; //password = ?
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, guestDto.getPassword());
			pstmt.setString(1, guestDto.getMessage());
			pstmt.setTimestamp(2, new Timestamp(guestDto.getWriteDate().getTime()));
			pstmt.setInt(3, guestDto.getNum());
			
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		
		return check;
	}
}
