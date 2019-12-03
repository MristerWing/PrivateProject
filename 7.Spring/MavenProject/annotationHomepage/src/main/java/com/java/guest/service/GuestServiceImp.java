package com.java.guest.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 27.
 * @apiNote Guest의 서비스 객체
 */
@Component
public class GuestServiceImp implements GuestService {

	@Autowired
	private GuestDao guestDao;
	@Autowired
	private GuestDto guestDto;

	/**
	 * @apiNote 방명록 글작성 확인
	 */
	@Override
	public void guestWrite(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber); // 1page
		int boardSize = 3; // page당 출력 게시물 수
		int startRow = (currentPage - 1) * boardSize + 1; // start num
		int endRow = boardSize * currentPage; // end num
		LogAspect.logger.info(LogAspect.logMsg + currentPage);

		int count = guestDao.getCount();
		LogAspect.logger.info(LogAspect.logMsg + count);

		List<GuestDto> guestList = null;
		if (count > 0) {
			guestList = guestDao.guestList(startRow, endRow);
		}
		LogAspect.logger.info(LogAspect.logMsg + guestList.size());

		request.setAttribute("guestList", guestList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);

		modelAndView.setViewName("guest/write");
	}

	/**
	 * @see GuestDao.guestWrite
	 * @apiNote 방명록 글 작성
	 */
	@Override
	public void guestWriteOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();

		guestDto = (GuestDto) modelMap.get("guestDto");
		guestDto.setWriteDate(new Date());
		guestDto.setMessage(guestDto.getMessage().replace("\r\n", "<br>"));

		LogAspect.logger.info(LogAspect.logMsg + guestDto.toString());

		int check = guestDao.guestWrite(guestDto);

		modelAndView.addObject("check", check);
		modelAndView.setViewName("guest/writeOk");
	}

	/**
	 * @apiNote 업데이트전 데이터 읽음
	 */
	@Override
	public void guestUpdate(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

		GuestDto guestDto = guestDao.update(num);

		request.setAttribute("guestDto", guestDto);
		request.setAttribute("pageNumber", pageNumber);
	}

	/**
	 * @apiNote 업데이트 적용
	 */
	@Override
	public void guestUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		GuestDto guestDto = new GuestDto();
		guestDto.setNum(Integer.parseInt(request.getParameter("num")));
		guestDto.setMessage(request.getParameter("message"));
		guestDto.setWriteDate(new Date());

		int check = guestDao.updateOk(guestDto);

		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);

	}

	/**
	 * @apiNote 삭제
	 */
	@Override
	public void guestDelete(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		int num = Integer.parseInt(request.getParameter("num"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

		int check = guestDao.delete(num);

		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);

	}

}
