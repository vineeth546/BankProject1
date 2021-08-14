package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vineeth.model.Employee;
import com.vineeth.operations.ConnectionsUtil;

/**
 * Servlet implementation class EmployeeLoginS
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(EmployeeLogin.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= Integer.parseInt(request.getParameter("empId"));
		String name=request.getParameter("empName");
		String password= request.getParameter("empPassword");
		log.info("Employee Login details are recieved");
		ConnectionsUtil db= new ConnectionsUtil();
		Employee emp= db.getEmpForValidation(id);
		
		if(emp!=null && emp.geteID() ==id && emp.getEmpName().equals(name) && emp.getPassword().equals(password)) {
			response.sendRedirect("employeeTasks.html");
			log.info("Employee Login details are validated successfully");
		}
		else {
				PrintWriter out=response.getWriter();
				out.println("<html>"
						+ "<head><title>Error Page</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Invalid credentials. Please enter valid details</h1>"
						+"<a href=\"Employee.html\"><button>Employee Login</button></a>"
						+ "</body>"
						+ "</html>");
				log.warn("Employee Login details are incorrect");
		}
		
	
	}

}
