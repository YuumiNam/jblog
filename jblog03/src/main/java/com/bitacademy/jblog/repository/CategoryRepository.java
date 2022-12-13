package com.bitacademy.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	// 카테고리 생성
	public void insert(CategoryVo vo) {
		sqlSession.insert("category.insert", vo);
	}
	
	// findAll
	public List<CategoryVo> findAll() {
		List<CategoryVo> result = sqlSession.selectList("category.findAll");
		
		return result;
	}
	
	// delete
	public void deleteByNo(Long no) {
		sqlSession.delete("category.deleteByNo", no);
	}
}
