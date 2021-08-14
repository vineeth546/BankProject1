package com.vineeth.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vineeth.model.User;
import com.vineeth.operations.ConnectionsUtil;

/**
 * Servlet implementation class ViewBalance
 */
public class ViewBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBalance() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("userName");
	int id= Integer.parseInt(request.getParameter("Id"));
	String password= request.getParameter("password");
	
	ConnectionsUtil db= new ConnectionsUtil();
	User u= db.userDataValidation(id);
	
	
	if(u!=null && u.getId()==id && u.getUserName().equals(name) && u.getPassword().equals(password)) {
		PrintWriter out= response.getWriter();
		int newBalance=u.getInitialBalance();
		
		
		u.setInitialBalance(newBalance);
		db.updateInDB(u);
		out.println("<html>"
				+ "<head><title>Check balance</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Your current balance is:"+u.getInitialBalance()+"</h1>"
				+ "</body>"
				+ "</html>");   
		}
		
	
	else if(u!=null && u.getId()!=id && !(u.getUserName().equals(name)) && !(u.getPassword().equals(password))) {
			PrintWriter out=response.getWriter();
			out.println("<html>"
					+ "<head><title>Error</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Sorry There is a error</h1>"
					+ "</body>"
					+ "</html>");      
			
	}

}

}
