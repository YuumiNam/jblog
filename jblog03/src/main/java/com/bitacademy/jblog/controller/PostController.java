package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.vo.PostVo;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String adminWrite(@PathVariable("id") String id, Model model) {
		model.addAttribute("list", postService.getContentsList(id));
		
		System.out.println(postService.getContentsList(id));
		return "blog/admin-write";
	}
	
	@RequestMapping(value="/admin/write", method=RequestMethod.POST)
	public String adminWrite(@PathVariable("id") String id, PostVo vo,
			@RequestParam("category") Long no) {
		
		vo.setCategoryNo(no);
		System.out.println(vo);
		postService.insertPost(vo);
	
		return "redirect:/blog/" + id;
	}
	
	
}
