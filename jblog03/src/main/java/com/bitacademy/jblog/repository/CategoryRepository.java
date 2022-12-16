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
	
	// 가입시 기본 카테고리 생성
	public void insert(CategoryVo vo) {
		sqlSession.insert("category.insert", vo);
	}
	
	// 카테고리 생성
	public void insertCategory(CategoryVo vo) {
		sqlSession.insert("category.insertCategory", vo);
	}
	
	// 카테고리 목록 불러오기
	public List<CategoryVo> findById(String id) {
		List<CategoryVo> result = sqlSession.selectList("category.findById", id);
		
		return result;
	}
	
	// delete
	public void deleteByNo(Long no) {
		sqlSession.delete("category.deleteByNo", no);
	}
}
