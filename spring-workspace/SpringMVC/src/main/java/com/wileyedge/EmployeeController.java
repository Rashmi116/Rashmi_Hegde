package com.wileyedge;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.wileyedge.IDao;
import com.wileyedge.IService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IService service;
	
	@Autowired
	@Qualifier("empval")
	private Validator validator;
	
	@RequestMapping(value="/getform.htm",method=RequestMethod.GET)
	public String showEmpForm(Map<String,Employee> map) {
		System.out.println("inside showEmpForm");
		map.put("emp", new Employee());
		return "empForm";
	}

	@RequestMapping(value="/saveemp.htm",method=RequestMethod.POST)
	//public String persistEmp(@RequestParam("empid") int id,String fname,String lname,Map<String,Employee> map) {
	public String persistEmp(@ModelAttribute("emp") Employee e,BindingResult result,Map<String,Employee> map) {
	//System.out.println("inside persistEmp");
	//System.out.println("id "+id+" fname "+fname+" lname "+lname);
		System.out.println(e);
		List<Employee>list=new ArrayList<>();
		list.add(e);
		validator.validate(e,result);
		if(result.hasErrors()) {
			return "empForm";
		}
		service.saveEmployees(list);
		return "success";
	}
	
	@RequestMapping(value="/changeLocale.htm",method=RequestMethod.GET)
	public String changeLocale(String lang,HttpServletRequest request,Model model) {
		System.out.println("inside changeLocale "+lang);
		HttpSession session=request.getSession();
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale(lang));
		model.addAttribute("emp", new Employee());
		return "redirect:getform.htm";
		
		
	}

}
