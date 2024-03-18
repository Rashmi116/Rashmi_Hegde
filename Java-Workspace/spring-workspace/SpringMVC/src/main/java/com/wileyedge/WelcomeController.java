package com.wileyedge;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("inside controller");
		System.out.println("going to invoke business layer");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello");
		mav.addObject("msg", "welcome to spring mvc");
		
		return mav;
	}

}
