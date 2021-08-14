//package com.vineeth.Main;
//
//import java.time.LocalDate;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vineeth.model.Employee;
//import com.vineeth.model.Status;
//import com.vineeth.model.User;
//import com.vineeth.operations.ConnectionsUtil;
//
//
//@Path("/user")
//public class CustomerOperations  {
//	@Path("/userSignUp")	
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	public String userSignUp(@FormParam("fname") String fname,@FormParam("lname") String lname,@FormParam("uname") String uname, @FormParam("email") String email, @FormParam("phoneNo") String phoneNo, @FormParam("AadharNum") String AadharNum, @FormParam("address") String address, @FormParam("initialBalance") int iniBalance,@FormParam("dob") LocalDate dob, @FormParam("age") int age, @FormParam("gender") String gender, @FormParam("password") String password ) {
//		User user=new User();
////		DbConnections db=new DbConnections();
////		db.addToCustTable(cust);
//		user.setFirstName(fname);
//		user.setLastName(lname);
//		user.setUserName(uname);
//		user.setEmailId(email);
//		user.setPhoneNo(phoneNo);
//		user.setAadharNumber(AadharNum);
//		user.setAddress(address);
//		user.setInitialBalance(iniBalance);
//		user.setAge(age);
//		user.setDob(dob);
//		user.setGender(gender);
//		user.setPassword(password);
//		ConnectionsUtil cu=new ConnectionsUtil();
//		cu.addToUser(user);
//		return "added successfully";
//	}
//	//user Login
//	@Path("/userLogin")
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	@Consumes(MediaType.TEXT_PLAIN)
//	
//	public String userLogin(String toValidate) throws JsonMappingException, JsonProcessingException {
//		System.out.println(toValidate);
//		
//		ObjectMapper obj=new ObjectMapper();
//		User u=obj.readValue(toValidate, User.class);
//		
//		
//		
//		int uid=u.getId();
//		String uemail=u.getEmailId();
//		String uname=u.getUserName();
//		String password=u.getPassword();
//		Status s=new Status();
//		ConnectionsUtil userDb= new ConnectionsUtil();
//		User userDetails=userDb.getUserValidation(uid);
//		if(userDetails!=null) {
//			if(userDetails.getEmailId().equals(uemail) && userDetails.getUserName().equals(uname) &&userDetails.getPassword().equals(password)) {
//				s.setStatus("true");
//				return obj.writeValueAsString(s);
//			}
//			else {
//				s.setStatus("false");
//				return obj.writeValueAsString(s);
//			}
//			
//		}
//		return null;	
//		
//	}
//
//	
//
//}
//
