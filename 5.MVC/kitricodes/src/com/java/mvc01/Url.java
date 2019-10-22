package com.java.mvc01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * HttpServlet need override
 * Servlet LifeCycle
 * init() -> service() -> get() or post() -> destory()
 */

public class Url extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("1. 초기화-------------!!-------------------");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2. 서비스를 병행적으로 처리(get/post)--------------------------------");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3-1 get call--------------------------------");
		// 쿠키 테스트
		Cookie[] cookies = req.getCookies();
		System.out.println(cookies.length);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3-2 post call--------------------------------");
	}

	@Override
	public void destroy() {
		System.out.println("4. 소멸(update or server end_--------------------------------");
	}

}
