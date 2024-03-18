package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
/* http://localhost:8080/MyWebApp/hello */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        System.out.println("inside constructor of myservlet");
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/*public void init(ServletConfig config) throws ServletException {
		
		System.out.println("inside init method ");
	}*/

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("inside destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doGet");
		PrintWriter out=response.getWriter();
		request.setAttribute("myname","rashmi");
		ServletContext context=getServletConfig().getServletContext();
		context.setAttribute("myname","lavanya");
		System.out.println("forwarding request to html");
		RequestDispatcher rd=request.getRequestDispatcher("loginform.jsp");
		rd.forward(request,response);
		//String value=request.getParameter("name");
		//out.print("hello from the server "+value);
		/*out.println("<html>");
		out.println("<body>");
		out.println("<h2> login page</h2>");
		out.println("<form action='login' method='post'>");
		out.println("Enter Username : <input type='text' name='uname'/><br>");
		out.println("Enter Password : <input type='password' name='pwd'/><br>");
		out.println("<input type='submit' value='Sign In'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost");
		doGet(request, response);
	}

}
