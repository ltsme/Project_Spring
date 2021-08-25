package com.watchdogs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.command.notice.NoticeDetailViewCommand;
import com.watchdogs.command.notice.NoticeListCommand;
import com.watchdogs.command.notice.NoticeListQueryCommand;

@Controller
public class NoticeController {
	
	@Autowired
	private SqlSession sqlSession;
	BCommand_new command = null;
	
	//공지 리스트 보여주기
	@RequestMapping("/noticelist")
	public String noticeList(HttpServletRequest request, Model model) {
		
		System.out.println("NoticeController_noticeList 진입");
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		command = new NoticeListCommand();
		command.execute(sqlSession, model, httpSession);
		
		return "noticelist";
	}
	
	//리스트에서 글 눌러 상세보기
	@RequestMapping("/noticedetail")
	public String noticeDetail(HttpServletRequest request, Model model) {
	
//		NoticeDao dao = sqlSession.getMapper(NoticeDao.class);
//		model.addAttribute("noticedetail", dao.noticedetail(Integer.parseInt(request.getParameter("noid"))));
		HttpSession httpSession = request.getSession();
		model.addAttribute("request", request);
		command = new NoticeDetailViewCommand();
		command.execute(sqlSession,model, httpSession);
		
		return "notice_detailview";

	}

	//조건 검색
	@RequestMapping("/noticelistquery")
	public String noticeListQuery(HttpServletRequest request, Model model) {
		HttpSession httpSession = request.getSession();	
		model.addAttribute("request", request);
		command = new NoticeListQueryCommand();
		command.execute(sqlSession, model, httpSession);
		
		return "noticelist";
	}
}
