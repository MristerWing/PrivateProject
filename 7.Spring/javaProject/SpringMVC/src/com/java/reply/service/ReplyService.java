package com.java.reply.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 서비스 인터페이스
 */
public interface ReplyService {
	public void replyList(ModelAndView modelAndView);

	public void replyWrite(ModelAndView modelAndView);

	public void replyUpdate(ModelAndView modelAndView);

	public void replyUpdateOk(ModelAndView modelAndView);

	public void replyDelete(ModelAndView modelAndView);
}
