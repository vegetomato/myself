package com.jafa.config;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.mapper.BoardMapper;
import com.jafa.mapper.MemberMapper;
import com.jafa.model.Board;
import com.jafa.model.Member;

public class DataInsertTest extends Apptest{
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void dataInsert() {

		for (int i = 1; i <= 412; i++) {
			Member member = new Member();
			member.setUserName("던붕스"+i);
			member.setEmail("Dungeon@naver.com"+i);
			member.setPassword("bbbb"+i+"!");
			mapper.insert(member);
		}
	}
}

