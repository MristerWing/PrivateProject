package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class ReplyUpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		String line_reply = request.getParameter("line_reply");
		
		ReplyDto replyDto = new ReplyDto(bunho, line_reply);
		
		int check = ReplyDao.getInstance().update(replyDto);
		if (check > 0) {
			String replyData = bunho + "," + line_reply;
			logger.info(logMsg + replyData);
			
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(replyData);
			out.close();
		}

		return null;
	}

}
