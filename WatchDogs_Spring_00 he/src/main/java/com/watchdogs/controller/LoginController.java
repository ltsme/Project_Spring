package com.watchdogs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.watchdogs.command.login.LoginCheckCommand;
import com.watchdogs.command.lookup.LookUpIdCommand;
import com.watchdogs.command.lookup.LookUpPwCommand;
import com.watchdogs.command.signup.SignUpCommand;

@Controller
public class LoginController {
	
	@Autowired
	private SqlSession sqlSession;
	private LoginCheckCommand loginCheckCommand = new LoginCheckCommand();
	private SignUpCommand signUpCommand = new SignUpCommand();
	private LookUpIdCommand lookUpIdCommand = new LookUpIdCommand();
	private LookUpPwCommand lookUpPwCommand = new LookUpPwCommand();

	//	값 보내기 
	//	@RequestMapping("board/content")
	//	public String content(Model model) {
	//		model.addAttribute("id", 30);
	//		return "board/content";
	//	}
	
//  -- 로그인, 회원가입, 아이디/비밀번호 찾기
	@RequestMapping("/home")
	 public String home(HttpServletRequest httpServletRequest, Model model) {
		
			//받음
			String id = httpServletRequest.getParameter("userid");
			String userType = httpServletRequest.getParameter("usertype");
			
			//보냄
			model.addAttribute("userid", id);
			model.addAttribute("usertype", userType);
			
			return "home";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest, Model model) {
		
		//받음
		String id = httpServletRequest.getParameter("userid");
		String userType = httpServletRequest.getParameter("usertype");
		
		//보냄
		model.addAttribute("userid", id);
		model.addAttribute("usertype", userType);
		
		return "login";
	}
	
	@RequestMapping("/logincheck")
	public String logincheck(Model model, HttpServletRequest request, HttpSession httpSession) {

		model.addAttribute("request", request);
		
		loginCheckCommand.execute(sqlSession, model, httpSession);
		
		if(httpSession.getAttribute("result").equals(0)) { // result = 0일 때, 로그인 실패 
			httpSession.invalidate();
			return "loginpop";
			
		}else { // result = 1일 때 
			if(httpSession.getAttribute("userdeldate") == null) { //userdeldate가 없을 때, 로그인 성공
				return "home";
			}else {
				httpSession.invalidate();
				return "loginpop"; // userdeldate가 있을 때, 탈퇴 회원
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) {
		
		//보냄
		model.addAttribute("userid", "");
		model.addAttribute("usertype", "");
		
		return "logout";
	}
	
	
	@RequestMapping("/help")
	public String help() {
		return "help";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		//보냄
		model.addAttribute("userid", "");
		model.addAttribute("usertype", "");
		
		return "signup";
	}

	@RequestMapping("/signupfunction")
	public String signupfunction(Model model, HttpServletRequest request, HttpSession httpSession) {

		model.addAttribute("request", request);
		signUpCommand.execute(sqlSession, model, httpSession);

		//보냄
		model.addAttribute("userid", "");
		model.addAttribute("usertype", "");
		
		return "signuppop";
	}
	
	
	@RequestMapping("/lookupidpw")
	public String lookupidpw(Model model) {

		//보냄
		model.addAttribute("userid", "");
		model.addAttribute("usertype", "");
		return "lookup";
	}
	
	@RequestMapping("/lookupidfunction")
	public String lookupidfunction (Model model, HttpServletRequest request, HttpSession httpSession) {
		
		model.addAttribute("request", request);
		lookUpIdCommand.execute(sqlSession, model, httpSession);
		
		if(httpSession.getAttribute("result").equals(0)) { // 아이디 찾기 실패 
			return "lookupfail";
			
		}else {
			return "lookupidpop";	
		}
	}
	
	@RequestMapping("/lookuppwfunction")
	public String lookuppwfunction (Model model, HttpServletRequest request, HttpSession httpSession) {

		model.addAttribute("request", request);
		lookUpPwCommand.execute(sqlSession, model, httpSession);
		if(httpSession.getAttribute("result").equals(0)) { // 아이디 찾기 실패 
			return "lookupfail";
			
		}else {
			return "lookuppwpop";	
		}
	}
	
}// LoginController