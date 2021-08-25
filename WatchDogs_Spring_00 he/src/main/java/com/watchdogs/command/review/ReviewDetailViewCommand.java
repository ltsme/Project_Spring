package com.watchdogs.command.review;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.ReviewDao;
import com.watchdogs.dto.ReviewDto;

public class ReviewDetailViewCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		
		System.out.println("RiviewDetailViewCommand 성공");
		Map<String, Object> map = model.asMap();//map : 포장지  // form/action 
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		dao.countHit(Integer.parseInt(request.getParameter("reid")));
			
		model.addAttribute("reviewdetail", dao.reviewDetail(Integer.parseInt(request.getParameter("reid"))));

	}//execute


		
		
		
		
//		String reid = request.getParameter("reid");
//		int tempid = Integer.parseInt(reid);
//		
//		ReviewDao dao = new ReviewDao();
//		

//		//조회수 사용 위함
//		int result = dao.countHit(tempid);
//		if(result == 1) {
//			ReviewDto dto = dao.reviewDetail(reid);	
//			request.setAttribute("reviewdetail", dto);
//			System.out.println("reviewCount&reviewDetail 실행 성공");
//		}else {
//			System.out.println("reviewCount&reviewDetail 실행 실패");
//		}
//		
			
//	}

	

}
