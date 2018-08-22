package com.example.demo.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.domain.CommentVO;
import com.example.demo.board.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Resource(name="com.example.demo.board.service.CommentService")
	CommentService mCommentService;
	
	//댓글 리스트
	@RequestMapping("/list")
	@ResponseBody
	private List<CommentVO> mCommentServiceList(Model model) throws Exception{
		
		return mCommentService.commentListService();
		
	}
	
	//댓글 작성
	@RequestMapping("/insert")
	@ResponseBody
	private int mCommentServiceInsert(@RequestParam int bno, @RequestParam String content) throws Exception{
		
		CommentVO comment = new CommentVO();
		comment.setBno(bno);
		comment.setContent(content);
		
		comment.setWriter("noel");
		
		return mCommentService.commentInsertService(comment);
		
	}
	
	//댓글 수정
	@RequestMapping("/update")
	@ResponseBody
	private int mCommentServiceUpdateProc(@RequestParam int cno, @RequestParam String content) throws Exception{
		
		CommentVO comment = new CommentVO();
		comment.setCno(cno);
		comment.setContent(content);
		
		return mCommentService.commentUpdateService(comment);
		
	}
	
	//댓글 삭제
	@RequestMapping("/delete/{cno}")
	@ResponseBody
	private int mCommentServiceDelete(@PathVariable int cno) throws Exception{
		
		return mCommentService.commentDeleteService(cno);
	}
	
	
	
}
