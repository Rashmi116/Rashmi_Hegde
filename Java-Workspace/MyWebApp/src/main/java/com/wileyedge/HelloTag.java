package com.wileyedge;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
	private String name;
	
	PageContext pageContext = null;
	
	
	public HelloTag() {
		System.out.println("inside constructor of hellotag");
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("inside dotag() of hellotag");
		pageContext = (PageContext)getJspContext();
		JspWriter out=pageContext.getOut();
		out.print("Welcome Mr. " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("inside set name of hellotag");
		this.name = name;
	}
	
	

}
