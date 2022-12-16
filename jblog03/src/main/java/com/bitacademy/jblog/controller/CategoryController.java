package com.bitacademy.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/admin/category", method=RequestMethod.GET)
	public String adminCategory(@PathVariable("id") String id, Model model) {
		model.addAttribute("list", categoryService.getContentsList(id));
		
		System.out.println(id);
		System.out.println(categoryService.getContentsList(id));
		return "blog/admin-category";
	}
	
	@RequestMapping(value="/admin/category", method=RequestMethod.POST)
	public String adminCategory(@PathVariable("id") String id, CategoryVo vo, UserVo uservo) {
		categoryService.insertCategory(vo);
		
		System.out.println("CategoryVo : " + vo);
		return "redirect:/blog/" + id + "/admin/category";
	}
	
	@RequestMapping(value="/admin/category/delete/{no}")
	public String deleteCategory(@PathVariable("id") String id, @PathVariable("no") Long no) {
		categoryService.deleteCategory(no);
		
		return "redirect:/";
	}
}
