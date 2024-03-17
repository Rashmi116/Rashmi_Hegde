package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ServletConfig config;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstname");
		String nickname=(String)request.getAttribute("nickname");
		//ServletConfig config=getServletConfig();
		ServletContext context=getServletConfig().getServletContext();
		String lastname=context.getInitParameter("lastname");
		System.out.println("inside servlet2 "+lastname);
		String middlename=getServletConfig().getInitParameter("middlename");
		
		System.out.println("inside servlet1 "+middlename);
		PrintWriter out=response.getWriter();
		out.println("<h2>welcome"+" "+fname+ " "+ nickname+" "+"</h2>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("inside init"+this.getServletConfig().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
