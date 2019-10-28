package com.java.mvc02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// frontController Pattern : 사용자의 요청을 하나의 서블릿에서 처리하는 형태
		System.out.println("Hello");

		/*
		 * String adress = ""; StringTokenizer test = new
		 * StringTokenizer(request.getServletPath(), "/."); while (test.hasMoreTokens())
		 * { adress = test.nextToken(); break; }
		 */

		String[] caller = request.getServletPath().split("/");
		String callerName = caller[caller.length - 1];
		String adress = callerName.split(".kitri")[0];

		System.out.println(callerName);
		
		System.out.println(adress);
		String view = "";

		// String[] page = { "write", "read" };
		ArrayList<String> list = new ArrayList<String>();
		list.add("text1");
		list.add("text1");
		list.add("text1");
		HashMap<String, Object> page = new HashMap<String, Object>();
		page.put("write.kitri", 1);
		page.put("read.kitri", list);

		if (page.containsKey(callerName)) {
			System.out.println(page.get(callerName));

			view = "/08_MVC/" + adress + ".jsp";
			request.setAttribute("check", page.get(callerName));
		}

		RequestDispatcher rd = request.getRequestDispatcher(view);

		if (rd != null)
			rd.forward(request, response);

		// else if(callerName.equals("read.kitri")) { System.out.println("읽다.");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
