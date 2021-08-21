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
import com.watchdogs.command.signup.SignUpCommand;

@Controller
public class LoginController {
	
	@Autowired
	private SqlSession sqlSession;
	private LoginCheckCommand loginCheckCommand = new LoginCheckCommand();
	private SignUpCommand signUpCommand = new SignUpCommand();
	private LookUpIdCommand lookUpIdCommand = new LookUpIdCommand();

//	//값 보내는 법! 최근방식
//	@RequestMapping("board/content")
//	public String content(Model model) {
//		model.addAttribute("id", 30);
//		return "board/content";
//	}
	
	@RequestMapping("/home")
	 public String home(HttpServletRequest httpServletRequest, Model model) {
		
			// 아이디, 유저 타입 받음
			String id = httpServletRequest.getParameter("userid");
			String userType = httpServletRequest.getParameter("usertype");
			
			// 아이디, 유저 타입 보냄
			model.addAttribute("userid", id);
			model.addAttribute("usertype", userType);
			
			return "home";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest httpServletRequest, Model model) {
		
		//받음
		String id = httpServletRequest.getParameter("userid");
		String userType = httpServletRequest.getParameter("usertype");
		
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
		
		return "home";
	}
	
	@RequestMapping("/help")
	public String help() {
		return "help";
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
		System.out.println("1");
		lookUpIdCommand.execute(sqlSession, model, httpSession);
		System.out.println("2");
		
		if(httpSession.getAttribute("result").equals(0)) { // 아이디 찾기 실패 
			httpSession.invalidate();
			System.out.println("3");
			return "lookupfail";
			
		}else {
			System.out.println("4");
			return "lookupidpop";	
		}
	}
	
//	@RequestMapping("lookuppwfunction/")
//	public String lookuppwfunction (Model model, HttpServletRequest request, HttpSession httpSession) {
//
//		return "lookuppwpop";
//	}

}

//    case("/lookupidfunction.wd"):  // 아이디 찾기 기능
//  		command = new LookUpIdCommand();
//			command.execute(request, response);		
//			hsession = request.getSession(true);
//			String lookupresultid = (String)hsession.getAttribute("lookupresult");
//
//			if(lookupresultid.equals("")) { // 아이디 찾기 실패
//				viewPage ="lookupfail.jsp";
//			}else{ 	// 아이디 찾기 실패
//				hsession.setAttribute("lookupresult", lookupresultid);
//				viewPage ="lookupidpop.jsp";					
//			} 
//			break;
//			
//    case("/lookuppwfunction.wd"):  // 비밀번호 찾기 기능
//  	  	command = new LookUpPwCommand();
//    		command.execute(request, response);
//    		
//    		hsession = request.getSession(true);
//			String lookupresultpw = (String)hsession.getAttribute("lookupresult");
//
//			if(lookupresultpw.equals("")) { // 비밀번호 찾기 성공
//				viewPage ="lookupfail.jsp";
//			}else{ 	// 비밀번호 찾기 실패
//				hsession.setAttribute("lookupresult", lookupresultpw);
//				viewPage ="lookuppwpop.jsp";
//				
//			} 
//			break;