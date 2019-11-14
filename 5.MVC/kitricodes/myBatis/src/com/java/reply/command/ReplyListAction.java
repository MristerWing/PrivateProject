package com.java.reply.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class ReplyListAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		List<ReplyDto> replyList = ReplyDao.getInstance().getReplyList();
		logger.info(logMsg + replyList.size());
		request.setAttribute("replyList", replyList);
		
		return "/WEB-INF/view/reply/replyList.jsp";
	}

}
