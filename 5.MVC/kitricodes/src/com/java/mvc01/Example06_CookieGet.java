package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06_CookieGet
 */
public class Example06_CookieGet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example06_CookieGet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String context = request.getContextPath();

		out.print("<html>");
		out.print("<head><title>Cookie Get</title></head>");
		out.print("<body>");

		String imgStr = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				out.print("<h3>" + cookies[i].getName() + "</h3>");
				out.print("<h3>" + cookies[i].getValue() + "</h3>");
				imgStr = context + "/images/" + cookies[i].getValue() + ".jpg";
				out.print("<img src='" + imgStr + "' width='150' height='100'/>");
			}
		}else {
			out.print("<h3>쿠키에 아무것도 없습니다.</h3>");
		}

		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
