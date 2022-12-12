package com.bitacademy.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.jblog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
}
