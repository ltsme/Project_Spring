package com.watchdogs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.watchdogs.command.adopt.BAdoptSearchcommand;
import com.watchdogs.command.adopt.BAdoptcommand;
import com.watchdogs.command.adopt.BAdoptcomplete_02coammand;
import com.watchdogs.command.adopt.BAdoptcompletecoammand;
import com.watchdogs.command.adopt.BAdoptproceeding_02command;
import com.watchdogs.command.adopt.BAdoptproceedingcommand;
import com.watchdogs.command.adopt.BAdopttrainingcommand;
import com.watchdogs.command.adopt.BAdopttrainingcommand_02;
import com.watchdogs.command.adopt.BAdoptwait_02command;
import com.watchdogs.command.home.BCommand;
import com.watchdogs.command.home.BCommand_new;
import com.watchdogs.command.home.BHomeCommand;
import com.watchdogs.dao.BDaoAdopt;

@Controller
public class AdoptController {
	
	@Autowired
	private SqlSession sqlSession;
	HttpSession httpSession;
	BCommand_new command =null;
	BCommand command2 = null;

	
	@RequestMapping("/adopt")
	public String adopt(HttpServletRequest request, Model model) {
		model.addAttribute("adoptwait", request);
		command = new BAdoptcommand();
		command.execute(sqlSession, model,httpSession);
		return "adoptwait";
	}
	
	@RequestMapping("/adoptwait_02")
	public String adoptwait_02(HttpServletRequest request, Model model) {
		model.addAttribute("adoptwait_02", request);
		command = new BAdoptwait_02command();
		command.execute(sqlSession, model,httpSession);
		return "/adoptwait_02";
	} 
	
	
	@RequestMapping("/adoptapply")
	public String adoptapply_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptapply", request);
		BDaoAdopt dao = sqlSession.getMapper(BDaoAdopt.class);
		dao.adoptapply(request.getParameter("dogid"));
		return "redirect:adopt";
	}
	
	@RequestMapping("/adoptcomplete")
	public String adoptcomplete_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptcomplete", request);
		command = new BAdoptcompletecoammand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptcomplete";
	}
	@RequestMapping("/adoptcomplete_02")
	public String adoptcomplete_02_wdadoptcomplete_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptcomplete_02", request);
		command = new BAdoptcomplete_02coammand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptcomplete_02";
	}
	
	@RequestMapping("/adoptproceeding")
	public String adoptproceeding_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptproceeding", request);
		command = new BAdoptproceedingcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptproceeding";
	}
	
	@RequestMapping("/adoptproceeding_02")
	public String adoptproceeding_02_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptproceeding_02", request);
		command = new BAdoptproceeding_02command();
		command.execute(sqlSession, model,httpSession);
		return "/adoptproceeding_02";
	}
	
	@RequestMapping("/adopttraining")
	public String adopttraining_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adopttraining", request);
		command = new BAdopttrainingcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adopttraining";
	}
	
	@RequestMapping("/adopttraining_02")
	public String adopttraining_02_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adopttraining_02", request);
		command = new BAdopttrainingcommand_02();
		command.execute(sqlSession, model,httpSession);
		return "/adopttraining_02";
	}
	@RequestMapping("/adoptwaitSearch")
	public String adoptwaitSearch_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptSearch", request);
		command = new BAdoptSearchcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptwait";
	}
	
	@RequestMapping("/adoptproceedingSearch")
	public String adoptproceedingSearch_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptSearch", request);
		command = new BAdoptSearchcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptproceeding";
	}
	@RequestMapping("/adoptcompleteSearch")
	public String adoptcompleteSearch_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptSearch", request);
		command = new BAdoptSearchcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptcomplete";
	}
	
	@RequestMapping("/adopttrainingSearch")
	public String adopttrainingSearch_wd(HttpServletRequest request, Model model) {
		model.addAttribute("adoptSearch", request);
		command = new BAdoptSearchcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adopttraining";
	}
	
	@RequestMapping("/adoptimginsert")
	public String adoptimginsert_wd(HttpServletRequest request, Model model) {
	
		command = new BAdoptSearchcommand();
		command.execute(sqlSession, model,httpSession);
		return "/adoptimginsert";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
