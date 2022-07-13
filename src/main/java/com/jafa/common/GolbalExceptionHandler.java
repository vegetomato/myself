package com.jafa.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jafa.exception.NotMatchUserIdException;

@ControllerAdvice
public class GolbalExceptionHandler {
	
	@ExceptionHandler(NotMatchUserIdException.class)
	public String notMatchUserId() {
		System.out.println("NotMatchUserIdException발생");
		return "member/myPage_error";
	}
}
