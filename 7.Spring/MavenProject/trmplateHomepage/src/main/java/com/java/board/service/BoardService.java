package com.java.board.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 * @date 2019. 11. 25.
 * @apiNote BoardService interface
 */
public interface BoardService {
	public void boardWrite(ModelAndView modelAndView);

	public void boardWriteOk(ModelAndView modelAndView);

	public void boardList(ModelAndView modelAndView);

	public void boardRead(ModelAndView modelAndView);

	public void boardUpdate(ModelAndView modelAndView);

	public void boardUpdateOk(ModelAndView modelAndView);

	public void boardDelete(ModelAndView modelAndView);
}
