package com.java.member.modules.dao;

import java.util.List;

import com.java.member.modules.dto.MemberDto;
import com.java.member.modules.dto.ZipcodeDto;

public interface MemberDao {
	public int memberRegister(MemberDto memberDto);

	public int idCheck(String id);

	public List<ZipcodeDto> zipcodeReader(String chkDong);

	public String login(String id, String pwd);

	public MemberDto update(String id);

	public int updateOk(MemberDto memberDto);

	public int deleteOk(String id, String password);
}
