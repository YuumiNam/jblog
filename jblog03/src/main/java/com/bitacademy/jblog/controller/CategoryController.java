package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.jblog.service.CategoryService;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id, Model model) {
		model.addAttribute("list", categoryService.getContentsList());
		
		return "blog/admin-category";
	}
	
//	@RequestMapping("ffff/ffff")
//	public String insertCategory() {
//		return "";
//	}
}
