package com.logger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.dao.ProjectDao;
import com.logger.entities.ProjectMaster;
import java.util.List;

@Service
public class ProjectService {

	@Autowired
	ProjectDao projectdao;
	
	/* public int createNewProject(ProjectMaster project)
	 * {
	 *  return (int)projectdao.createProject(project); 
	 * }
	 */
	
	public Object[] createNewProject(ProjectMaster project) {
		
		
		Object[] arr = new Object[2];
		
		if(this.checkPresentById(project.getProjectid())) {
			arr[0] = 0;
			arr[1] = "Project Id Already Exists";
		}else if(this.checkPresentByName(project.getProjectName())) {
			arr[0] = 0;
			arr[1] = "Project Name Already Exists";
		}else {
			int insrt = projectdao.createProject(project);
			if(insrt >=1) {
				arr[0] = 1;
				arr[1] = "Project Added Successfully";
			}else {
				arr[0] = 0;
				arr[1] = "Project Could Not Be Added" ;
			}
			
		}
		
		return arr;
	}
	
	public boolean checkPresentById(int projectid) {
		List<ProjectMaster> list =  projectdao.checkProjectById(projectid);
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean checkPresentByName(String projectName) {
		List<ProjectMaster> list =  projectdao.checkProjectByName(projectName);
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<ProjectMaster> projectList(){
		List<ProjectMaster> projects = projectdao.getProjectList();
		return projects;
	}
	
}
