package com.watchdogs.command.lookup;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.DaoLookupId;
import com.watchdogs.dao.DaoLookupPw;
import com.watchdogs.dao.DaoTrainer;
import com.watchdogs.dao.DaoUser;
import com.watchdogs.dto.DtoUser;

public class LookUpPwCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userid = request.getParameter("userid");
		String userpwquiz = request.getParameter("userpwquiz");

		DaoLookupPw daolookuppw = sqlSession.getMapper(DaoLookupPw.class);
		ArrayList<DtoUser> dtoUser = daolookuppw.lookuppwdao(userid, userpwquiz);
		
		if(dtoUser.size() == 0) { // 비밀번호 찾기 실패
			httpSession.setAttribute("result", 0);
			
		}else { // 비밀번호 찾기 성공
			httpSession.setAttribute("result", 1);
			httpSession.setAttribute("lookupresult", dtoUser.get(0).getUserPw());
		}
	}
}
