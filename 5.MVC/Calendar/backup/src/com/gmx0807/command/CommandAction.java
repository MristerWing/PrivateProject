package com.gmx0807.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmx0807.controller.FrontController;

public interface CommandAction {
	public static final Logger logger = Logger.getLogger(FrontController.class.getName());
	public static final String logMsg = "logMsg------------------";
	
	public String propertiesRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}