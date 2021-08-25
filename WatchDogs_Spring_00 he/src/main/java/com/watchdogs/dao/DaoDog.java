package com.watchdogs.dao;

import java.util.ArrayList;

import com.watchdogs.dto.DtoDog;

public interface DaoDog {

	// 전체검색
	public ArrayList<DtoDog> listDog();
	
	// 상세검색
	public DtoDog detail(String dogId);
	
	// 수정
	public void update(int dogId, String dogName, String dogType, String dogMF, String dogAge, String dogAdoptSt, String dogDate, String dogAdoptDate, String dogTrainComm, String adminID, String trainerID, String dogFilePath);	
	
	// 삭제(수정)
	public void delete(String dogId);
	
	// 삭제취소(수정)
	public void deletecancel(String dogId);
	
	// 입력
	public void insert(String dogName, String dogType, String dogMF, String dogAge, String adminID, String trainerID, String dogFilePath);
	
}
