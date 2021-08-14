package com.vineeth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eID, String firstName, String lastName, String empName, String password, long phoneNo,
			String emailID) {
		super();
		this.eID = eID;
		this.firstName = firstName;
		LastName = lastName;
		this.empName = empName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.EmailID = emailID;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eID;
	@Column
	private String firstName;
	@Column
	private String LastName;
	@Column
	private String empName;
	@Column
	private String password;
	@Column
	private long phoneNo;
	@Column
	private String EmailID;
	public int geteID() {
		return eID;
	}
	public void seteID(int eID) {
		this.eID = eID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	@Override
	public String toString() {
		return "Employee [eID=" + eID + ", firstName=" + firstName + ", LastName=" + LastName + ", empName=" + empName
				+ ", password=" + password + ", phoneNo=" + phoneNo + ", EmailID=" + EmailID + "]";
	}
	
}
