package com.logger.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logger.entities.ProjectMaster;

@Repository
public class ProjectDao {
	
	@Autowired
	private HibernateTemplate template;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public int createProject(ProjectMaster project) {
		return (int)template.save(project);
	}
	
	public List<ProjectMaster> checkProjectById(int projid){
		
		System.out.println("In ProjectDAO______checkProjectById");
		
		TypedQuery<ProjectMaster> projectcheck = manager.createQuery("FROM ProjectMaster where projectid=:projectId",ProjectMaster.class);
		projectcheck.setParameter("projectId",projid);
		
		
        List<ProjectMaster> projectlist = projectcheck.getResultList();
        
        //boolean flag = false;
        //System.out.println("projectlist:"+projectlist); 
        //System.out.println("Empty Flag::::"+projectlist.isEmpty());
		
		/*
		 * for(ProjectMaster p : projectlist) { flag = true;
		 * System.out.println("p:"+p.getProjectid()+" "+p.getProjectName()); }
		 */
		
	
		
		
		return projectlist ;
	}
	
public List<ProjectMaster> checkProjectByName(String projName){
	
	    System.out.println("In ProjectDAO______checkProjectByName");
		
		TypedQuery<ProjectMaster> project = manager.createQuery("FROM ProjectMaster where projectName=:projectName",ProjectMaster.class);
		project.setParameter("projectName",projName);
		
		List<ProjectMaster> projectlist = project.getResultList();
		
		//boolean flag = false;
		//System.out.println("projectlist:"+projectlist);
		//System.out.println("Empty Flag::::"+projectlist.isEmpty());
		
		/*
		 * for(ProjectMaster p : projectlist) { flag=true;
		 * System.out.println("p:"+p.getProjectid()+" "+p.getProjectName()); }
		 */
		
		return projectlist;
		
	}

public List<ProjectMaster> getProjectList()
{
	    TypedQuery<ProjectMaster> projects = manager.createQuery("FROM ProjectMaster",ProjectMaster.class);
		return projects.getResultList();
}

}

