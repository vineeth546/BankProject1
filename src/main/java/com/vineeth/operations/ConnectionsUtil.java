package com.vineeth.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vineeth.model.Employee;
import com.vineeth.model.User;
import com.vineeth.HBConnections.*;



public class ConnectionsUtil 
{
	
   
    public static void addToEmpTable()
    {
    		Session session=null;
    		Transaction transaction=null;
    		
    		try {
    			session = HibernateUtils.getSessionFactory().openSession();
    			transaction= session.beginTransaction();
    			Employee s=new Employee(1002,"vineeth","yadav","Vineeth_546","Yadav12",85198094,"vineeth@gmail.com");
    			session.save(s);
    			transaction.commit();
    		}
    		catch(Exception e) {
    			if(transaction!=null) {
    				transaction.rollback();
    			}
    			e.printStackTrace();
    		}finally {
    			if(session!=null) {
    				session.close();
    			}
    		}
    	}
    
    
    public void addToUser(User user1) {
    	Session session=null;
    	Transaction transaction=null;
    	
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.save(user1);
    		transaction.commit();
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
    	
    }


	public Employee getEmpForValidation(int empId) {
		Session session=null;
    	Transaction transaction=null;
   	    Employee empFromDB=null;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		empFromDB=session.get(Employee.class, empId);
    		transaction.commit();
    		return empFromDB;
   	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
		return empFromDB ;
   	
		
}
	public User userDataValidation(int id) {
		// TODO Auto-generated method stub
		Session session=null;
    	Transaction transaction=null;
    	User u=null;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		u=(User)session.get(User.class,id);
    		
    		transaction.commit();
    		System.out.println(u.getUserName());
    		
    		return u;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		throw e;
    	
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
		
    	
		
	}
	public User getUserValidation(int id) {
		Session session=null;
    	Transaction transaction=null;
    	User userFromDb=null;
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		userFromDb=session.get(User.class, id);
    		transaction.commit();
    		return userFromDb;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
		return userFromDb ;
    	
		
	}


	public User updateInDB(User user) {
		// TODO Auto-generated method stub
		Session session=null;
    	Transaction transaction=null;
    	
    	try {
    		session=HibernateUtils.getSessionFactory().openSession();
    		transaction= session.beginTransaction();
    		session.saveOrUpdate(user);
    		
    		transaction.commit();
    		System.out.println(user.getUserName());
    		
    		return user;
    	}
    	catch(Exception e) {
    		if(transaction!=null) {
    			transaction.rollback();
    		}
    		throw e;
    	
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
    	}
	}
	
	public List < User > getUserDetails() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", User.class).list();
        }
    }
	
    } 



