package com.bitacademy.jblog.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo01}/{pathNo02}"})
	public String index(
		@PathVariable("id") String id, 
		@PathVariable("pathNo01") Optional<Long> pathNo01, // Optional = null은 아닌데 내부에 값이 있는 것
		@PathVariable("pathNo02") Optional<Long> pathNo02) {
		
		Long categoryNo = 0L;	
		Long postNo = 0L;
		
		if(pathNo01.isPresent()) {
			categoryNo = pathNo01.get();
		} else if(pathNo01.isPresent()) {
			categoryNo = pathNo01.get();
			postNo = pathNo02.get();
		}
		
		return "blog/index";
	}
	
	@RequestMapping({"/admin", "/admin/basic"})
	public String adminBasic(@PathVariable("id") String id) {
		
		
		return "blog/admin-basic";
	}
}
