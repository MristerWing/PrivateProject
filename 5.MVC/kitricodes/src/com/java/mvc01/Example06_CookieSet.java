package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06_CookieSet
 */
public class Example06_CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06_CookieSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] fruit = request.getParameterValues("fruit");
		System.out.println(fruit.length);
		
		//sessionScope: 해당 프로젝트(context)에서 데어터를 주고 받는거 없이 다 사용가능, it's Cookie!!
		if(fruit.length != 0) {
			for(int i = 0; i < fruit.length; i++) {
				String key = "fruit" + i;
				
				Cookie cookie = new Cookie(key, fruit[i]);
				cookie.setMaxAge(60*20); //초 분 시 일 ex. (60*60*2) (60*60*24*356)
				response.addCookie(cookie); //사용자 웹 브라우저의 쿠키폴더로 감
 			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Cookie</title></head>");
		out.print("<body>");
		out.print("<script type='text/javascript'>");
		out.print("alert('장바구니에 담겼습니다.');");
		
		String context = request.getContextPath();
		out.print("location.href='" + context + "/06_Servlet/example06.html';");
		
		out.print("</script>");
		//out.print("<h3> 쿠키에 저장 되었음 </h3>");
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
