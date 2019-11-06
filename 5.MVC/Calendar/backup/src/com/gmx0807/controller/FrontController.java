package com.gmx0807.controller;

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

import com.gmx0807.command.CommandAction;

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
		String path = config.getServletContext().getRealPath(confingFile);

		Properties properties = getProperties(path);
		makePropertiesInstance(properties);
	}

	private Properties getProperties(String path) {
		Properties properties = new Properties();

		FileInputStream readPropertiesFile = null;
		BufferedInputStream makeFileStream = null;

		int fileReadSize = 1024;

		try {
			readPropertiesFile = new FileInputStream(path);
			makeFileStream = new BufferedInputStream(readPropertiesFile, fileReadSize);
			properties.load(makeFileStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (readPropertiesFile != null) {
					readPropertiesFile.close();
				}
				if (makeFileStream != null) {
					makeFileStream.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

		return properties;
	}

	private void makePropertiesInstance(Properties properties) {
		Iterator<Object> keyIterator = properties.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String value = properties.getProperty(key);

			try {
				Class<?> handleClass = Class.forName(value);
				Object obj = handleClass.getDeclaredConstructor().newInstance();
				commandMap.put(key, obj);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewKey = getViewKey(request);
		String view = null;
		
		logger.info(logMsg + viewKey);
		
		try {
			CommandAction action = (CommandAction) commandMap.get(viewKey);
			view = action.propertiesRequest(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		logger.info(logMsg + view);
		
		if(view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}
	
	private String getViewKey(HttpServletRequest request) {
		String viewKey = request.getRequestURI();
		viewKey = viewKey.substring(request.getContextPath().length());
		
		return viewKey;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
