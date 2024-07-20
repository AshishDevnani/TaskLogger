package com.logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.logger.entities.ProjectMaster;
import com.logger.services.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService service;

	@RequestMapping("/addprojectaction")
	public ModelAndView addNewProject(@ModelAttribute ProjectMaster newproject) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddProject");
		
		System.out.println("Project Id:"+newproject.getProjectid());
		System.out.println("Project Name:"+newproject.getProjectName());
		
		Object[] result = service.createNewProject(newproject);
		
		int x = (Integer)result[0];
		String message = (String)result[1];
		
		System.out.println("inserted:"+x);
		System.out.println("message:"+message);
		
		/*  int x = 0;
	    x = service.createNewProject(newproject);
		*/
		
		if(x > 0) {
			mv.addObject("addFlag","true"); 
			mv.addObject("message",message); 
		}else {
			mv.addObject("addFlag","false");
			mv.addObject("message",message); 
		}
		
		
		
		return mv;
	}
	
	@GetMapping("addtask")
	public String AddTask(Model model) {
		
		List<ProjectMaster> projectlist = service.projectList();
		model.addAttribute("projectlist", projectlist);
		return "AddDailyTask";
		
	}
}
