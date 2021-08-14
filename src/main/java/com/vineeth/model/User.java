package com.vineeth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class User {
	public User(String firstName, String lastName, String userName, String emailId, String gender, int age,
			String aadharNumber, String phoneNo, String dob, String address, String password, int initialBalance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.emailId = emailId;
		this.gender = gender;
		this.age = age;
		this.aadharNumber = aadharNumber;
		this.phoneNo = phoneNo;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.initialBalance = initialBalance;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private String lastName;
	@Column(nullable=false)
	private String userName;
	@Column(nullable=false)
	private String emailId;
	@Column(nullable=false)
	private String gender;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private String aadharNumber;
	@Column(nullable=false)
	private String phoneNo;
	@Column(nullable=false)
	private String dob;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private int initialBalance;
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="customer")
//	private List<Transaction>transac=new ArrayList<Transaction>();
//	public List<Transaction> getTransac() {
//		return transac;
//	}
//	public void setTransac(List<Transaction> transac) {
//		this.transac = transac;
//	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAadharNumber() {
		return aadharNumber;
	
	}
	public void setAadharNumber(String aadharNumber)
	{
		this.aadharNumber=aadharNumber;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(int initialBalance) {
		this.initialBalance = initialBalance;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String string) {
		this.dob = string;
	}


}
