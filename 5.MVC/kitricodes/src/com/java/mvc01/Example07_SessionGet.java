package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Example07_SessionGet
 */
public class Example07_SessionGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07_SessionGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Session</title></head>");
		out.print("<body>");
		
		if(!session.isNew()) {
			String id = (String) session.getAttribute("id");
			String pwd = (String) session.getAttribute("pwd");
			System.out.println(id + "\t" + pwd);
			System.out.println("session id: " + session.getId());
		}else {
			out.print("<script type='text/javascript'>");
			out.print("alert('세션이 존재하지 않음!');");
			
			String context = request.getContextPath();
			out.print("location.href='" + context + "/06_Servlet/example07.html';");
			out.print("</script>");
		}
		
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
