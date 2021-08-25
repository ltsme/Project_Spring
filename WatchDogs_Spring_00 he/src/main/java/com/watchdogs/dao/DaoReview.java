package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.DtoReview;

public interface DaoReview {
	
	// 전체검색
	public ArrayList<DtoReview> listReview();
	
	// 상세검색
	public DtoReview detail(String reId);
	
	// 수정
	public void update(int docId, String docTitle, String docContent, String docType, String docDate, String docDelDate, String userID, String adminID);	
	
	// 삭제(수정)
	public void delete(String reId);
	
	// 삭제취소(수정)
	public void deletecancel(String reId);
	
	// 입력
	public void insert(String docTitle, String docContent, String docType, String userID, String adminID);

}
