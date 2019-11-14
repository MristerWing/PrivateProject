package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class ReplyUpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bunho = Integer.parseInt(request.getParameter("bunho"));

		ReplyDto replyDto = ReplyDao.getInstance().getReply(bunho);
		if (replyDto != null) {
			String replyData = bunho + "," + replyDto.getLine_reply();
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(replyData);
			out.close();
		}

		return null;
	}

}
