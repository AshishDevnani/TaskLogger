package com.logger.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectMaster {
	@Id
	int projectid;
	String projectName;
	
	ProjectMaster(int id,String name){
		this.projectid = id;
		this.projectName = name;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ProjectMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
