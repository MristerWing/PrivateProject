package com.java.fileBoard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.java.fileBoard.dto.FileBoardDto;
import com.java.fileBoard.service.FileBoardService;

/**
 * @author KimJinsu
 * @date 2019. 12. 2.
 * @apiNote fileBoard Controller
 * @see FileBoardService
 */
public class FileBoardController extends MultiActionController {
	private FileBoardService fileBoardService;

	public FileBoardController() {
	}

	public FileBoardController(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}

	public void setFileBoardService(FileBoardService fileBoardService) {
		this.fileBoardService = fileBoardService;
	}

	/**
	 * @see fileBoardService.fileBoardWrite
	 * @param request
	 * @param response
	 * @return
	 */
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
	public ModelAndView fileBoardDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		fileBoardService.fileBoardDelete(modelAndView);

		return modelAndView;
	}
}
