package com.watchdogs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.command.review.ReviewDeleteCommand;
import com.watchdogs.command.review.ReviewDetailViewCommand;
import com.watchdogs.command.review.ReviewListCommand;
import com.watchdogs.command.review.ReviewListQueryCommand;
import com.watchdogs.command.review.ReviewMdViewCommand;
import com.watchdogs.command.review.ReviewModifyCommand;
import com.watchdogs.command.review.ReviewWriteCommand;

@Controller
public class ReviewController {
	
	@Autowired
	private SqlSession sqlSession;
	
	BCommand_new command = null;
	
	
	//리뷰 리스트 보여주기
	@RequestMapping("/reviewlist")
	public String reviewList(HttpServletRequest request, Model model) {
		
		//받음
		String id = request.getParameter("userid");
		String userType = request.getParameter("usertype");
		
		//보냄
		model.addAttribute("userid", id);
		model.addAttribute("usertype", userType);
		
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		command = new ReviewListCommand();
		command.execute(sqlSession, model, httpSession);
		return "reviewlist";
	}
	
	//글쓰기 작성시 글쓰기 폼으로 가기
	@RequestMapping("/review")
	public String review(HttpServletRequest request, Model model) {
		
		//받음
		String id = request.getParameter("userid");
		String userType = request.getParameter("usertype");
		
		//보냄
		model.addAttribute("userid", id);
		model.addAttribute("usertype", userType);
		
		return "review_write";
	}
	
	//글쓰기 폼에서 입력후 후기작성 누르면 DB로 값 입력되게 하기
	@RequestMapping("/review_write")
	public String reviewWrite(MultipartHttpServletRequest multirequest, Model model) {

		//HttpServletRequest :  jsp 에서 유저가 쓴 값을 받아 올때 씀, --get Text 
		//Model 은 쿼리 작업 후 jsp 로 값을 넘길때 사용하므로 얘는 model이 필요 없다. ---set Text 
		//Command는 jsp에서 받아온 애들을 if문 등으로 조건을 달면서 길어지면 사용한다
//		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
//		System.out.println("request get Parameter _ retitle" + request.getParameter("retitle"));
//		dao.review_write(request.getParameter("retitle"), request.getParameter("recontent"), request.getParameter("redate"), request.getParameter("userid"), request.getParameter("refilepath"));
		HttpSession httpSession = multirequest.getSession();		
		
		model.addAttribute("multirequest", multirequest);
		command = new ReviewWriteCommand();
		command.execute(sqlSession, model, httpSession);
		
		return "redirect:reviewlist";
	}
	
	//리스트에서 글 눌러 상세보기
	@RequestMapping("/reviewdetail")
	public String reviewDetail(HttpServletRequest request, Model model) {
//		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
//		model.addAttribute("reviewdetail", dao.reviewdetail(Integer.parseInt(request.getParameter("reid"))));
		//jsp 로 이름을 reviewdetail로 보낼거야!
		
		//받음
		String id = request.getParameter("userid");
		String userType = request.getParameter("usertype");
		
		//보냄
		model.addAttribute("userid", id);
		model.addAttribute("usertype", userType);
		
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		
		command = new ReviewDetailViewCommand();
		command.execute(sqlSession, model, httpSession);
		return "review_detailview";

	}
	//수정/삭제 누르면 수정/삭제 화면으로 넘어가기
	@RequestMapping("/review_mdview")
	public String review_mdview(HttpServletRequest request, Model model) {
//		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
//		model.addAttribute("reviewdetail", dao.reviewdetail(Integer.parseInt(request.getParameter("reid"))));
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		command = new ReviewMdViewCommand();
		command.execute(sqlSession, model, httpSession);
		return "review_mdview";
	}

	//수정 버튼 누르면 수정
	@RequestMapping("reviewmodify")
	public String reviewModify(MultipartHttpServletRequest multirequest, Model model) {
//	ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
//	dao.review_modify(Integer.parseInt(request.getParameter("reid")), request.getParameter("retitle"), request.getParameter("recontent"), request.getParameter("refilepath"));
		HttpSession httpSession = multirequest.getSession();
		model.addAttribute("multirequest", multirequest);
		
		command = new ReviewModifyCommand();
		command.execute(sqlSession, model, httpSession);
	
		return "redirect:reviewlist";
	}
	
	
	//삭제 버튼 누르면 삭제
	@RequestMapping("/reviewdelete")
	public String review_delete(HttpServletRequest request, Model model) {
//		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
//		dao.review_delete(Integer.parseInt(request.getParameter("reid")));
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		command = new ReviewDeleteCommand();
		command.execute(sqlSession, model, httpSession);
		return "redirect:reviewlist";
	}
	
	//조건 검색
	@RequestMapping("/reviewlistquery")
	public String reviewListQuery(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();
		
		model.addAttribute("request", request);
		
		command = new ReviewListQueryCommand();
		command.execute(sqlSession, model, httpSession);
		
		return "reviewlist";
	}

}
