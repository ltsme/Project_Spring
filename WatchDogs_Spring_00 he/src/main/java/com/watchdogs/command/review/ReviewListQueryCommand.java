package com.watchdogs.command.review;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.dao.ReviewDao;

public class ReviewListQueryCommand implements BCommand_new {

	int numOfTuplesPerPage = 5;
	
	@Override
	public void execute(SqlSession sqlSession, Model model, HttpSession httpSession) {
		// TODO Auto-generated method stub
		System.out.println("RiviewListCommand 성공");
		
		Map<String, Object> map = model.asMap();//map : 포장지  // form/action 
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		//조건 카테고리, 검색단어 가져오기
		String searchCategory = request.getParameter("searchCategory");
		String searchWord = request.getParameter("searchWord");

		
		int requestPage = 1;
		
		if (request.getParameter("page") != null) {
			requestPage = Integer.parseInt(request.getParameter("page"));
			// content에서 목록보기 요청시 최근 페이지 목록으로 돌아가기 위해 세션에 저
			model.addAttribute("currentPage", requestPage);
		}
		

		int offset = requestPage-1;
		if(offset != 0) {
			offset *= numOfTuplesPerPage;
		}
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);//sql문 가져올거야
		
		int counTotalRows = dao.listQueryCountTotalRows(searchCategory, searchWord);
		
		ArrayList<Integer> pageList = countPage(counTotalRows);
		
		model.addAttribute("pageList", pageList);
		
		//----------query문 완료
		model.addAttribute("reviewlist",dao.reviewListQuery(request.getParameter("searchCategory"), request.getParameter("searchWord"),offset, numOfTuplesPerPage));
		
	}//execute

		
	public ArrayList<Integer> countPage(int countrows) { //countrows는 총 행의 갯수 
	
		
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		int countPage = 0;

		// 게시물 총 갯수가 동일할 때를 위함 
		if (countrows % numOfTuplesPerPage == 0) { 
			countPage = countrows / numOfTuplesPerPage;
		} else {
			countPage = countrows / numOfTuplesPerPage + 1;
		}

		for (int i = 1; i <= countPage; i++) {
			System.out.println(i + "페이지");
			arrlist.add(i);
		}
		return arrlist;

	}//count end
}
