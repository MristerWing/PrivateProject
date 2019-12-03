package com.java.guest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.guest.dto.GuestDto;

/**
 * @author KimJinsu
 * @date 2019. 11. 27.
 * @apiNote Guest의 DAO객체
 */

// 객체선언 new GuestDa
@Component
public class GuestDaoImp implements GuestDao {
	// field 데이터 삽입
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int guestWrite(GuestDto guestDto) {
		return sqlSessionTemplate.insert("mapper.GuestMapper.guestInsert",
				guestDto);
	}

	@Override
	public int getCount() {
		return sqlSessionTemplate.selectOne("guestCountSelect");
	}

	@Override
	public List<GuestDto> guestList(int startRow, int endRow) {
		Map<String, Integer> rowMap = new HashMap<String, Integer>();
		rowMap.put("startRow", startRow);
		rowMap.put("endRow", endRow);

		return sqlSessionTemplate.selectList("guestListSelect", rowMap);
	}

	@Override
	public GuestDto update(int num) {
		return sqlSessionTemplate.selectOne("guestSelect", num);
	}

	@Override
	public int updateOk(GuestDto guestDto) {
		return sqlSessionTemplate.update("guestUpdate", guestDto);
	}

	@Override
	public int delete(int num) {
		return sqlSessionTemplate.delete("guestDelete", num);
	}

}
