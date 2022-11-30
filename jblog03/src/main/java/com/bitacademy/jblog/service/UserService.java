package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.BlogRepository;
import com.bitacademy.jblog.repository.CategoryRepository;
import com.bitacademy.jblog.repository.UserRepository;
import com.bitacademy.jblog.vo.BlogVo;
import com.bitacademy.jblog.vo.CategoryVo;
import com.bitacademy.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void insert(UserVo userVo, BlogVo blogVo, CategoryVo categoryVo) {
		userRepository.insert(userVo);
		blogRepository.insert(blogVo);
		categoryRepository.insert(categoryVo);
	}
	
	public UserVo findUser(String id, String password) {
		return userRepository.findByIdAndPassword(id, password);
	}
}
