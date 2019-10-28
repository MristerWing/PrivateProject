package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example07_SessionSet
 */
public class Example07_SessionSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07_SessionSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    /*
     * 세션도 cookie와 마찬가지로 sessionScope이다. 단, 쿠키와 달리 클라이언트의 특정 위치에 저장되는 것이 아닌 서버상에 객체로써 존재한다.
     * 즉, 세션은 서버에서만 접근이 가능하다. 또한 보안이 좋고, 저장할 수 있는 데이터에 한계가 없다.
     * 쿠키의 용량은 4KB제한이며, 300개 까지 데이터의 정보를 가질 수 있다.
     * 브라우저가 꺼지면 세션은 종료된다.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String msg = "";
		
		System.out.println(id + "\t" + pwd);
		
		//현제 세션이 존재하면 세션을 return, 존재하지 않으면 내부적으로 새로운 세션을 return
		HttpSession session = request.getSession(); 
		
		if(session.isNew()) {
			System.out.println("it's New!");
			
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			session.setMaxInactiveInterval(60*20);
			
			msg = "세션객체가 생성되었습니다.";
			
		}else {
			System.out.println("already created...");
			msg = "세션객체가 이미 생성되었습니다.";
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Cookie</title></head>");
		out.print("<body>");
		out.print("<script type='text/javascript'>");
		out.print("alert('" + msg + "');");
		
		String context = request.getContextPath();
		out.print("location.href='" + context + "/06_Servlet/example07.html';");
		
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
