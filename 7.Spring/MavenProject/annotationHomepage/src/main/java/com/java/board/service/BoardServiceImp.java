package com.java.board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;

/**
 * @author KimJinsu
 * @Date 2019.11.25
 * @version 0.1.1
 * @apiNote add boardList
 * @information BoardAction의 기능을 담당했던 부분. service로 이름을 변경한 후 기능들이 구현됨
 */
@Component
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;

	/**
	 * @param modelAndView
	 * @apiNote 게시판 글 작성시 게시글 번호 및 시퀀스 레벨 등의 초기화
	 */
	@Override
	public void boardWrite(ModelAndView modelAndView) {

		// Root
		int boardNumber = 0;
		int groupNumber = 1;
		int sequenceNumber = 0;
		int sequenceLevel = 0;

		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		LogAspect.logger.info(LogAspect.logMsg + boardNumber);

		if (request.getParameter("boardNumber") != null) {
			boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber = Integer
					.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel = Integer
					.parseInt(request.getParameter("sequenceLevel"));
		}

		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);

		modelAndView.setViewName("board/write");
	}

	/**
	 * @see BoardServiceImp.boardWriteUpdateNumbers
	 * @param modelAndView
	 * @apiNote 게시글 작성완료 후 작성완료여부 판단
	 */
	@Override
	public void boardWriteOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();

		BoardDto boardDto = (BoardDto) modelMap.get("boardDto");

		boardWriteUpdateNumbers(boardDto);

		boardDto.setWriteDate(new Date());
		boardDto.setReadCount(0);
		LogAspect.logger.info(LogAspect.logMsg + boardDto.toString());

		int check = boardDao.boardWriteOk(boardDto);
		LogAspect.logger.info(LogAspect.logMsg + check);

		modelAndView.addObject("check", check);
		modelAndView.setViewName("board/writeOk");
	}

	/**
	 * @see BoardDao.findMaxGroupNumber
	 * @see BoardDao.sequenceNumberUpdate
	 * @param boardDto
	 * @apiNote 시퀀스레벨 계산 및 DB연동
	 */
	private void boardWriteUpdateNumbers(BoardDto boardDto) {
		int boardNumber = boardDto.getBoardNumber();
		int groupNumber = boardDto.getGroupNumber();
		int sequenceNumber = boardDto.getSequenceNumber();
		int sequenceLevel = boardDto.getSequenceLevel();

		if (boardNumber == 0) {
			int max = boardDao.findMaxGroupNumber();

			if (max != 0) {
				boardDto.setGroupNumber(max + 1);
			}
		} else {
			Map<String, Integer> sequenceAndGroupMap = new HashMap<String, Integer>();
			sequenceAndGroupMap.put("groupNumber", groupNumber);
			sequenceAndGroupMap.put("sequenceNumber", sequenceNumber);
			LogAspect.logger.info(LogAspect.logMsg + sequenceAndGroupMap);

			int check = boardDao.sequenceNumberUpdate(sequenceAndGroupMap);
			LogAspect.logger.info(LogAspect.logMsg + check);

			boardDto.setSequenceNumber(sequenceNumber + 1);
			boardDto.setSequenceLevel(sequenceLevel + 1);
		}
	}

	/**
	 * @see BoardDao.getCount
	 * @see BoardDao.getBoardList
	 * @apiNote 게시판의 목록을 불러오는 method
	 * @param modelAndView
	 */
	@Override
	public void boardList(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModel();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null || pageNumber == "")
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber); // 1page
		int boardSize = 10; // page당 출력 게시물 수
		int startRow = (currentPage - 1) * boardSize + 1; // start num
		int endRow = boardSize * currentPage; // end num
		LogAspect.logger.info(LogAspect.logMsg + currentPage);

		int count = boardDao.getCount();
		LogAspect.logger.info(LogAspect.logMsg + count);

		List<BoardDto> boardList = null;
		if (count > 0) {
			boardList = boardDao.getBoardList(startRow, endRow);
		}

		LogAspect.logger.info(LogAspect.logMsg + boardList.size());

		modelAndView.addObject("boardList", boardList);
		modelAndView.addObject("currentPage", currentPage);
		modelAndView.addObject("boardSize", boardSize);
		modelAndView.addObject("count", count);
		modelAndView.setViewName("board/list");
	}

	/**
	 * @see BoardDao.read
	 * @param modelAndView
	 * @apiNote 작성한 글 내용확인
	 */
	@Override
	public void boardRead(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		LogAspect.logger
				.info(LogAspect.logMsg + boardNumber + "\t" + pageNumber);

		BoardDto boardDto = boardDao.read(boardNumber);
		LogAspect.logger.info(LogAspect.logMsg + boardDto.toString());

		modelAndView.addObject("pageNumber", pageNumber);
		modelAndView.addObject("boardDto", boardDto);
		modelAndView.setViewName("board/read");
	}

	/**
	 * @see BoardDao.read
	 * @param modelAndView
	 * @apiNote update전 선택한 글을 수정하는 뷰를 띄움
	 */
	@Override
	public void boardUpdate(ModelAndView modelAndView) {

		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		BoardDto boardDto = boardDao.read(boardNumber);
		modelAndView.addObject("boardNumber", boardNumber);
		modelAndView.addObject("boardDto", boardDto);
		modelAndView.addObject("pageNumber",
				request.getParameter("pageNumber"));
		modelAndView.setViewName("board/update");
	}

	/**
	 * @see BoardDao.update
	 * @param modelAndView
	 * @apiNote update할 데이터를 받은 후 실제로 update를 수행
	 */
	@Override
	public void boardUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		BoardDto boardDto = (BoardDto) modelMap.get("boardDto");
		boardDto.setWriteDate(new Date());
		LogAspect.logger.info(LogAspect.logMsg + boardDto);

		int check = boardDao.update(boardDto);
		modelAndView.addObject("check", check);
		modelAndView.addObject("pageNumber",
				request.getParameter("pageNumber"));
		modelAndView.setViewName("board/updateOk");
	}

	/**
	 * @see BoardDao.delete
	 * @param modelAndView
	 * @apiNote 게시글 삭제
	 */
	@Override
	public void boardDelete(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int check = boardDao.delete(boardNumber);
		modelAndView.addObject("check", check);

		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		modelAndView.addObject("pageNumber", pageNumber);

		modelAndView.setViewName("board/delete");
	}

}
