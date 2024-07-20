package com.logger.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logger.entities.UserMaster;

@Repository
public class Userdao {
	
	@Autowired
	private HibernateTemplate template;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public int createUser(UserMaster user) {
		return (int)template.save(user);
	}
	
	public List<UserMaster> checkByUserName(String userName){
		
	    System.out.println("In UserDAO______checkByUserName");
		
		TypedQuery<UserMaster> users = manager.createQuery("FROM UserMaster where userName=:userName",UserMaster.class);
		users.setParameter("userName",userName);
		
		List<UserMaster> userslist = users.getResultList();
		
		
		
		return userslist;
		
	}
	
public List<UserMaster> checkByPIID(int piid){
		
	    System.out.println("In UserDAO______checkByPIID");
		
		TypedQuery<UserMaster> users = manager.createQuery("FROM UserMaster where piid=:userID",UserMaster.class);
		users.setParameter("userID",piid);
		
		List<UserMaster> userslist = users.getResultList();
		
		
		
		return userslist;
		
	}

public UserMaster verifyLoginCredentials(String username,String password){
	
	UserMaster loginuser  = null;
	
	try {
	
	TypedQuery<UserMaster> user = manager.createQuery("FROM UserMaster where userName =:user and password=:pass",UserMaster.class);
	user.setParameter("user", username);
	user.setParameter("pass", password);
	loginuser = user.getSingleResult();
	
	}catch(NoResultException ex) {
		//ex.printStackTrace();
		loginuser = null;
	}
	
	return loginuser;
}
}
