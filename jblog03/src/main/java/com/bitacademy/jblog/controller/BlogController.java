package com.bitacademy.jblog.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}") // 앞에 
public class BlogController {
	
	@RequestMapping({"", "/{pathNo01}", "/{pathNo01}/{pathNo02}"})
	public String index(
		@PathVariable("id") String id, 
		@PathVariable("pathNo01") Optional<Long> pathNo01, // Optional = null은 아닌데 내부에 값이 있는 것
		@PathVariable("pathNo02") Optional<Long> pathNo02
		) {
		
		Long categoryNo = 0L;	
		Long postNo = 0L;
		
		if(pathNo01.isPresent()) {
			categoryNo = pathNo01.get();
		} else if(pathNo02.isPresent()) {
			categoryNo = pathNo01.get();
			postNo = pathNo02.get();
		}
		

		return "blog/index";
	}
	
	@RequestMapping(value={"/admin", "/admin/basic"}, method=RequestMethod.GET)
	public String adminBasic(@PathVariable("id") String id, Model model) {
		
		return "blog/admin-basic";
	}
	
	@RequestMapping(value={"/admin", "/admin/basic"}, method=RequestMethod.POST)
	public String adminBasic(@PathVariable("id") String id) {
		
		
		return "redirect:/blog";
	}
	
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id) {
		
		return "blog/admin-category";
	}
	
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id) {
		
		return "blog/admin-write";
	}
}
