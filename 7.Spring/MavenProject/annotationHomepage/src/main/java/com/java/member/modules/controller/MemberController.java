package com.java.member.modules.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.member.modules.dto.MemberDto;
import com.java.member.modules.service.MemberService;

/**
 * @author KimJinsu
 * @date 2019. 12. 1.
 * @apiNote member컨트롤러 객체
 */
@Controller
@RequestMapping("/member/*.do")
public class MemberController {

	@Autowired
	private MemberService memberService;

	/**
	 * @see memberService.memberRegister
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		memberService.memberRegister(modelAndView);

		return modelAndView;
	}

	/**
	 * @see memberService.memberRegisterIdCheck
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/idCheck.do", method = RequestMethod.GET)
	public ModelAndView memberRegisterIdCheck(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberRegisterIdCheck(modelAndView);

		return modelAndView;
	}

	/**
	 * @see memberService.memberRegisterZipcode
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/zipcode.do", method = RequestMethod.GET)
	public ModelAndView memberRegisterZipcode(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberRegisterZipCode(modelAndView);

		return modelAndView;
	}

	/**
	 * @see memberService.memberRegisterOk
	 * @param request
	 * @param response
	 * @param memberDto
	 * @return
	 */
	@RequestMapping(value = "/member/registerOk.do", method = RequestMethod.POST)
	public ModelAndView memberRegisterOk(HttpServletRequest request,
			HttpServletResponse response, MemberDto memberDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("memberDto", memberDto);
		memberService.memberRegisterRegisterOk(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public ModelAndView memberLogin(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/login");

		return modelAndView;
	}

	/**
	 * @see memberService.memberLoginOk
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/loginOk.do", method = RequestMethod.POST)
	public ModelAndView memberLoginOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberLoginOk(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView memberLogout(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/logout");
		return modelAndView;
	}

	/**
	 * @see memberService.memberMain
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/main.do", method = RequestMethod.GET)
	public ModelAndView memberMain(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberMain(modelAndView);

		return modelAndView;
	}

	/**
	 * @see memberService.memberUpdate
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public ModelAndView memberUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberUpdate(modelAndView);

		return modelAndView;
	}

	/**
	 * @see memberService.memberUpdateOk
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/updateOk.do", method = RequestMethod.POST)
	public ModelAndView memberUpdateOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberUpdateOk(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/delete.do", method = RequestMethod.GET)
	public ModelAndView memberDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/delete");

		return modelAndView;
	}

	/**
	 * @see memberService.memberDeleteOk
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/member/deleteOk.do", method = RequestMethod.POST)
	public ModelAndView memberDeleteOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberDeleteOk(modelAndView);

		return modelAndView;
	}

}
