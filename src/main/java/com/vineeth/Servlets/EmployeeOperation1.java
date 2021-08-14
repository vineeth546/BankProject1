package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import com.vineeth.HBConnections.HibernateUtils;
import com.vineeth.model.User;
import com.vineeth.operations.ConnectionsUtil;

/**
 * Servlet implementation class EmployeeOperation1
 */
public class EmployeeOperation1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOperation1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Session session = HibernateUtils.getSessionFactory().openSession();
		List<User> results=session.createQuery("from User", User.class).list();
	   /*  for(Coustmer s: results)
	     {
	    	System.out.println(s);
	     }*/
		 PrintWriter out=response.getWriter();
			out.println(""
					+"<html>"
					+"<head>"
					+"<style>"
					+"table {"
					 + "font-family: arial, sans-serif;"
					  +"border-collapse: collapse;"
					  +"width: 100%;"
					+"}"

					+"td, th {"
					 + "border: 1px solid #dddddd;"
					  +"text-align: left;"
					  +"padding: 8px;"
					+"}"

					+"tr:nth-child(even) {"
					 + "background-color: #dddddd;"
					+"}"
					+"</style>"
					+"</head>"
					+"<body>"
					
					+ "<div class=\"container\">"
					+ "  <h2>Bank Customer Details</h2>"
					+ "  <table class=\"table\">"
					+ "    <thead>"
					+ "      <tr>"
					+ "        <th>Id</th>"
					+ "        <th>Name</th>"
					+ "        <th>Email</th>"
					+"<th>mobile No</th>"
					+ "      </tr>"
					+ "    </thead>"
					+ "    <tbody>");
			
			for(User s: results)
		     {
			out.println( "      <tr class=\"danger\">"
					+ "        <td>"+s.getId()+"</td>"
					+ "        <td>"+s.getUserName()+"</td>"
					+ "        <td>"+s.getEmailId()+"</td>"
					+"<td>"+s.getPhoneNo()+"</td>"
					+ "      </tr>");
		     }	
					out.println( "    </tbody>"
					+ "  </table>"
					+ "</div>"
					+ "<a href=\"employeeTasks.html\">Back </a>"
					+ "</body>"
					+ "</html>");
					 RequestDispatcher rd=request.getRequestDispatcher("/employeeTasks.html");  
//			         rd.include(request, response); 
		
	}
   
//		// TODO Auto-generated method stub
//		PrintWriter out= response.getWriter();
//		ConnectionsUtil db=new ConnectionsUtil();
//		List<User> li=db.getUserDetails();
//		 out.println("<table id=\"customers\">");  
//         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");  
//         
//		for(int i=0;i<li.size();i++) {
//			int cust_id=li.get(i).getId();
//			String cust_name=li.get(i).getUserName();
//			String cust_contact=li.get(i).getPhoneNo();
//		
//			int cust_balance=li.get(i).getInitialBalance();
//			
//			out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + cust_contact + "</td><td>"+ cust_balance+ "</td></tr>"); 
//			
//		}
//		 RequestDispatcher rd=request.getRequestDispatcher("/employeeTasks.html");  
//         rd.include(request, response); 
//		 
//	}


   
//    /**
//     * Servlet implementation class EmployeeCustomerDetails
//     */
//    public class EmployeeOperation1 extends HttpServlet {
//    	private static final long serialVersionUID = 1L;
//           
//        /**
//         * @see HttpServlet#HttpServlet()
//         */
//        public EmployeeOperation1() {
//            super();
//            // TODO Auto-generated constructor stub
//        }
//
//    	/**
//    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//    	 */
//    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    		// TODO Auto-generated method stub
//    		PrintWriter out= response.getWriter();
//    		ConnectionsUtil db=new ConnectionsUtil();
//    		List<User> li=db.getUserDetails();
//    		 out.println("<table id=\"customers\">");  
//             out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");  
//             
//    		for(int i=0;i<li.size();i++) {
//    			int user_id=li.get(i).getId();
//    			String user_name=li.get(i).getUserName();
//    			String User_contact=li.get(i).getPhoneNo();
//    			String AadharNumber=li.get(i).getAadharNumber();
//    			
//    			int user_balance=li.get(i).getInitialBalance();
//    			
//    			out.println("<tr><td>" + user_id+ "</td><td>" + user_name + "</td><td>" + User_contact + "</td><td>" + AadharNumber+ "</td><td>"+ user_balance+ "</td></tr>"); 
//    			
//    		}
//    		 RequestDispatcher rd=request.getRequestDispatcher("/employeeOperation1.html");  
//             rd.include(request, response); 
//    		 
//    	}
//
//    	/**
//    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		
    		// TODO Auto-generated method stub
    				int id=Integer.parseInt(request.getParameter("userid"));
    				String name= request.getParameter("username");
    				ConnectionsUtil db= new ConnectionsUtil();
    				User u= db.userDataValidation(id);
    				PrintWriter out= response.getWriter();
    					if(u!=null && u.getId()==id && u.getUserName()==name) {
    						int cust_id=u.getId();
    						String cust_name=u.getUserName();
    						String contact_no=u.getPhoneNo();
    						String Aadhar=u.getAadharNumber();
    						int cust_balance=u.getInitialBalance();
    						out.println("<table id=\"customers\">");  
    				         out.println("<tr><th>CustomerId</th><th>CustomerName</th><th>customerContact</th><th>customerPanCard</th><th>Balance</th><tr>");
    				         out.println("<tr><td>" + cust_id + "</td><td>" + cust_name + "</td><td>" + contact_no + "</td><td>" + Aadhar + "</td><td>"+ cust_balance+ "</td></tr>"); 
    				         RequestDispatcher rd=request.getRequestDispatcher("/employeeTasks.html");  
    				         rd.include(request, response); 
    					
    					}
    	}
    	}
