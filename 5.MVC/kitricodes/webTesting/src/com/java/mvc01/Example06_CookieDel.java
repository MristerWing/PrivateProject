package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06_CookieDel
 */
public class Example06_CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06_CookieDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String msg = "";
		
		if(cookies != null) {
			for(int i = 0;i < cookies.length;i++) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
			
			msg = "장바구니를 비웠습니다.";
			
		}else {
			msg = "장바구니에 아무런 값이 없습니다.";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Cookie</title></head>");
		out.print("<body>");
		out.print("<script type='text/javascript'>");
		out.print("alert('" + msg + "');");
		
		String context = request.getContextPath();
		out.print("location.href='" + context + "/06_Servlet/example06.html';");
		
		out.print("</script>");
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
