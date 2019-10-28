package com.java.mvc04;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandCtrl
 */
public class CommandCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Object> commandMap = new HashMap<String, Object>();
	CommandAction page;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		ListAction list = new ListAction();
		WriteAction write = new WriteAction();

		commandMap.put("/list.do", list);
		commandMap.put("/write.do", write);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getRequestURI();
		cmd = cmd.substring(request.getContextPath().length());
		System.out.println("CMD:" + cmd);

		System.out.println(request.getRequestURI());
		
		String view = null;
		if (commandMap.containsKey(cmd)) {
			page = (CommandAction) commandMap.get(cmd);
			
			try {
				view = page.preRequest(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);

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
