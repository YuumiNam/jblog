package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.BlogVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;
	
	// 블로그 생성
	public void insert(BlogVo vo) {
		sqlSession.insert("blog.insert", vo);
	}
	
	// 블로그 메인
	public BlogVo findById(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
	
		BlogVo result = sqlSession.selectOne("blog.findByIdAndCategoryNo", map);
		
		return result;
	}
}
