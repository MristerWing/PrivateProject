package com.java.json.command;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.java.command.CommandAction;

public class JsonObjectAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bunho = 1;
		String name = "홍길동";
		float average = 88.f;
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bunho", bunho);
		map.put("name", name);
		map.put("average", average);
		
		String jsonText = JSONValue.toJSONString(map);
		logger.info(logMsg + jsonText);
		
		if(jsonText != null) {
			response.setContentType("application/x-json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonText);
			out.close();
		}
		
		return null;
	}

}
