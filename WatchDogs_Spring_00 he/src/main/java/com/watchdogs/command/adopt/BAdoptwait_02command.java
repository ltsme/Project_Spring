package com.watchdogs.command.adopt;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand;
import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.BDaoAdopt;
import com.watchdogs.dto.BDtoAdopt;

public class BAdoptwait_02command implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model,HttpSession httpSession) {  

		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("adoptwait_02");
	
	    int dogid = Integer.parseInt(request.getParameter("dogid"));
	    
		 BDaoAdopt daoadopt = sqlSession.getMapper(BDaoAdopt.class);
		    ArrayList<BDtoAdopt> dtosadopt = daoadopt.adoptwait_02(dogid);
	
	    /////////////////////////////////////////////////////////////// 
//	    BDaoAdopt daoadopt2 = new BDaoAdopt();
//		ArrayList<BDtoAdopt> dtosadopt2 = daoadopt2.adoptwait_02(dogid);
	//////////////////////////////////////////////////////////////////
		
		
		
		
//		request.setAttribute("adoptwait_02trname", dtosadopt2);
	    request.setAttribute("adopt", dtosadopt);
	    
	    System.out.println("윤희지 여기는 커맨드입니다요" + dogid);
		}
	}
