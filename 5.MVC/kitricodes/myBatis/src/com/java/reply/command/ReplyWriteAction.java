package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class ReplyWriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String writeReply = request.getParameter("writeReply");
		logger.info(logMsg + writeReply);
		
		ReplyDto replyDto = new ReplyDto();
		replyDto.setLine_reply(writeReply);
		
		int check = ReplyDao.getInstance().insert(replyDto);
		
		if(check > 0) {
			int	bunho = ReplyDao.getInstance().getBunho();
			String replyData = bunho + "," + writeReply;
			logger.info(logMsg + replyData);
			
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(replyData);
			out.close();
		}
		
		return null;
	}

}
