package com.watchdogs.command.adopt;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.BDaoAdopt;
import com.watchdogs.dto.BDtoAdopt;

public class BAdoptapplycommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model,HttpSession httpSession) {
		// TODO Auto-generated method stub


		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("adoptapply");
	
		  int dogid = Integer.parseInt(request.getParameter("dogid"));
		System.out.println("asdsadsadsadsad"+dogid);
		BDaoAdopt daoadopt = sqlSession.getMapper(BDaoAdopt.class);
		HttpSession session = request.getSession();
		
		daoadopt.adoptwait_02(dogid);
		
	}

}
