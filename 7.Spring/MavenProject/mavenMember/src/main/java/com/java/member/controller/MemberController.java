package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	public ModelAndView memberRegister(HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("ok");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/register");

		return modelAndView;
	}
}
