package com.watchdogs.command.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public class BHomeCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model,HttpSession httpSession) {
		// TODO Auto-generated method stub
//		String str = "";
//		
//		HttpSession hsession = request.getSession(true);
//		hsession.setAttribute("userid", str); // session 초기화
//		hsession.setAttribute("usertype", str); // session 초기화
	}

}
