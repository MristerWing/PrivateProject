package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example05
 */
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 페이지 이동: response.sendRedirect() / URL?(GET)
		 * 데이터 전달: include() / request & response, forward() / request & response
		 */
		
		/*
		 * private int su; Exanple05에서 사용하는 변수 PageScope, 
		 * 데이터 전달시 request객체에 파라미터로 전달. RequestScope,
		 * SessionScope, ApplicationScope
		 */
		
		request.setCharacterEncoding("UTF-8");
		String meg = request.getParameter("message");
		
		System.out.println("include");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>include</title></head>");
		out.print("<body>");
		out.print("<sapn>" + meg + "</sapn> <br>");
		
		RequestDispatcher rd = request.getRequestDispatcher("/com/java/mvc01/Example05_sub");
		rd.include(request, response); //해당페이지 호출 후 다시 호출한 곳으로 돌아옴

		out.print("<hr width = '400px' align='center' color='red' />");

		request.setAttribute("name", "James");
		rd.include(request, response);
		
		out.print("<hr width = '400px' align='center' color='blue' />");
		
		out.print("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("forward");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>forward</title></head>");
		out.print("<body>");

		request.setAttribute("name", "Aliy");
		
		RequestDispatcher rd = request.getRequestDispatcher("/com/java/mvc01/Example05_sub");
		rd.forward(request, response); //해당페이지 호출
		
		out.print("<hr width = '400px' align='center' color='blue' />");
		
		out.print("</body></html>");
		out.close();
		
	}

}
