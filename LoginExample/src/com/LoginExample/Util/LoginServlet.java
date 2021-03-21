package com.LoginExample.Util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType("text/html");  
		   PrintWriter writer= response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password.equals("admin"))
		{
			writer.write("Welocme Page ");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			writer.write("<h1>HEllO</h1>");
			writer.write("<a href='HomeServlet'>Home</a>&nbsp;&nbsp;");
			writer.write("<a href='Login.html'>Login</a>&nbsp;&nbsp;");
			writer.write("<a href='Logout.html'>LogOut</a>&nbsp;&nbsp;");
		}
		else
		{
			RequestDispatcher dispatcher= request.getRequestDispatcher("Login.html");
			dispatcher.include(request, response);
		}
		
		
	}

}
