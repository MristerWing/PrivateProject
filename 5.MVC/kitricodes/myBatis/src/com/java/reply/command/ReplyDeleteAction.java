package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;

public class ReplyDeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		logger.info(logMsg + bunho);

		int check = ReplyDao.getInstance().delete(bunho);
		logger.info(logMsg + check);
		
		if(check > 0) {
			response.setContentType("application/txt;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(bunho);
			out.close();
		}
		
		return null;
	}

}
