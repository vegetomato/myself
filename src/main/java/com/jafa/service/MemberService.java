package com.jafa.service;

import java.util.List;

import com.jafa.model.Member;

public interface MemberService {
	List<Member> getList();
	void register(Member member);
	void modify(Member member);
	Member get(Long id);
}
