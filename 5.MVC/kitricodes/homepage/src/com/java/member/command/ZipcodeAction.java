package com.java.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.ZipcodeDto;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 28.
 * @설명 
 */


public class ZipcodeAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String chkDong = request.getParameter("dong");
		logger.info(logMsg + chkDong);
		ArrayList<ZipcodeDto> zipcodeList = null;

		if (chkDong != null) {
			zipcodeList = MemberDao.getInstance().zipcodeReader(chkDong);
			logger.info(logMsg + zipcodeList.size());
		}

		if (zipcodeList != null)
			request.setAttribute("zipcodeList", zipcodeList);

		return "/WEB-INF/view/member/zipcode.jsp";
	}

}
