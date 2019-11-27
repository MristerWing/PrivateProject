package com.java.reply.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.java.aop.LogAspect;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 서비스 객체
 */
public class ReplyServiceImp implements ReplyService {
	private ReplyDao replyDao;
	private ReplyDto replyDto;

	public ReplyServiceImp() {
	}

	public ReplyServiceImp(ReplyDao replyDao, ReplyDto replyDto) {
		this.replyDao = replyDao;
		this.replyDto = replyDto;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public void setReplyDto(ReplyDto replyDto) {
		this.replyDto = replyDto;
	}

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
	 * @apiNote 한줄댓글 입력
	 */
	@Override
	public void replyWrite(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		HttpServletResponse response = (HttpServletResponse) modelMap
				.get("response");

		String writeReply = request.getParameter("writeReply");
		replyDto.setLine_reply(writeReply);

		int check = replyDao.insert(replyDto);
		if (check > 0) {
			int bunho = replyDao.getBunho();
			String replyData = bunho + "," + writeReply;
			LogAspect.logger.info(LogAspect.logMsg + replyData);

			response.setContentType("application/txt;charset=UTF-8");

			try {
				PrintWriter out = response.getWriter();
				out.print(replyData);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		modelAndView.addObject("response", response);
	}

	/**
	 * @see ReplyDao.getReply
	 * @param modelAndView
	 * @apiNote 한줄댓글 업데이트를 위해 기존데이터를 가져옴
	 */
	@Override
	public void replyUpdate(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		HttpServletResponse response = (HttpServletResponse) modelMap
				.get("response");

		int bunho = Integer.parseInt(request.getParameter("bunho"));
		replyDto = replyDao.getReply(bunho);
		if (replyDto != null) {
			String replyData = bunho + "," + replyDto.getLine_reply();
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(replyData);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		modelAndView.addObject("response", response);
	}

	/**
	 * @see ReplyDao.update
	 * @param modelAndView
	 * @apiNote 한줄댓글 DB 업데이트
	 */
	@Override
	public void replyUpdateOk(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		HttpServletResponse response = (HttpServletResponse) modelMap
				.get("response");

		int bunho = Integer.parseInt(request.getParameter("bunho"));
		String line_reply = request.getParameter("line_reply");
		replyDto.setBunho(bunho);
		replyDto.setLine_reply(line_reply);

		int check = replyDao.update(replyDto);
		if (check > 0) {
			String replyData = bunho + "," + line_reply;
			LogAspect.logger.info(LogAspect.logMsg + "ok" + replyData);

			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(replyData);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		modelAndView.addObject("response", response);
	}

	/**
	 * @see ReplyDao.delete
	 * @param modelAndView
	 * @apiNote 한줄댓글 DB 삭제
	 */
	@Override
	public void replyDelete(ModelAndView modelAndView) {
		Map<String, Object> modelMap = modelAndView.getModelMap();
		HttpServletRequest request = (HttpServletRequest) modelMap
				.get("request");
		HttpServletResponse response = (HttpServletResponse) modelMap
				.get("response");

		int bunho = Integer.parseInt(request.getParameter("bunho"));

		int check = replyDao.delete(bunho);

		if (check > 0) {
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(bunho);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		modelAndView.addObject("response", response);
	}
}
