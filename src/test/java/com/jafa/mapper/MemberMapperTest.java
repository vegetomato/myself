package com.jafa.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.config.Apptest;
import com.jafa.model.Member;

public class MemberMapperTest extends Apptest{

	@Autowired
	MemberMapper mapper;
	
	@Test
	@Ignore
	public void getListTest() {
		List<Member> list = mapper.getList();
		assertEquals(4, list.size());
		
	}
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setUserName("비델");
		member.setEmail("vi@naver.com");
		member.setPassword("vvvv5555!");
		mapper.insert(member);
	}
}
