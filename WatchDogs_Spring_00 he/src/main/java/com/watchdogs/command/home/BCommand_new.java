package com.watchdogs.command.home;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface BCommand_new {
	
	void execute(SqlSession sqlSession, Model model, HttpSession httpSession);

}
