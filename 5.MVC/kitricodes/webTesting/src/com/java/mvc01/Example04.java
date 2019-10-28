package com.java.mvc01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example04
 */
public class Example04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example04() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*************************** Response **************************/

		/*
		 * response: 페이지 contentType 설정, 출력기능. 쿠키 쓰기 기능/읽기(request) header내용 입력(쓰기),
		 * 리다이렉트 하기
		 */

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		System.out.println(id + "\t" + pwd);

		// DB
		String dbId = "abc123";
		String dbPwd = "abc123";
		
		String context = request.getContextPath();

		if (id.equals(dbId) && pwd.equals(dbPwd)) {
			//sendRedirect: 그냥 페이지 이동, get방식으로 간단한 데이터 이동 가능
			
			// go to success
			response.sendRedirect(context + "/com/java/mvc01/Example04_Success");
		} else {
			// go to fail
			response.sendRedirect(context + "/com/java/mvc01/Example04_Fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
