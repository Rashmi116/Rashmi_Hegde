package com.wileyedge;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
	
	@RequestMapping(value="/abc.htm",method=RequestMethod.GET)
	public String sayHello1() {
		System.out.println("inside sayHello1() of controller");
		System.out.println("invoking service layer 1");
		return "hello";
	}
	
	@RequestMapping(value="/pqr.htm",method=RequestMethod.GET)
	public String sayHello2(Model model) {
		System.out.println("inside sayHello2() of controller");
		System.out.println("invoking service layer 2");
		model.addAttribute("msg", "welcome to springmvc using annotation");
		return "hello";
	}
	
	@RequestMapping(value="/xyz.htm",method=RequestMethod.GET)
	public String sayHello3(Map<String,String> map) {
		System.out.println("inside sayHello3() of controller");
		System.out.println("invoking service layer 3");
		map.put("msg", "welcome to springmvc using annotation method 3");
		return "hello";
	}
	@RequestMapping(value="/lmn.htm",method=RequestMethod.GET)
	public String sayHello4(HttpServletRequest request,HttpServletResponse response,Model model) {
		System.out.println("inside sayHello4() of controller"+request);
		System.out.println("invoking service layer 4");
		model.addAttribute("msg", "welcome to springmvc using annotation method 3");
		return "hello";
	}
	
	

}
