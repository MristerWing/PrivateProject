package com.java.fileBoard.service;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote FileBoard Service Interface
 */
public interface FileBoardService {
	public void fileBoardWrite(ModelAndView modelAndView);

	public void fileBoardWriteOk(ModelAndView modelAndView);

	public void fileBoardList(ModelAndView modelAndView);

	public void fileBoardRead(ModelAndView modelAndView);

	public void fileBoardDownload(ModelAndView modelAndView);

	public void fileBoardUpdate(ModelAndView modelAndView);

	public void fileBoardUpdateOk(ModelAndView modelAndView);

	public void fileBoardDelete(ModelAndView modelAndView);
}
