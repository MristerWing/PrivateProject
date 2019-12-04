package com.java.reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.board.service.BoardService;
import com.java.reply.service.ReplyService;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 컨트롤러
 */
@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	/**
	 * @see BoardService.replyList
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/reply/list.do", method = RequestMethod.GET)
	public ModelAndView replyList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		replyService.replyList(modelAndView);

		return modelAndView;
	}

	/**
	 * @see ReplyService.replyWrite
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/reply/replyWrite.do", method = RequestMethod.POST)
	@ResponseBody
	public String replyWrite(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		String replyData = replyService.replyWrite(modelAndView);

		return replyData;
	}

	/**
	 * @see ReplyService.replyUpdate
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/reply/replyUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public String replyUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		String replyData = replyService.replyUpdate(modelAndView);

		return replyData;
	}

	/**
	 * @see ReplyService.replyUpdateOk
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/reply/replyUpdateOk.do", method = RequestMethod.POST)
	@ResponseBody
	public String replyUpdateOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		String replyData = replyService.replyUpdateOk(modelAndView);

		return replyData;
	}

	/**
	 * @see ReplyService.replyDelete
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/reply/replyDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public String replyDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		String replyData = replyService.replyDelete(modelAndView);

		return replyData;
	}

}
