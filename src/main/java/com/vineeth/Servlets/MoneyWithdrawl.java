package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.vineeth.model.User;
import com.vineeth.operations.ConnectionsUtil;

/**
 * Servlet implementation class MoneyWithdrawl
 */
public class MoneyWithdrawl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(MoneyWithdrawl.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyWithdrawl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("userName");
		int id= Integer.parseInt(request.getParameter("Id"));
		String password= request.getParameter("password");
		int money=Integer.parseInt(request.getParameter("money"));
		log.info("details for the depositing money is recieved");
		ConnectionsUtil db= new ConnectionsUtil();
		User u= db.userDataValidation(id);
		
		
		if(u!=null && u.getId()==id && u.getUserName().equals(name) && u.getPassword().equals(password)) {
			PrintWriter out= response.getWriter();
			int newBalance=u.getInitialBalance()-money;
			if(newBalance>5000) {
			
			u.setInitialBalance(newBalance);
			db.updateInDB(u);
			out.println("<html>"
					+ "<head><title>WithDraw Amount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+u.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");  
			log.info("details are verified and the balance of customer is recieved from Database");
			}
			else {
				out.println("<html>"
						+ "<head><title>Error</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Sorry Insufficient balance</h1>"
						+ "</body>"
						+ "</html>");
				log.warn("Details are insufficient");
			}
		}
		else if(u!=null && u.getId()!=id && !(u.getUserName().equals(name)) && !(u.getPassword().equals(password))) {
				PrintWriter out=response.getWriter();
				String htmlRespone = "<html>";
		             
				out.println("<html>"
						+ "<head><title>Error</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Sorry There is a error</h1>"
						+ "</body>"
						+ "</html>");   
				log.warn("Details are mismatched from the database");
				
		}
		
	}
}
