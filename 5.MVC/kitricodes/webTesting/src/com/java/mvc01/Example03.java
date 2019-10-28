package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example03
 */
public class Example03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request는 웹 브라우저를 통해서 서버에 어떤 정보를 요청하는 것
		 * 한글 encoding, Parameter 읽기, 서버정보 읽기, 클라이언트(웹 브라우저 정보 포함)정보 읽기
		 * 헤더 읽기, 쿠키 읽기
		 */
		
		/*************Request**********************/
		
		//서버 관련 정보 읽기
		String name = request.getServerName();
		int port = request.getServerPort();
		
		String path = request.getContextPath(); //root path
		String servletPath = request.getServletPath();
		String method = request.getMethod();
		
		//URI
		String uri = request.getRequestURI(); 		//webTesting ~~~~ Servlet
		
		//URL
		StringBuffer url = request.getRequestURL(); //http:// ~~~~ Servlet
		
		//클라잉언트 정보
		String remoteAddr = request.getRemoteAddr(); // 클라이언트 주소
		int remotePort = request.getRemotePort(); //클라이언트 포트
		String protocol = request.getProtocol();	 //프로토콜
		
		//해더읽기
		Enumeration<String> header =  request.getHeaderNames();
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>request</title></head>");
		out.print("<body>");
		out.print("<h1>request</h1>");
		out.print("<h3> hostname: " + name + " port: ");
		out.print(port + " ");
		out.print("<br> rootPath: " + path + "<br>");
		out.print("<br> servletPath: " + servletPath + "<br>");
		out.print("<br> methodType: " + method + "<br>");
		out.print("<br> URI: " + uri + "<br> URL: ");
		out.print(url + "</h3>");
		out.print("<h3> remote Address: " + remoteAddr + " <br> ");
		out.print("remote Port: " + remotePort + " <br> ");
		out.print("protocol: " + protocol + " </h3> <br> <b> header: </b> <br>");
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
			out.print(key + ": " + value + "<br>");
		}
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
