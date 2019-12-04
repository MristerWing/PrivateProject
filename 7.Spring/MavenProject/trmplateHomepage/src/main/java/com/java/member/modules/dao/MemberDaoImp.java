package com.java.member.modules.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.member.modules.dto.MemberDto;
import com.java.member.modules.dto.ZipcodeDto;

/**
 * @author KimJinsu
 * @date 2019. 12. 1.
 * @apiNote 맴버 DAO객체
 */
@Component
public class MemberDaoImp implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberDaoImp() {
	}

	public MemberDaoImp(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int memberRegister(MemberDto memberDto) {
		return sqlSessionTemplate.insert("insert", memberDto);
	}

	@Override
	public int idCheck(String id) {
		int check = 0;
		String checkId = sqlSessionTemplate.selectOne("idcheck", id);

		if (checkId != null)
			check = 1;

		return check;
	}

	@Override
	public List<ZipcodeDto> zipcodeReader(String chkDong) {
		return sqlSessionTemplate.selectList("zipcode", chkDong);
	}

	@Override
	public String login(String id, String pwd) {
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("id", id);
		loginMap.put("pwd", pwd);

		return sqlSessionTemplate.selectOne("login", loginMap);
	}

	@Override
	public MemberDto update(String id) {
		return sqlSessionTemplate.selectOne("update_select", id);
	}

	@Override
	public int updateOk(MemberDto memberDto) {
		return sqlSessionTemplate.update("updateOk", memberDto);
	}

	@Override
	public int deleteOk(String id, String password) {
		Map<String, String> loginMap = new HashMap<String, String>();
		loginMap.put("id", id);
		loginMap.put("password", password);

		return sqlSessionTemplate.delete("delete", loginMap);
	}
}
