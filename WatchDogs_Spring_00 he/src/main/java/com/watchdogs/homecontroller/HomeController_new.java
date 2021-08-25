package com.watchdogs.homecontroller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController_new {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController_new.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession httpSession) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		// 아이디, 유저 타입 초기화 (실행 시 한번 수행)
				Object initialValue = "";
				
				httpSession.setAttribute("userid", initialValue);
				httpSession.setAttribute("usertype", initialValue);
				
		
		return "home";
	}
	
	
	
	
	
} // HomeController
