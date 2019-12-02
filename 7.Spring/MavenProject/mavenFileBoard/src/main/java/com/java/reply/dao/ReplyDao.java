package com.java.reply.dao;

import java.util.List;

import com.java.reply.dto.ReplyDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 DAO인터페이스
 */
public interface ReplyDao {
	public int insert(ReplyDto replyDto);

	public int getBunho();

	public List<ReplyDto> getReplyList();

	public int delete(int bunho);

	public ReplyDto getReply(int bunho);

	public int update(ReplyDto replyDto);
}
