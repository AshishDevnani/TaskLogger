package com.logger.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logger.entities.TaskDetailsMaster;

@Repository
public class Taskdao {

	@Autowired
	private HibernateTemplate template;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public int createtask(TaskDetailsMaster task) {
		return (int)template.save(task);
	}
	
	
	
	public List<TaskDetailsMaster> getAllTasksByDate(String fromDate,String toDate){
		//List<TaskDetailsMaster> tasks = template.loadAll(TaskDetailsMaster.class,);
		//return tasks;
		TypedQuery<TaskDetailsMaster> tasks = manager.createQuery("FROM TaskDetailsMaster where taskDate>=:fromDate and taskDate<=:toDate",TaskDetailsMaster.class);
		tasks.setParameter("fromDate",fromDate);
		tasks.setParameter("toDate", toDate);
		return tasks.getResultList();
	}
	
	public List<TaskDetailsMaster> getAllTasksByDateAndProject(String fromDate,String toDate,String projectid){
		
		TypedQuery<TaskDetailsMaster> tasks = manager.createQuery("FROM TaskDetailsMaster where taskDate>=:fromDate and taskDate<=:toDate and projectid=:projid",TaskDetailsMaster.class);
		tasks.setParameter("fromDate",fromDate);
		tasks.setParameter("toDate", toDate);
		tasks.setParameter("projid", projectid);
		return tasks.getResultList();
	}
	
public List<TaskDetailsMaster> getAllTasksByDateAndPerson(String fromDate,String toDate,String piid){
		
		TypedQuery<TaskDetailsMaster> tasks = manager.createQuery("FROM TaskDetailsMaster where taskDate>=:fromDate and taskDate<=:toDate and piid=:pi",TaskDetailsMaster.class);
		tasks.setParameter("fromDate",fromDate);
		tasks.setParameter("toDate", toDate);
		tasks.setParameter("pi", piid);
		return tasks.getResultList();
	}

public List<TaskDetailsMaster> getAllTasksByAll(String fromDate,String toDate,String piid,String projectid){
	
	TypedQuery<TaskDetailsMaster> tasks = manager.createQuery("FROM TaskDetailsMaster where taskDate>=:fromDate and taskDate<=:toDate and piid=:pi and projectid=:projid",TaskDetailsMaster.class);
	tasks.setParameter("fromDate",fromDate);
	tasks.setParameter("toDate", toDate);
	tasks.setParameter("pi", piid);
	tasks.setParameter("projid", projectid);
	return tasks.getResultList();
}
}
