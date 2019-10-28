package com.java.mvc05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile:" + configFile);

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		//안드로이드면 매니페스트등록과 같다.
		Properties pro = new Properties();

		try {
			fis = new FileInputStream(configFile);
			bis = new BufferedInputStream(fis, 1024);
			pro.load(bis);

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		Set<Object> set = pro.keySet();
		Iterator<Object> keyItr = set.iterator();

		while (keyItr.hasNext()) {
			String key = (String) keyItr.next();
			String value = pro.getProperty(key);

			// 동적 클래스 생성
			try {
				Class<?> handlerClass = Class.forName(value);
				try {
					//version 8 은 디클리케이트가 안돼었음
					Object obj = handlerClass.newInstance();
					commMap.put(key, obj);
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/*
			 * System.out.println("key: " + key); System.out.println("value: " + value);
			 */

		}

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
		System.out.println(cmd);

		String view = null;

		try {
			CommandAction ca = (CommandAction) commMap.get(cmd);
			view = ca.preRequest(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		if (view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}

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
