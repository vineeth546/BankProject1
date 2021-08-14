//package com.vineeth.Main;
//
//import javax.ws.rs.Path;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.vineeth.model.Employee;
//import com.vineeth.model.Status;
//import com.vineeth.operations.ConnectionsUtil;
//
////@Path("/employee")
//public class EmployeeOperation {
//	
//	
////	@Path("/employeeLogin")
////	@POST
////	@Produces(MediaType.TEXT_PLAIN)
////	@Consumes(MediaType.TEXT_PLAIN)
//	
//	public String empLogin(String toValidate) throws JsonMappingException, JsonProcessingException {
//		System.out.println(toValidate);
//		
//		ObjectMapper obj=new ObjectMapper();
//		Employee emp=obj.readValue(toValidate, Employee.class);
//		
//		
//		
//		int uid=emp.geteID();
//		String uemail=emp.getEmailID();
//		String password=emp.getPassword();
//		Status s=new Status();
//		ConnectionsUtil empDb= new ConnectionsUtil();
//		Employee empDetails=empDb.getEmpForValidation(uid);
//		if(empDetails!=null) {
//			if(empDetails.getEmailID().equals(uemail) && empDetails.getPassword().equals(password)) {
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
//}
