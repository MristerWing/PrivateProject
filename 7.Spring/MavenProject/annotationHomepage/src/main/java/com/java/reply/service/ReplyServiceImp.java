package com.java.reply.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 서비스 객체
 */
@Component
public class ReplyServiceImp implements ReplyService {

	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private ReplyDto replyDto;

	/**
	 * @see ReplyDao.getReplyList
	 * @param modelAndView
	 * @apiNote 한줄댓글 리스트 불러옴
	 */
	@Override
	public void replyList(ModelAndView modelAndView) {
		List<ReplyDto> replyList = replyDao.getReplyList();
		LogAspect.logger.info(LogAspect.logMsg + replyList.size());

		modelAndView.addObject("replyList", replyList);
		modelAndView.setViewName("reply/jqueryReplyList");
	}

	/**
	 * @see ReplyDao.insert
	 * @param modelAndView
	 * @return replyData
	 * @apiNote 한줄댓글 입력
	 */
	@Override
	public String replyWrite(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		String replyData = "";

		String writeReply = request.getParameter("writeReply");
		replyDto.setLine_reply(writeReply);

		int check = replyDao.insert(replyDto);
		if (check > 0) {
			int bunho = replyDao.getBunho();
			replyData = bunho + "," + writeReply;
			LogAspect.logger.info(LogAspect.logMsg + replyData);
		}

		return replyData;
	}

	/**
	 * @see ReplyDao.getReply
	 * @param modelAndView
	 * @return replyData
	 * @apiNote 한줄댓글 업데이트를 위해 기존데이터를 가져옴
	 */
	@Override
	public String replyUpdate(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		String replyData = "";

		int bunho = Integer.parseInt(request.getParameter("bunho"));
		replyDto = replyDao.getReply(bunho);
		if (replyDto != null) {
			replyData = bunho + "," + replyDto.getLine_reply();
		}

		return replyData;
	}

	/**
	 * @see ReplyDao.update
	 * @param modelAndView
	 * @return replyData
	 * @apiNote 한줄댓글 DB 업데이트
	 */
	@Override
	public String replyUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		String replyData = "";

		int bunho = Integer.parseInt(request.getParameter("bunho"));
		String line_reply = request.getParameter("line_reply");
		replyDto.setBunho(bunho);
		replyDto.setLine_reply(line_reply);

		int check = replyDao.update(replyDto);
		if (check > 0) {
			replyData = bunho + "," + line_reply;
			LogAspect.logger.info(LogAspect.logMsg + "ok" + replyData);
		}

		return replyData;
	}

	/**
	 * @see ReplyDao.delete
	 * @param modelAndView
	 * @return bunho
	 * @apiNote 한줄댓글 DB 삭제
	 */
	@Override
	public String replyDelete(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");

		int bunho = Integer.parseInt(request.getParameter("bunho"));
		replyDao.delete(bunho);

		return Integer.toString(bunho);
	}
}
