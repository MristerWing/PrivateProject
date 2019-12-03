package com.java.reply.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 서비스 인터페이스
 */
public interface ReplyService {
	public void replyList(ModelAndView modelAndView);

	public String replyWrite(ModelAndView modelAndView);

	public String replyUpdate(ModelAndView modelAndView);

	public String replyUpdateOk(ModelAndView modelAndView);

	public String replyDelete(ModelAndView modelAndView);
}
