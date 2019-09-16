package com.gmx0807.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//기초 데이터 세팅
public class EmpData {
	// Create Connection
	private final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // direct conn
	private final String USER = "scott";
	private final String PASSWORD = "tiger";

	private Connection conn = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	// define data
	public ArrayList<EmpBean> defData() {
		ArrayList<EmpBean> emp = new ArrayList<EmpBean>();

		// Load Oracle DB and Add ArrayList

		String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp";

		// connection
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// statement, result
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// get result
			while (rs.next()) {
				emp.add(new EmpBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getDouble(7), rs.getInt(8)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close Connection
			try {
				// 순서 반드시 지켜야함
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

		return emp;
	}

	// 특정 사원정보 조회 후 값 세팅하기
	public EmpBean getEmp(String empno) {
		EmpBean result = null;
		String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp WHERE empno = " + empno;

		// connection
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// statement, result
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			// get result
			if (rs.next()) {
				result = new EmpBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
			} else {
				result = new EmpBean(-1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close Connection
			try {
				// 순서 반드시 지켜야함
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

	// 사원 추가
	public void addEmp(EmpBean emp) {
		String sql = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ";
		String sql2 = "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"; // pre stmt 사용

		// connection
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// pre statement
		try {
			// prepareStatement 에서 자동으로 배치를 해줌
			pstmt = conn.prepareStatement(sql + sql2);

			// 데이터 입력
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setString(5, emp.getHiredate());
			pstmt.setDouble(6, emp.getSal());
			pstmt.setDouble(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());

			// query문 생성
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

	//사원 삭제
	public void deleteEmp(String empno) {
		String sql = "DELETE FROM emp WHERE empno = ?";
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
			pstmt.setInt(1, Integer.parseInt(empno));
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

	//사원 수정
	public void fixEmp(EmpBean emp) {
		String sql = "UPDATE emp SET ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? WHERE empno = " + emp.getEmpno();

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
			pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getJob());
			pstmt.setInt(3, emp.getMgr());
			pstmt.setString(4, emp.getHiredate());
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());
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
