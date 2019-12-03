package com.java.member.modules.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.member.modules.dao.MemberDao;
import com.java.member.modules.dto.MemberDto;
import com.java.member.modules.dto.ZipcodeDto;

/**
 * @author KimJinsu
 * @date 2019. 12. 1.
 * @apiNote member 서비스 객체
 */
@Component
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberDto memberDto;

	@Override
	public void memberRegister(ModelAndView modelAndView) {
		LogAspect.logger.info(LogAspect.logMsg + memberDao.toString());

		modelAndView.setViewName("member/register");
	}

	@Override
	public void memberRegisterIdCheck(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String id = request.getParameter("id");
		LogAspect.logger.info(LogAspect.logMsg + id);

		int chk = memberDao.idCheck(id);
		LogAspect.logger.info(LogAspect.logMsg + chk);

		request.setAttribute("chk", chk);
		request.setAttribute("id", id);

		modelAndView.setViewName("member/idCheck");
	}

	@Override
	public void memberRegisterZipCode(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String chkDong = request.getParameter("dong");
		LogAspect.logger.info(LogAspect.logMsg + chkDong);
		List<ZipcodeDto> zipcodeList = null;

		if (chkDong != null) {
			zipcodeList = memberDao.zipcodeReader(chkDong);
			LogAspect.logger.info(LogAspect.logMsg + zipcodeList.size());
		}

		if (zipcodeList != null)
			request.setAttribute("zipcodeList", zipcodeList);

		modelAndView.setViewName("member/zipcode");
	}

	@Override
	public void memberRegisterRegisterOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

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
		memberDto.setMemberLevel("BA"); // an associate member, DB have a 2byte
										// (BA, MA)

		LogAspect.logger.info(LogAspect.logMsg + memberDto.toString());

		int chk = memberDao.memberRegister(memberDto);
		LogAspect.logger.info(LogAspect.logMsg + chk);

		request.setAttribute("chk", chk);

		modelAndView.setViewName("member/registerOk");
	}

	@Override
	public void memberLoginOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		LogAspect.logger.info(LogAspect.logMsg + id + " " + pwd);

		String memberLevel = memberDao.login(id, pwd);
		LogAspect.logger.info(LogAspect.logMsg + memberLevel);

		if (memberLevel != null) {
			request.setAttribute("memberLevel", memberLevel);
			request.setAttribute("id", id);
		}

	}

	@Override
	public void memberMain(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		HttpSession session = request.getSession();

		if (!session.isNew()) {
			LogAspect.logger.info(
					LogAspect.logMsg + (String) session.getAttribute("id"));
		}
	}

	@Override
	public void memberUpdate(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		HttpSession session = request.getSession();
		String id = "";

		if (!session.isNew()) {
			id = (String) session.getAttribute("id");
			LogAspect.logger.info(LogAspect.logMsg + id);
		}

		memberDto = memberDao.update(id);

		request.setAttribute("memberDto", memberDto);

		LogAspect.logger.info(LogAspect.logMsg + memberDto.toString());

		modelAndView.setViewName("member/update");
	}

	@Override
	public void memberUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

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

		LogAspect.logger.info(LogAspect.logMsg + memberDto);

		int chk = memberDao.updateOk(memberDto);
		LogAspect.logger.info(LogAspect.logMsg + chk);

		request.setAttribute("chk", chk);
		modelAndView.setViewName("member/updateOk");
	}

	@Override
	public void memberDeleteOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		HttpSession session = request.getSession();

		String id = (String) session.getAttribute("id");
		String password = request.getParameter("pwd");

		LogAspect.logger.info(LogAspect.logMsg + id + "\t" + password);

		int chk = memberDao.deleteOk(id, password);
		LogAspect.logger.info(LogAspect.logMsg + chk);

		request.setAttribute("chk", chk);
	}
}
