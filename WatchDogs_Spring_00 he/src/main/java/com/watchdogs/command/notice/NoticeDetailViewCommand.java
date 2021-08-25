package com.watchdogs.command.notice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.NoticeDao;
import com.watchdogs.dto.NoticeDto;

public class NoticeDetailViewCommand implements BCommand_new {

	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		System.out.println("RiviewDeleteCommand 성공");
		Map<String, Object> map = model.asMap();//map : 포장지  // form/action 
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		
		NoticeDao dao = sqlSession.getMapper(NoticeDao.class);
		dao.countHit(Integer.parseInt(request.getParameter("noid")));
		model.addAttribute("noticedetail", dao.noticedetail(Integer.parseInt(request.getParameter("noid"))));
	
	}//execute

		
//		String noid = request.getParameter("noid");
//		int tempnoid = Integer.parseInt(noid);
//		
//		NoticeDao dao = new NoticeDao();
//		//조회수 사용 위함
//		int result = dao.countHit(tempnoid);
//		if(result == 1) {
//			NoticeDto dto = dao.noticeDetail(noid);	
//			
//			request.setAttribute("noticedetail", dto);
//			System.out.println("reviewCount&reviewDetail 실행 성공");
//
//		}else {
//			System.out.println("noticeCount&noticeDetail 실행 실패");
//		}
//			
//	
//	}

}//end
