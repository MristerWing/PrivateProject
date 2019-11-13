package com.java.sawon;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;

public class ListOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String departmentName = request.getParameter("departmentName");
		logger.info(logMsg + departmentName);
		
		List<SawonDto> sawonList = SawonDao.getInstance().select(departmentName);
		
		logger.info(logMsg + sawonList.size());
		request.setAttribute("sawonList", sawonList);
		
		return "/WEB-INF/view/sawon/listOk.jsp";
	}

}
