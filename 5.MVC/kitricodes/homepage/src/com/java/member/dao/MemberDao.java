package com.java.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.db.ConnectionProvider;
import com.java.db.JDBCUtil;
import com.java.member.dto.MemberDto;
import com.java.member.dto.ZipcodeDto;

public class MemberDao {

	// Singleton, use one instance
	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() { // MemberDao.getInstance()
		return instance;
	}

	private MemberDao() {
	}

	public int insert(MemberDto memberDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int chk = 0;
		String sql = "insert into member values" + "(member_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ConnectionProvider.getConnection(); // conn db
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			pstmt.setString(3, memberDto.getName());
			pstmt.setString(4, memberDto.getJumin1());
			pstmt.setString(5, memberDto.getJumin2());

			pstmt.setString(6, memberDto.getEmail());
			pstmt.setString(7, memberDto.getZipcode());
			pstmt.setString(8, memberDto.getAddress());
			pstmt.setString(9, memberDto.getJob());
			pstmt.setString(10, memberDto.getMailing());

			pstmt.setString(11, memberDto.getInterest());
			pstmt.setString(12, memberDto.getMemberLevel());
			pstmt.setTimestamp(13, new Timestamp(memberDto.getRegisterDate().getTime()));

			chk = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				JDBCUtil.close(pstmt);
			if (conn != null)
				JDBCUtil.close(conn);
		}

		return chk;
	}

	public int idCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			String sql = "select id from member where id=?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return result;
	}

	public ArrayList<ZipcodeDto> zipcodeReader(String chkDong) {
		ArrayList<ZipcodeDto> result = new ArrayList<ZipcodeDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from ZIPCODE where dong = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chkDong);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeDto tmp = new ZipcodeDto();
				tmp.setZipcode(rs.getString("zipcode"));
				tmp.setSido(rs.getString("sido"));
				tmp.setGugun(rs.getString("gugun"));
				tmp.setDong(rs.getString("dong"));
				tmp.setRi(rs.getString("ri"));
				tmp.setBunji(rs.getString("bunji"));

				result.add(tmp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return result;
	}

	public String login(String id, String pwd) {
		String result = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select member_level from member where id = ? and password = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getString("member_level");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return result;
	}

}
