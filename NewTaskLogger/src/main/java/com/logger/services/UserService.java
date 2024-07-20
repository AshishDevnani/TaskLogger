package com.logger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.dao.Userdao;
import com.logger.entities.UserMaster;

@Service
public class UserService {

	@Autowired
	public Userdao userdao;
	
	public Object[] addNewUser(UserMaster user) {
		
		Object[] arr = new Object[2];
		
		if(this.checkPresentByUserName(user.getUserName())) {
			arr[0] = 0;
			arr[1] = "User-"+user.getUserName()+" Already Exists . Please use another username";
		}else if(this.checkPresentByPIID(user.getPiid())) {
			arr[0] = 0;
			arr[1] = "User with PIID-"+user.getPiid()+" Already Exists";
		}else {
			int insrt = userdao.createUser(user);
			if(insrt >=1) {
				arr[0] = 1;
				arr[1] = "User Added Successfully";
			}else {
				arr[0] = 0;
				arr[1] = "User Could Not Be Added" ;
			}
			
		}
		
		return arr;
	}
	
	public boolean checkPresentByUserName(String username) {
		List<UserMaster> list =  userdao.checkByUserName(username);
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean checkPresentByPIID(int  piid) {
		List<UserMaster> list =  userdao.checkByPIID(piid);
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public UserMaster checkLogin(String user,String pass) {
		UserMaster loginuser =null;
		loginuser = userdao.verifyLoginCredentials(user, pass);
		return loginuser;
	}
	
}
