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
 * Servlet implementation class TransactionsDeposit
 */
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log=Logger.getLogger(CustomerSignUp.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("userName");
//		int id=Integer.parseInt(request.getParameter("Id"));
		int id =3;
		String password= request.getParameter("password");
		int money=Integer.parseInt(request.getParameter("money"));
		ConnectionsUtil db= new ConnectionsUtil();
		User u1= db.userDataValidation(id);
		
		
		if(u1!=null && u1.getId()==id && u1.getUserName().equals(name) && u1.getPassword().equals(password)) {
			PrintWriter out= response.getWriter();
			int newBalance=u1.getInitialBalance()+money;
			u1.setInitialBalance(newBalance);
			db.updateInDB(u1);
			out.println("<html>"
					+ "<head><title>Deposit Amount</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>Your current balance is:"+u1.getInitialBalance()+"</h1>"
					+ "</body>"
					+ "</html>");     
	        
		}
		else if(u1!=null && u1.getId()!=id && !(u1.getUserName().equals(name)) && !(u1.getPassword().equals(password))) {
			PrintWriter out=response.getWriter();
				//String htmlRespone = "<html>";
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

