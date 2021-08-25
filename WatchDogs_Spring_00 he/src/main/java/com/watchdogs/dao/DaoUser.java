package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.DtoUser;

public interface DaoUser {
	
	// 전체검색
	public ArrayList<DtoUser> listUser();
	
	// 상세검색
	public DtoUser detailUser(String userId);
	
	// 수정
	public void updateUser(String userId, String userPw, String userTel, String userEmail, String userName, String userDate, String userDelDate, String adminID);	
	
	// 삭제(수정)
	public void delete(String userId);
	
	// 삭제취소(수정)
	public void deletecancel(String userId);
	
	// 입력
	public void insert(String userId, String userPw, String userTel, String userEmail, String userName);
	
	// 개인정보 수정
	public void userUpdateForUser(String userId, String userPw, String userTel, String userEmail, String userName);
	
	// 탈퇴
	public void userOut(String userId);
	
}
