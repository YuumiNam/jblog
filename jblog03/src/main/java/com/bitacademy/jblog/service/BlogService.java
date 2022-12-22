package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogRepository;
import com.bitacademy.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	// 회원가입시 블로그 생성
	public void insert(BlogVo vo) {
		blogRepository.insert(vo);
	}
	
	
	// 블로그 메인
	public BlogVo findById(String id) {
			return blogRepository.findById(id);
	}
	
	// 블로그 수정
	public void update(BlogVo vo) {
		blogRepository.update(vo);
	}
}
