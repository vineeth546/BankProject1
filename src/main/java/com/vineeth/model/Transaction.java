//package com.vineeth.model;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//@Entity
//@Table
//public class Transaction {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column (name="Id")
//	private int id;
//	
//	@Column (nullable=false)
//	private String transactionDetail;
//	
//	@Column (nullable=false)
//	private String transac_date;
//	
//	@Column (nullable=false)
//	private String transac_time;
//	
//	@ManyToOne
//	 @JoinColumn(name = "id")
//	private User user;
//	
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getTransactionDetail() {
//		return transactionDetail;
//	}
//	public void setTransactionDetail(String transactionDetail) {
//		this.transactionDetail = transactionDetail;
//	}
//	
//}
//
