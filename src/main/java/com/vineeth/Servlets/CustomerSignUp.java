package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vineeth.HBConnections.HibernateUtils;
import com.vineeth.model.User;

/**
 * Servlet implementation class CustomerSignUp
 */
public class CustomerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(CustomerSignUp.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		User u = new User();
		u.setFirstName(request.getParameter("fname"));
		u.setLastName(request.getParameter("lname"));
		u.setUserName(request.getParameter("uname"));
		u.setEmailId(request.getParameter("email"));
		u.setPhoneNo(request.getParameter("phoneNo"));
		u.setAddress(request.getParameter("address"));
		u.setAge(Integer.parseInt(request.getParameter("age")));
		u.setAadharNumber(request.getParameter("AadharNum"));
		u.setInitialBalance(Integer.parseInt(request.getParameter("iniBalance")));
		u.setDob(request.getParameter("dob"));
		u.setPassword(request.getParameter("password"));
		u.setGender(request.getParameter("gender"));
		log.info("customer registration details are recieved");
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		      Transaction tx = session.beginTransaction();
		 	    session.save(u);
		 	     tx.commit();
		 	    PrintWriter out=response.getWriter();
				out.println("<html>"
					+ "<head><title>Your Application Successfully Submited</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your Application Successfully Submited</h1>"
					+"<a href=\"customer.html\"><button>Home Page</button></a>"
					+ "</body>"
					+ "</html>");
				log.info("Application Submitted Successfully to the Database");
	}
}
