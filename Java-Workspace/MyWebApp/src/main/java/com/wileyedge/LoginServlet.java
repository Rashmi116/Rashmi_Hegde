package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        System.out.println("inside constructor of login servlet");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}*/

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet");
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost");
		String uname=request.getParameter("uname");
		String password=request.getParameter("pwd");
		//System.out.println(uname+" "+password);
		PrintWriter out=response.getWriter();
		System.out.println("forwarding to html");
		ServletConfig config=getServletConfig();
		//config.setAttribute("myname","ashwini");
		
		if(uname.equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uname",uname);
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			rd.forward(request,response);
			out.println("request is forwarded");
			/*out.println("<html>");
			out.println("<body>");
			out.println("<h2> authenication successful </h2>");
			out.println("</body>");
			out.println("</html>");*/
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request,response);
			/*out.println("<html>");
			out.println("<body>");
			out.println("<h2> please enter credentials again </h2>");
			out.println("</body>");
			out.println("</html>");*/
		}
	}

}
