package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.DtoTrainer;

public interface DaoTrainer {

	// 현재전검색
	public ArrayList<DtoTrainer> currentlist();
	
	// 전체검색
	public ArrayList<DtoTrainer> listTrainer();
	
	// 상세검색
	public DtoTrainer detail(String trId);
	
	// 수정
	public void update(String trId, String trPw, String trEmail, String trTel, String trName, String trCareer, String trDate, String trDelDate, String adminID, String trFilePath);
	
	// 삭제(수정)
	public void delete(String trId);
	
	// 삭제취소(수정)
	public void deletecancel(String trId);
	
	// 입력
	public void insert(String trId, String trPw, String trEmail, String trTel, String trName, String trCareer, String trFilePath, String adminID);
	
}
