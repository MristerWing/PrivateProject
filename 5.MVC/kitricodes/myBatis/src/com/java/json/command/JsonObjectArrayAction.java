package com.java.json.command;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import com.java.command.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class JsonObjectArrayAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int bunho = 1;
		String name = "홍길동";
		float average = 88.f;

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("bunho", bunho);
		jsonMap.put("name", name);
		jsonMap.put("average", average);

		JSONArray jsonArray = new JSONArray();
		List<ReplyDto> replyList = ReplyDao.getInstance().getReplyList();
		for (ReplyDto index : replyList) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bunho", index.getBunho());
			map.put("line_reply", index.getLine_reply());

			jsonArray.add(map);
		}

		jsonMap.put("reply", jsonArray);
		String jsonText = JSONValue.toJSONString(jsonMap);
		logger.info(logMsg + jsonText);

		if (jsonText != null) {
			response.setContentType("application/x-json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsonText);
			out.close();
		}

		return null;
	}

}
