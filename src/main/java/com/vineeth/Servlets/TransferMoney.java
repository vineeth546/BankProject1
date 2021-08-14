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
 * Servlet implementation class TransferMoney
 */
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
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
		// TODO Auto-generated method stub
		String name=request.getParameter("userName");
		int id=Integer.parseInt(request.getParameter("Id"));
//		int id=3;
		String password= request.getParameter("password");
		int money=Integer.parseInt(request.getParameter("money"));
		ConnectionsUtil db= new ConnectionsUtil();
		User us1= db.userDataValidation(id);
		
		
		if(us1!=null && us1.getId()==id && us1.getUserName().equals(name) && us1.getPassword().equals(password)) {
			PrintWriter out= response.getWriter();
			int newBalance=us1.getInitialBalance()-money;
			if(newBalance>5000) {
			
			us1.setInitialBalance(newBalance);
			db.updateInDB(us1);
			out.println("<html>"
					+ "<head><title>Transfer Amount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+us1.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");
			}
			else {
				out.println("<html>"
						+ "<head><title>Error</title>"
						+ "</head>"
						+ "<body>"
						+ "<h1>Sorry Insufficient balance</h1>"
						+ "</body>"
						+ "</html>");
			}
		}
		else if(us1!=null && us1.getId()!=id && !(us1.getUserName().equals(name)) && !(us1.getPassword().equals(password))) {
				PrintWriter out=response.getWriter();
				String htmlRespone = "<html>";
		             
		        htmlRespone += "<h2>Sorry some Error "+"</h2>";    
				
		}
		
	}
}
