package com.java.member.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class RegisterOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		/*
		 * MemberDto memberDto = new MemberDto(request.getParameter("id"),
		 * request.getParameter("password"), request.getParameter("name"),
		 * request.getParameter("jumin1"), request.getParameter("jumin2"),
		 * request.getParameter("email"), request.getParameter("zipcode"),
		 * request.getParameter("address"), request.getParameter("job"),
		 * request.getParameter("mailing"), request.getParameter("interest"), "BA", new
		 * Date());
		 */
		
		MemberDto memberDto= new MemberDto();
		memberDto.setId(request.getParameter("id"));
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
		
		memberDto.setRegisterDate(new Date());
		memberDto.setMemberLevel("BA"); // an associate member, DB have a 2byte (BA, MA)
		
		logger.info(logMsg + memberDto.toString());
		
		int chk = MemberDao.getInstance().insert(memberDto);
		logger.info(logMsg + chk);
		
		request.setAttribute("chk", chk);
 		
		return "/WEB-INF/view/member/registerOk.jsp";
	}
}
