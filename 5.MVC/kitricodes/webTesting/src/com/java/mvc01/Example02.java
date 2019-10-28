package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example02
 */

public class Example02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		float num1 = Float.parseFloat(request.getParameter("su"));
		float num2 = Float.parseFloat(request.getParameter("value"));
		String oper = request.getParameter("bunho"); 
		String result;
		
		if(oper.equals("+")) {
			result = Integer.toString((int) (num1 + num2));
		}
		else if(oper.equals("-")) {
			result = Integer.toString((int) (num1 - num2));
		}
		else if(oper.equals("*")||oper.equals("x")||oper.equals("X")) {
			result = Integer.toString((int) (num1 * num2));
		}
		else if(oper.equals("/")) {
			DecimalFormat df = new DecimalFormat("0.00");
			result = df.format((float)num1 / num2);
			
			//result = Float.toString((float) (Math.round((num1 / num2) * 100) / 100.0));
		}
		else {
			result = "ERROR!!";
		}
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>계산기</title></head>");
		out.print("<body>");
		out.print("<h3>" + (int)num1 + " ");
		out.print(oper + " ");
		out.print((int)num2 + " = ");
		out.print(result + "</h3>");
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
