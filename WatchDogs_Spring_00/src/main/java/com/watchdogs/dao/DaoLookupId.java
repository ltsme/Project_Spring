package com.watchdogs.dao;

import java.util.ArrayList;
import com.watchdogs.dto.DtoUser;


public interface DaoLookupId {
	
	public ArrayList<DtoUser> lookupiddao(String userEmail, String userName);
		
}
