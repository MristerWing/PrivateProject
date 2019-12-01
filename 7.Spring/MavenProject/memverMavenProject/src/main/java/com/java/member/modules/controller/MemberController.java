package com.java.member.modules.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.member.modules.dto.MemberDto;
import com.java.member.modules.service.memberService;

/**
 * @author KimJinsu
 * @date 2019. 12. 1.
 * @apiNote member컨트롤러 객체
 */
public class MemberController extends MultiActionController {
	private memberService memberService;

	public MemberController() {
	}

	public MemberController(
			com.java.member.modules.service.memberService memberService) {
		this.memberService = memberService;
	}

	public void setMemberService(memberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * @see memberService.memberRegister
	 * @param request
	 * @param response
	 * @return
	 */
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
	public ModelAndView memberDeleteOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		memberService.memberDeleteOk(modelAndView);

		return modelAndView;
	}

}
