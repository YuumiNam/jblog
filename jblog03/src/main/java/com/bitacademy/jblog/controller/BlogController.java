package com.bitacademy.jblog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.jblog.service.BlogService;
import com.bitacademy.jblog.service.CategoryService;
import com.bitacademy.jblog.service.FileUploadService;
import com.bitacademy.jblog.service.PostService;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.PostVo;
import com.bitacademy.jblog.vo.UserVo;

@Controller
@RequestMapping("/blog/{id:(?!assets).*}") // 앞에 
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	// 블로그 메인
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
	
	// 블로그 기본정보
	@RequestMapping(value={"/admin", "/admin/basic"}, method=RequestMethod.GET)
	public String adminBasic(@PathVariable("id") String id, Model model) {
		
		return "blog/admin-basic";
	}
	
	// 블로그 기본정보 관리
	@RequestMapping(value={"/admin", "/admin/basic"}, method=RequestMethod.POST)
	public String adminBasic(@PathVariable("id") String id, Model model, BlogVo vo) {
		// String url = fileUploadService.restore(multipartFile);
		
		// model.addAttribute("profile", url);
		
		blogService.update(vo);
		System.out.println(vo);
		
		return "redirect:/blog/" + id;
	}
	
	// 블로그 카테고리 목록보기
	@RequestMapping(value="/admin/category", method=RequestMethod.GET)
	public String adminCategory(@PathVariable("id") String id, Model model) {
		model.addAttribute("list", categoryService.getContentsList(id));
		
		System.out.println("Category : " + categoryService.getContentsList(id));
		return "blog/admin-category";
	}
	
	// 블로그 카테고리 추가
	@RequestMapping(value="/admin/category", method=RequestMethod.POST)
	public String adminCategory(@PathVariable("id") String id, CategoryVo vo, UserVo uservo) {
		categoryService.insertCategory(vo);
		
		System.out.println("CategoryVo : " + vo);
		return "redirect:/blog/" + id + "/admin/category";
	}
	
	// 블로그 카테고리 삭제
	@RequestMapping(value="/admin/category/delete/{no}")
	public String deleteCategory(@PathVariable("id") String id, @PathVariable("no") Long no) {
		categoryService.deleteCategory(no);
		
		return "redirect:/";
	}
	
	// 블로그 글작성 바로가기
	@RequestMapping(value="/admin/write", method=RequestMethod.GET)
	public String adminWrite(@PathVariable("id") String id, Model model) {
		model.addAttribute("list", postService.getContentsList(id));
		
		System.out.println(postService.getContentsList(id));
		return "blog/admin-write";
	}
	
	// 블로그 글작성
	@RequestMapping(value="/admin/write", method=RequestMethod.POST)
	public String adminWrite(@PathVariable("id") String id, PostVo vo,
			@RequestParam("category") Long no) {
		
		vo.setCategoryNo(no);
		System.out.println(vo);
		postService.insertPost(vo);
	
		return "redirect:/blog/" + id;
	}
}
