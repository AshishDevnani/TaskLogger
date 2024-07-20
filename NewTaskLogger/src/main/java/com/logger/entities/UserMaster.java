package com.logger.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserMaster {

	@Id
	int piid;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String mobileNo;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPiid() {
		return piid;
	}
	public void setPiid(int piid) {
		this.piid = piid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public UserMaster(int piid, String userName, String firstName, String lastName, String password, String mobileNo,String role) {
		super();
		this.piid = piid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.role = role;
	}
	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
