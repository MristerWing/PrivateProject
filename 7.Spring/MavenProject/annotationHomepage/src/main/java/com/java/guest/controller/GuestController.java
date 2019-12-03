package com.java.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.guest.dto.GuestDto;
import com.java.guest.service.GuestService;

/**
 * @author KimJinsu
 * @date 2019. 11. 27.
 * @see GuestService
 * @see /mavenGuest/src/main/webapp/WEB-INF/spring/guest-context.xml
 * @apiNote Guest패키지의 Controller
 */
@Controller
@RequestMapping("/guest/*.do")
public class GuestController {

	@Autowired
	private GuestService guestService;

	/**
	 * @see GuestService.guestWrite
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/guest/write.do", method = RequestMethod.GET)
	public ModelAndView guestWriter(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		guestService.guestWrite(modelAndView);

		return modelAndView;
	}

	/**
	 * @see GuestService.guestWriteOk
	 * @param request
	 * @param response
	 * @param guestDto
	 * @return modelAndView
	 */
	@RequestMapping(value = "/guest/writeOk.do", method = RequestMethod.POST)
	public ModelAndView guestWriterOk(HttpServletRequest request,
			HttpServletResponse response, GuestDto guestDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("guestDto", guestDto);
		guestService.guestWriteOk(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param guestDto
	 * @return
	 */
	@RequestMapping(value = "/guest/update.do", method = RequestMethod.GET)
	public ModelAndView guestUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		guestService.guestUpdate(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param guestDto
	 * @return
	 */
	@RequestMapping(value = "/guest/updateOk.do", method = RequestMethod.POST)
	public ModelAndView guestUpdateOk(HttpServletRequest request,
			HttpServletResponse response, GuestDto guestDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("guestDto", guestDto);
		modelAndView.addObject("request", request);
		guestService.guestUpdateOk(modelAndView);

		return modelAndView;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param guestDto
	 * @return
	 */
	@RequestMapping(value = "/guest/delete.do", method = RequestMethod.GET)
	public ModelAndView guestDelete(HttpServletRequest request,
			HttpServletResponse response, GuestDto guestDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		guestService.guestDelete(modelAndView);

		return modelAndView;
	}

}
