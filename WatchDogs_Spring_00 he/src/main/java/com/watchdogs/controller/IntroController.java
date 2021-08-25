package com.watchdogs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroController {
	
//  -- 소개(Introduction)
	
	@RequestMapping("/introduction")
	public String login(HttpServletRequest httpServletRequest, Model model) {
		
		//받음
		String id = httpServletRequest.getParameter("userid");
		String userType = httpServletRequest.getParameter("usertype");
		
		//보냄
		model.addAttribute("userid", id);
		model.addAttribute("usertype", userType);
		
		return "introduction";
	}

}
