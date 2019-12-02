package com.java.reply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.board.service.BoardService;
import com.java.reply.service.ReplyService;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 컨트롤러
 */
public class ReplyController extends MultiActionController {
	private ReplyService replyService;

	public ReplyController() {
	}

	public ReplyController(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	/**
	 * @see BoardService.replyList
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
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
	public void replyWrite(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		replyService.replyWrite(modelAndView);
	}

	/**
	 * @see ReplyService.replyUpdate
	 * @param request
	 * @param response
	 */
	public void replyUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		replyService.replyUpdate(modelAndView);
	}

	/**
	 * @see ReplyService.replyUpdateOk
	 * @param request
	 * @param response
	 */
	public void replyUpdateOk(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		replyService.replyUpdateOk(modelAndView);
	}

	/**
	 * @see ReplyService.replyDelete
	 * @param request
	 * @param response
	 */
	public void replyDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		replyService.replyDelete(modelAndView);

	}

}
