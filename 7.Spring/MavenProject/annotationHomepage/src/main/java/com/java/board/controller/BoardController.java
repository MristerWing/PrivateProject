package com.java.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.board.dto.BoardDto;
import com.java.board.service.BoardService;

/**
 * @author KimJinsu
 * @date 2019.11.25
 * @information 각각의 구역으로 나뉘어서 제공 MVC:FrontCotroller --설정(~.properties)
 *              -DispatcherServlet Map - SimpleUrlHandlerMapping :웹 요청시 URL과
 *              컨트롤러의 맵핑을 일괄정의 요청 Command(주소 - CLASS) -
 *              MultiActionController(주소/함수) Command-view Page RequestDispatcher
 *              forward 사용해서 result view - InternalResourceViewResolver
 */

// MultiActionColtroller => 특정 파라미터 값이나 URL등을 이용하여 해당 클래스의 메소드를 실행시킴

@Controller
@RequestMapping("/board/*.do")
public class BoardController {

	@Autowired
	private BoardService boardService;

	/**
	 * @see BoardService.boardWrite
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public ModelAndView boardWrite(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);

		boardService.boardWrite(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardWriteOk
	 * @param request
	 * @param response
	 * @param boardDto
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/writeOk.do", method = RequestMethod.POST)
	public ModelAndView writeOk(HttpServletRequest request,
			HttpServletResponse response, BoardDto boardDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("response", response);
		modelAndView.addObject("boardDto", boardDto);

		boardService.boardWriteOk(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardList
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/list.do", method = RequestMethod.GET)
	public ModelAndView boardList(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		boardService.boardList(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardRead
	 * @param request
	 * @param response
	 * @param boardDto
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/read.do", method = RequestMethod.GET)
	public ModelAndView boardRead(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		boardService.boardRead(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardUpdate
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public ModelAndView boardUpdate(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		boardService.boardUpdate(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardUpdateOk
	 * @param request
	 * @param response
	 * @param boardDto
	 * @return modelAndView
	 */
	@RequestMapping(value = "/board/updateOk.do", method = RequestMethod.POST)
	public ModelAndView boardUpdateOk(HttpServletRequest request,
			HttpServletResponse response, BoardDto boardDto) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);
		modelAndView.addObject("boardDto", boardDto);

		boardService.boardUpdateOk(modelAndView);

		return modelAndView;
	}

	/**
	 * @see BoardService.boardDelete
	 * @param request
	 * @param response
	 * @return modelAndView
	 */
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.GET)
	public ModelAndView boardDelete(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("request", request);

		boardService.boardDelete(modelAndView);

		return modelAndView;
	}
}
