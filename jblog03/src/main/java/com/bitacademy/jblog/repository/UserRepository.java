package com.bitacademy.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입
	public void insert(UserVo vo) {
		sqlSession.insert("user.insert", vo);
	}
	
	// 로그인
	public UserVo findByIdAndPassword(String id, String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		
		UserVo result = sqlSession.selectOne("user.findByIdAndPassword", map);
		
		return result;
	}
}
