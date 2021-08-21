package com.watchdogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.watchdogs.dto.BListDto;
import com.watchdogs.dto.BLoginCheckDto;
import com.watchdogs.dto.DtoAdmin;
import com.watchdogs.dto.DtoUser;

public interface LoginCheckDao {
	
	//유저 로그인
	public ArrayList<DtoUser> logincheckdaouser(String userid, String userpw);
	
	//어드민 로그인
	public ArrayList<DtoAdmin> logincheckdaoadmin(String adid, String adpw);
}
