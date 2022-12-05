package com.bitacademy.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.vo.BlogVo;

@Controller
@RequestMapping("/{id:(?!assets).*}") // 앞에 
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo01}/{pathNo02}"})
	public String index(
		@PathVariable("id") String id, 
		@PathVariable("pathNo01") Optional<Long> pathNo01, // Optional = null은 아닌데 내부에 값이 있는 것
		@PathVariable("pathNo02") Optional<Long> pathNo02,
		BlogVo blogVo, Model model) {
		
		Long categoryNo = 0L;	
		Long postNo = 0L;
		
		if(pathNo01.isPresent()) {
			categoryNo = pathNo01.get();
		} else if(pathNo02.isPresent()) {
			categoryNo = pathNo01.get();
			postNo = pathNo02.get();
		}
		
		model.addAttribute("blogVo", blogService.findById(id));
		
		blogVo = blogService.findById(id);
		System.out.println(blogVo);
	
		return "blog/index";
	}
	
	@RequestMapping({"/admin", "/admin/basic"})
	public String adminBasic(@PathVariable("id") String id) {
		
		
		return "blog/admin-basic";
	}
}
