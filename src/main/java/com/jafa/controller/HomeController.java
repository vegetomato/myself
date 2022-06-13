package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin/list")
	public String test() {
		System.out.println("컨트롤러 실행 : Admin");
		return "admin";
	}
	
	@GetMapping("/admin/aa")
	public String aa() {
		System.out.println("컨트롤러 실행 aa()");
		return "aa";
	}
}