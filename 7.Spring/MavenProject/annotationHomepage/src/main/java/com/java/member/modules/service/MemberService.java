package com.java.member.modules.service;

import org.springframework.web.servlet.ModelAndView;

public interface MemberService {
	public void memberRegister(ModelAndView modelAndView);

	public void memberRegisterIdCheck(ModelAndView modelAndView);

	public void memberRegisterZipCode(ModelAndView modelAndView);

	public void memberRegisterRegisterOk(ModelAndView modelAndView);

	public void memberLoginOk(ModelAndView modelAndView);

	public void memberMain(ModelAndView modelAndView);

	public void memberUpdate(ModelAndView modelAndView);

	public void memberUpdateOk(ModelAndView modelAndView);

	public void memberDeleteOk(ModelAndView modelAndView);
}
