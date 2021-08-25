package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.DtoNotice;

public interface DaoNotice {
	
	// 전체검색
	public ArrayList<DtoNotice> listNotice();
	
	// 상세검색
	public DtoNotice detail(String noId);
	
	// 수정
	public void update(int noId, String noTitle, String noContent, String noDate, String noDelDate, int noHit, String adminID);	
	
	// 삭제(수정)
	public void delete(String noId);
	
	// 삭제취소(수정)
	public void deletecancel(String noId);
	
	// 입력
	public void insert(String noTitle, String noContent, String adminID);

}
