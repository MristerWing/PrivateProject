package com.java.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.reply.dto.ReplyDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 26.
 * @apiNote 한줄댓글 DAO객체
 */
@Component
public class ReplyDaoImp implements ReplyDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int insert(ReplyDto replyDto) {
		return sqlSessionTemplate.insert("replyInsert", replyDto);
	}

	@Override
	public int getBunho() {
		return sqlSessionTemplate.selectOne("replyGetBunho");
	}

	@Override
	public List<ReplyDto> getReplyList() {
		return sqlSessionTemplate.selectList("replyGetList");
	}

	@Override
	public int delete(int bunho) {
		return sqlSessionTemplate.delete("replyDelete", bunho);
	}

	@Override
	public ReplyDto getReply(int bunho) {
		return sqlSessionTemplate.selectOne("replyGetDto", bunho);
	}

	@Override
	public int update(ReplyDto replyDto) {
		return sqlSessionTemplate.update("replyUpdate", replyDto);
	}

}
