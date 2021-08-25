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

public class BAdoptcomplete_02coammand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model,HttpSession httpSession) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap(); 
		HttpServletRequest request = (HttpServletRequest) map.get("adoptcomplete_02");
		
		
		 int dogid = Integer.parseInt(request.getParameter("dogid"));
		 
		 BDaoAdopt daoadopt = sqlSession.getMapper(BDaoAdopt.class);
		    HttpSession session = request.getSession();
		    
		    ArrayList<BDtoAdopt> dtosadopt = daoadopt.adoptcomplete_02(dogid);
		    
		    request.setAttribute("adopt", dtosadopt);
            System.out.println("여기는 adoptcomplete_02 커멘드야");
	}

}
