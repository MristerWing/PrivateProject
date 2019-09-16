package com.gmx0807.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeptData {
	// Create Connection
	private final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // direct conn
	private final String USER = "scott";
	private final String PASSWORD = "tiger";

	// 연결 유지
	private Connection conn = null;
	// Using Connection(using sql query)
	private Statement stmt = null;
	// DB Return value
	private ResultSet rs = null;
	//pre
	private PreparedStatement pstmt = null;

	// define data
	public ArrayList<DeptBean> defData() {
		ArrayList<DeptBean> dept = new ArrayList<DeptBean>();

		// Load Oracle DB and Add ArrayList
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt = conn.createStatement();

			// select, return ResultSet
			String sql = "SELECT deptno, dname, loc FROM dept";
			rs = stmt.executeQuery(sql);

			// get ResultSet(iterator)
			while (rs.next()) {
				dept.add(new DeptBean(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			// insert, update, delete(ddl), return int
//			stmt.executeUpdate("");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			// close Connection
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dept;
	}

	// find unique deptno
	public DeptBean getDept(String deptno) {
		DeptBean result = null;

		// Load Oracle DB and Add ArrayList
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt = conn.createStatement();

			// select, return ResultSet
			String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = " + deptno;
			rs = stmt.executeQuery(sql);

			// get ResultSet(iterator)
			if(rs.next()) {
				result = new DeptBean(rs.getInt(1), rs.getString(2), rs.getString(3));
			}else {
				result = new DeptBean(-1);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			// close Connection
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;

	}
	
	// 부서 추가
		public void addDept(DeptBean dept) {
			String sql = "INSERT INTO dept(deptno, dname, loc) ";
			String sql2 = "VALUES(?, ?, ?)"; //pre stmt 사용
			
			// connection
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// pre statement
			try {
				//prepareStatement 에서 자동으로 배치를 해줌
				pstmt = conn.prepareStatement(sql + sql2); 
				
				//데이터 입력
				pstmt.setInt(1, dept.getDeptno());
				pstmt.setString(2, dept.getDname());
				pstmt.setString(3, dept.getLoc());
				
				//query문 생성
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// close Connection
				try {
					// 순서 반드시 지켜야함
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//부서 삭제
		public void deleteDept(String deptno) {
			String sql = "DELETE FROM dept WHERE deptno = ?";
			int isDel = -1;

			// connection
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// turnOff commit
			try {
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(deptno));
				isDel = pstmt.executeUpdate();
				
				//commit
				if(isDel == 1) conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//rollback
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				// close Connection
				try {
					conn.setAutoCommit(true);
					// 순서 반드시 지켜야함
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//부서 수정
		public void fixDept(DeptBean dept) {
			String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno = " + dept.getDeptno();

			// connection
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// turnOff commit
			try {
				conn.setAutoCommit(false);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dept.getDname());
				pstmt.setString(2, dept.getLoc());
				pstmt.executeUpdate();
				
				//commit
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//rollback
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} finally {
				// close Connection
				try {
					conn.setAutoCommit(true);
					// 순서 반드시 지켜야함
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
