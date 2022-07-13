package com.jafa.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.config.Apptest;
import com.jafa.model.MemberVO;

public class MemberVOMapperTest extends Apptest{

	@Autowired
	MemberVOMapper mapper;
	
	@Test
	public void test() {
		MemberVO read = mapper.read("admin");
		read.getAuthList().forEach(System.out::println);
	}

}
