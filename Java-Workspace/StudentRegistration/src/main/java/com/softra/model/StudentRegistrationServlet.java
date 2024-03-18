package com.softra.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentRegistrationServlet
 */
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        super.init();
        String jdbcUrl = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "root";
        getServletContext().setAttribute("jdbcUrl", jdbcUrl);
        getServletContext().setAttribute("username", username);
        getServletContext().setAttribute("password", password);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        String mobno = request.getParameter("mobno");
	        String address = request.getParameter("address");
	        
	        // Create a Student object with the form data
	        Student student = new Student(name, age, mobno, address);
	        
	        // Store the Student object in the request scope
	        request.setAttribute("student", student);
	        /*request.setAttribute("name",name);
	        request.setAttribute("age",age);
	        request.setAttribute("mobno",mobno);
	        request.setAttribute("address",address);*/
	        
	        // Forward the request to success.jsp
	        RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
	        rd.forward(request, response);
	        
	        String jdbcUrl = (String) getServletContext().getAttribute("jdbcUrl");
	        String username = (String) getServletContext().getAttribute("username");
	        String password = (String) getServletContext().getAttribute("password");
	        StudentDao studentDao = new StudentDao(jdbcUrl, username, password);
	        boolean success = studentDao.insertStudent(student);
	        
	        if (success) {
	        	response.getWriter().println("success to register the student.");
	            
	        } else {
	            // Handle failure scenario
	            response.getWriter().println("Failed to register the student.");
	        }
	
	

}
}
