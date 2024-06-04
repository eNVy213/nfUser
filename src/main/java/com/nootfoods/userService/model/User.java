package com.nootfoods.userService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"user\"")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	 
	@Column(name = "user_name")
	private String userName;
	 
	@Column(name = "email_add", unique = true)
	private String emailAdd;
	
	@Column(name = "password")
	private String password;
	
	
	public enum userType{
		ADMIN,
		CUSTOMER,
		DELIVERER,
		STOREEXEC
	} 
	@Column(name = "ullu")
	private userType ullu ;
	
	
	
	
	public User() {
		
	}
	
	public User(int userId, String userName, String emailAdd, userType ullu) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailAdd = emailAdd;
		this.ullu = ullu;
	}
	public userType getUllu() {
		return ullu;
	}
	public void setUllu(userType ullu) {
		this.ullu = ullu;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAdd() {
		return emailAdd;
	}
	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", emailAdd=" + emailAdd + ", ullu=" + ullu + "]";
	}
	
	
	
	
	

}
