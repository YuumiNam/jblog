package com.bitacademy.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.CategoryRepository;
import com.bitacademy.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<CategoryVo> getContentsList() {
		return categoryRepository.findAll();
	}
}
