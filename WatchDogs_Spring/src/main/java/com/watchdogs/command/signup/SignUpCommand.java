package com.watchdogs.command.signup;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dao.SignUpDao;
import com.watchdogs.dto.DtoAdmin;
import com.watchdogs.dto.DtoUser;

public class SignUpCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String userTel = request.getParameter("usertel");
		String userEmail = request.getParameter("useremail");
		String userName = request.getParameter("username");

		SignUpDao signUpDao = sqlSession.getMapper(SignUpDao.class);
		int checkID = signUpDao.idCheck(userId);
		
		if (checkID == 0) { // 가입 성공
			signUpDao.signupDao(userId, userPw, userTel, userEmail, userName);
			
		}else { // 중복된 아이디가 있어 가입 불가 =
			
		}
		
		
	}

}
