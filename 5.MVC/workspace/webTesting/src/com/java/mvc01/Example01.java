package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example01 extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//init() service() destory()는 생략가능
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");		//요청한글 설정
		String name = req.getParameter("name");	//요청 데이터 값 처리
		
		System.out.println(name);
		
		//DB(패턴 이용해서 연결)
		
		//응답
		resp.setContentType("text/html; charset = UTF-8");
		
		//출력 BufferedOutputStream => OutputStream => Socket의 OutputStream
		//입력 Socket의 InputStream => InputStream => BufferedInputStream
		
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head><title>response!</title></head>");
		out.print("<body>");
		out.print("name is : ");
		out.print("<h3>" + name + "</h3>");
		out.print("</body></html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
