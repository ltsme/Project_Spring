package com.watchdogs.command.lookup;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.DaoLookupId;
import com.watchdogs.dto.DtoUser;

public class LookUpIdCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userEmail = request.getParameter("useremail");
		String userName = request.getParameter("username");
		
		DaoLookupId daolookupid = sqlSession.getMapper(DaoLookupId.class);
		ArrayList<DtoUser> dtoUser = daolookupid.lookupiddao(userEmail, userName);

		if(dtoUser.size() == 0) { // 아이디 찾기 실패
			httpSession.setAttribute("result", 0);
			
		}else { // 아이디 찾기 성공
			httpSession.setAttribute("result", 1);
			httpSession.setAttribute("userid", dtoUser.get(0).getUserId());
		}
	}
}
