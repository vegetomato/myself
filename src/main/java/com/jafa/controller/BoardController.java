package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jafa.model.Board;
import com.jafa.validation.BoardValidator;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
	
	@GetMapping("/register")
	public String registerForm(Board board) {
		return "board/register";
	}
	@PostMapping("/register")
	public String register(Board board, Errors errors) {
		new BoardValidator().validate(board, errors);
		if(errors.hasErrors()) {
			return "board/register";
		}
		return "redirect:list";
		
	}
}
