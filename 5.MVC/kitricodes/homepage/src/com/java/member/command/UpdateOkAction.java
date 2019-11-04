package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

/**
 * @개발자 KJS
 * @작성일 2019. 10. 29.
 * @설명 
 */

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		MemberDto memberDto = new MemberDto();
		
		memberDto.setNum(Integer.parseInt(request.getParameter("id")));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setName(request.getParameter("name"));
		
		memberDto.setJumin1(request.getParameter("jumin1"));
		memberDto.setJumin2(request.getParameter("jumin2"));
		memberDto.setEmail(request.getParameter("email"));
		
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		
		memberDto.setMailing(request.getParameter("mailing"));
		memberDto.setInterest(request.getParameter("interest"));
		
		logger.info(logMsg + memberDto);
		
		int chk = MemberDao.getInstance().updateOk(memberDto);
		logger.info(logMsg + chk);
		
		request.setAttribute("chk", chk);
		
		return "/WEB-INF/view/member/updateOk.jsp";
	}
}
