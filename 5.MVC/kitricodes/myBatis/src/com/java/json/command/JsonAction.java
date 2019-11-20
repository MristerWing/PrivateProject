package com.java.json.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class JsonAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String msg = request.getParameter("msg");
		if(msg.equals("obj")) {
			//return "/WEB-INF/view/json/jsonObject.jsp";
			return "/WEB-INF/view/json/jqueryJsonObject.jsp";
		}else if(msg.equals("array")) {
			//return "/WEB-INF/view/json/jsonArray.jsp";
			return "/WEB-INF/view/json/jqueryJsonArray.jsp";
		}else {
			//return "/WEB-INF/view/json/jsonObjectArray.jsp";
			return "/WEB-INF/view/json/jqueryJsonObjectArray.jsp";
		}
		
		
	}

}
