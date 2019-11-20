package com.java.parsing.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.java.command.CommandAction;

public class ParsingXMLAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 프록시 작업은 외부에서 방화병을 가지고 있는 외부와 통시을 위해 만들어 놓은 서버.
		// 방화벽 안쪽에 있는 서버들의 외부 연결은 프록시 서버를 통해서만 이루어 진다.
		// 사이트에 바로 접속하게 하는 것이 아니라, 프록시 서버를 한곳에서 거쳐서 가는 것이다.
		
		String url = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
		logger.info(logMsg + url);
		GetMethod getMethod = new GetMethod(url);
		HttpClient httpClint = new HttpClient();
		
		int statusCode = httpClint.executeMethod(getMethod);
		
		logger.info(logMsg + statusCode);
		
		if(statusCode == 200) {
			String result = getMethod.getResponseBodyAsString();
			//logger.info(logMsg + result);
			
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		}
		
		return null;
	}

}
