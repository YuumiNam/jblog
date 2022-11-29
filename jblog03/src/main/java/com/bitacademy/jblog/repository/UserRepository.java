package com.bitacademy.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.jblog.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입
	public Boolean insert(UserVo vo) {
		int count = sqlSession.insert("user.insert", vo);
		
		return count == 1;
	}
}
