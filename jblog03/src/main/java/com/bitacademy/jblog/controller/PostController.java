package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.service.PostService;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id) {
		
		return "blog/admin-write";
	}
}
