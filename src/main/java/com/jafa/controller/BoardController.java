package com.jafa.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jafa.model.Board;
import com.jafa.model.BoardAttachVO;
import com.jafa.model.Criteria;
import com.jafa.model.PageMaker;
import com.jafa.model.ReplyVO;
import com.jafa.service.BoardService;
import com.jafa.validation.BoardValidator;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String list(Model model, Criteria criteria) {
		PageMaker pageMaker = new PageMaker(criteria, service.totalCount(criteria));
		model.addAttribute("pageMaker",pageMaker);
		
		List<Board> list = service.getList(criteria);
		model.addAttribute("list",list);
		return "board/list";
	}
	@GetMapping("/get")
	public String get(Model model, Long bno) {
		model.addAttribute("board", service.get(bno));
		return "board/get";
	}
	@PostMapping("/remove")
	public String delete(Long bno) {
//		첨부파일 정보를 불러낸다
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		service.remove(bno);
		
		deleteFiles(attachList);
		
		return "redirect:list";
	}
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
//		정보가 없거나 사이즈가 0이면 실행하지 않는다
		if(attachList == null || attachList.size()==0)return;
		attachList.forEach(attach -> {
			Path file = Paths.get("C:/storage/"+attach.getUploadPath()+"/"+attach.getUuid()+"_"+attach.getFileName());
			
			try {
				Files.deleteIfExists(file);
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:/storage/"+attach.getUploadPath()+"/s_"+attach.getUuid()+"_"+attach.getFileName());
					Files.deleteIfExists(thumbNail);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		});
		
	}
	@GetMapping("/modify")
	public String updateForm(Model model, Long bno){
		model.addAttribute("board", service.get(bno));
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String update(Board board) {
		service.modify(board);
		return "redirect:list";
	}
	
	@GetMapping("/register")
	public String registerForm(Board board, Model model) {
		model.addAttribute("board",board);
		return "board/register";
	}
	@PostMapping("/register")
	public String register(Board board, Errors errors, RedirectAttributes rttr) {
		new BoardValidator().validate(board, errors);
		if(errors.hasErrors()) {
			return "board/register";
		}
		service.register(board);
		return "redirect:list";	
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		return new ResponseEntity<>(attachList, HttpStatus.OK); 
	}
}
