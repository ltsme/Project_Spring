package com.watchdogs.dao;


public interface SignUpDao {
	
	//유저 회원가입
	public void signupDao(String userId, String userPw, String userTel, String userEmail, String userName, String userpwquiz);
	
	//로그인 체크
	public int idCheck(String userId);
}
