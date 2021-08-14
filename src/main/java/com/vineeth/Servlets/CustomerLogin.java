package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.vineeth.HBConnections.HibernateUtils;
import com.vineeth.model.User;


public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerLogin() {
        super();
    }
    private static final Logger log=Logger.getLogger(CustomerLogin.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("userid"));
		String name=request.getParameter("username");
//		String username= request.getParameter("userid");
		String password= request.getParameter("password");
		log.info("Customer login details are recieved");
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User s1 = session.get(User.class,id);
	      transaction.commit();
	     
        if(s1!=null)
		{
      	  boolean a= password.equals(s1.getPassword());
      	  if(a)
      	  {
			HttpSession s = request.getSession();
			s.setAttribute("id",id);
			
      	  response.sendRedirect("Customeroperations.html");
//      		RequestDispatcher rd = request.getRequestDispatcher("CustomerOperations.html");
//				rd.forward(request, response);
      	  log.info("Login details are verified Successfully");
      	  }
			
      	  else
      	  {
      		  RequestDispatcher rd = request.getRequestDispatcher("customer.html");
    			//rd.forward(request, response);
    			System.out.println("Invalid Crediential");
    			
    			PrintWriter out=response.getWriter();
    			out.println("<html>"
    				+ "<head><title>Invalid Username and Password</title>"
    				+ "</head>"
    				+ "<body>"
    				+ "<h1>Invalid Username and Password</h1>"
    				+ "</body>"
    				+ "</html>");
    			rd.include(request, response);
    			System.out.println("Invalid Crediential");
    			log.warn("Login details verification failed due to invalid credentials");
      	  }
			
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer.html");
			//rd.forward(request, response);
			System.out.println("Invalid Crediential");
			
			PrintWriter out=response.getWriter();
			out.println("<html>"
				+ "<head><title>Invalid Username and Password</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Invalid Username and Password</h1>"
				+ "</body>"
				+ "</html>");
			rd.include(request, response);
			System.out.println("Invalid Crediential");
		}
		
		session.close();
	}
	
		
		
		
	}


