package com.watchdogs.command.login;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.BListDao;
import com.watchdogs.dao.LoginCheckDao;
import com.watchdogs.dto.BListDto;
import com.watchdogs.dto.BLoginCheckDto;
import com.watchdogs.dto.DtoAdmin;
import com.watchdogs.dto.DtoUser;

public class LoginCheckCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		
		LoginCheckDao loginCheckDao = sqlSession.getMapper(LoginCheckDao.class);
		ArrayList<DtoUser> dtoUser = loginCheckDao.logincheckdaouser(userId, userPw);
		
		if(dtoUser.size() == 0) { // 유저 로그인 실패
			
			ArrayList<DtoAdmin> dtoAdmin = loginCheckDao.logincheckdaoadmin(userId, userPw);

			if(dtoAdmin.size() == 0) { // 관리자 로그인 실패 
				httpSession.setAttribute("result", 0);
				
			} else { // 관리자 로그인 성공
				httpSession.setAttribute("result", 1);
				httpSession.setAttribute("adid", dtoAdmin.get(0).getAdId());
				httpSession.setAttribute("ademail", dtoAdmin.get(0).getAdEmail());
				httpSession.setAttribute("adtel", dtoAdmin.get(0).getAdTel());
				httpSession.setAttribute("usertype", "admin");
			}
			
		}else { // 유저 로그인 성공
			httpSession.setAttribute("result", 1);
			httpSession.setAttribute("userid", dtoUser.get(0).getUserId());
			httpSession.setAttribute("usertel", dtoUser.get(0).getUserTel());
			httpSession.setAttribute("useremail", dtoUser.get(0).getUserEmail());
			httpSession.setAttribute("username", dtoUser.get(0).getUserName());
			httpSession.setAttribute("userdate", dtoUser.get(0).getUserDate());
			httpSession.setAttribute("userdeldate", dtoUser.get(0).getUserDelDate());
			httpSession.setAttribute("usertype", "user");
		}
		
	}
}
