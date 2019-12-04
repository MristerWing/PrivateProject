package com.java.fileBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.fileBoard.dto.FileBoardDto;
import com.java.fileBoard.service.FileBoardService;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote fileBoard Controller
 * @see FileBoardService
 */
@Controller
@RequestMapping("/fileboard/*.do")
public class FileBoardController {

	@Autowired
	private FileBoardService fileBoardService;

	/**
	 * @see fileBoardService.fileBoardWrite
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/write.do", method = RequestMethod.GET)
	public ModelAndView fileBoardWrite(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		fileBoardService.fileBoardWrite(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardWriteOk
	 * @param request
	 * @param response
	 * @param fileBoardDto
	 * @return
	 */
	@RequestMapping(value = "/fileboard/writeOk.do", method = RequestMethod.POST)
	public ModelAndView fileBoardWriteOk(HttpServletRequest request,
			HttpServletResponse response, FileBoardDto fileBoardDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("fileBoardDto", fileBoardDto);

		fileBoardService.fileBoardWriteOk(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardList
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/list.do", method = RequestMethod.GET)
	public ModelAndView fileBoardList(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardList(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardRead
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/read.do", method = RequestMethod.GET)
	public ModelAndView fileBoardRead(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardRead(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardDownload
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/download.do", method = RequestMethod.GET)
	public void fileBoardDownload(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		fileBoardService.fileBoardDownload(modelAndView);

	}

	/**
	 * @see fileBoardService.fileBoardUpdate
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/update.do", method = RequestMethod.GET)
	public ModelAndView fileBoardUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardUpdate(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardUpdateOk
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/updateOk.do", method = RequestMethod.POST)
	public ModelAndView fileBoardUpdateOk(HttpServletRequest request,
			HttpServletResponse response, FileBoardDto fileBoardDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("fileBoardDto", fileBoardDto);
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardUpdateOk(modelAndView);

		return modelAndView;
	}

	/**
	 * @see fileBoardService.fileBoardDelete
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/fileboard/delete.do", method = RequestMethod.GET)
	public ModelAndView fileBoardDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardDelete(modelAndView);

		return modelAndView;
	}
}
