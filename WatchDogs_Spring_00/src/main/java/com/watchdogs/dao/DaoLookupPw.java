package com.watchdogs.dao;


import java.util.ArrayList;
import com.watchdogs.dto.DtoUser;

public interface DaoLookupPw {
	
	public ArrayList<DtoUser> lookuppwdao(String userid, String userpwquiz);
}
