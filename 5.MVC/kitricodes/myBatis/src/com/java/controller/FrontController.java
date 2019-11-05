package com.java.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FrontController.class.getName());
	private static final String logMsg = "logMsg------------------";
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String confingFile = config.getInitParameter("configFile");
		logger.info(logMsg + confingFile);

		// set server path (root + configPath)
		String path = config.getServletContext().getRealPath(confingFile);
		logger.info(logMsg + path);

		
		// load properties file
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();

		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis, 1024);
			pro.load(bis);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (bis != null)
					bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// get class list and make instance
		Iterator<Object> keyIter = pro.keySet().iterator();
		while(keyIter.hasNext()) {
			String key = (String) keyIter.next();
			String value = pro.getProperty(key);
			logger.info(logMsg + "key => " + key + "\tvalue => " + value);
			
			try {
				Class<?> handleClass = Class.forName(value); //make Dynamic instance
				Object obj = handleClass.getDeclaredConstructor().newInstance();
				commandMap.put(key, obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		logger.info(logMsg + cmd);
		
		String view = null;
		
		try {
			CommandAction command = (CommandAction) commandMap.get(cmd);
			view = command.proRequest(request, response);
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
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
