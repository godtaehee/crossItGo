package com.crossit.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.crossit.entity.Board;
import com.crossit.entity.FileVo;
import com.crossit.entity.IndexView;
import com.crossit.service.BoardService;


@Controller
//@RequestMapping("/index/")
public class BoardController {
	
	@Autowired
	private BoardService service;
	

	
	//인덱스화면에 필요한 리스트 불러오기
	@RequestMapping("/index")
	public String list(Model model) {
		
		List<IndexView>list = service.getList();
		model.addAttribute("list",list);
		return "index";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		Board board= service.get(1);
		return "index";
	}
	
	
	//게시판 글쓰기 폼 
	@GetMapping("/post")
	public String post(Model model , Board board) {
	
		return "board/articleForm";
	}
	
	//게시판 글쓰기 
	@PostMapping("/post")
	public String write(Model model, Board board) {
		service.boardWirte(board);
		model.addAttribute("board",board);
		
		return "redirect:index";
	}
	
	

	
	
	

}
		
	
	
	
	
	
