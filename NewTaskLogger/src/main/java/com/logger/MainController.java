package com.logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.logger.entities.TaskDetailsMaster;
import com.logger.services.TaskService;


@Controller
public class MainController {
	
	@Autowired
	private TaskService taskservice;

	@RequestMapping("/home")
	public String home() {
		System.out.println("firing home page from controller class");
		return "home";
	}
	
	
	
	@PostMapping("createnewtask")	
	public ModelAndView addTask(@ModelAttribute TaskDetailsMaster newtask) {
	//public ModelAndView addTask(@RequestParam("fromDate") String fdate,@RequestParam("toDate") String tdate,@RequestParam("taskTitle") String title,
		//	@RequestParam("taskDescription") String taskDescription,@RequestParam("projectid") int projid,@RequestParam("piid") int piid,@RequestParam("fromtime") String ftime,@RequestParam("totime") String ttime) {
		
		ModelAndView mav = new ModelAndView();
		
	//	TaskDetailsMaster newtask = new TaskDetailsMaster(fdate,tdate,title,taskDescription,projid, piid,ftime,ttime,new java.sql.Timestamp(new java.util.Date().getTime()));
		
		System.out.println("From Date:"+newtask.getFromDate());
		System.out.println("To Date:"+newtask.getToDate());
		System.out.println("taskDate:"+newtask.getTaskDate());
		
		newtask.setEntrydatetime(new java.sql.Timestamp(new java.util.Date().getTime()));
		
		String submitFromDateTime="",submitToDateTime="" , newtaskDate="";
		int addtask  = 0;String message = "";
		
		try {
			 submitFromDateTime = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MMM-yyyy").parse(newtask.getFromDate()));
			 submitToDateTime = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MMM-yyyy").parse(newtask.getToDate()));
			 newtaskDate = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MMM-yyyy").parse(newtask.getTaskDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		submitFromDateTime = submitFromDateTime+" 00:09:00";
		submitToDateTime = submitToDateTime+" 23:30:00";
		
		newtask.setFromDate(submitFromDateTime);
		newtask.setToDate(submitToDateTime);
		newtask.setTaskDate(newtaskDate);
		
		//System.out.println("From Date:"+submitFromDateTime);
		//System.out.println("To Date:"+submitToDateTime);
		
		System.out.println("PI:"+newtask.getPiid());
		System.out.println("ProjectID:"+newtask.getProjectid());
		System.out.println("Task:"+newtask.getTaskTitle());
		System.out.println("Task Desc:"+newtask.getTaskDescription());
	
		System.out.println("Task Time From:"+newtask.getFromtime());
		System.out.println("Task Time To:"+newtask.getTotime());
		
		addtask  = taskservice.addtask(newtask);
		
		
		if(addtask>0) {
			message = "Task Added Successfully";
		}else {
			message = "Error in Task Addition";
		}
		
		System.out.println("added:"+addtask);
		System.out.println("message:"+message);
		
		mav.setViewName("redirect:/addtask");
		mav.addObject("message", message);
		
		return mav;
	}
	
	@GetMapping("taskreport")
	public ModelAndView TaskDetailsReport(@RequestParam(name="fromDate",required=false) String fromdate,
			                              @RequestParam(name="toDate",required=false) String todate,
			                              @RequestParam(name="projectid",required=false) String projid,
			                              @RequestParam(name="piid",required=false) String piid,
			                              @RequestParam(name="submit",required=false) String submit) 
	{
		
		ModelAndView mav = new ModelAndView();
		String fdate="";
		String tdate="";
		List<TaskDetailsMaster> tasks = null;
		
		if(submit==null) {
			//onload
			fdate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			tdate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
			
			mav.addObject("fromDate", new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date()));
			mav.addObject("fromDate", new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date()));
			mav.addObject("toDate", new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date()));mav.addObject("toDate", new SimpleDateFormat("dd-MMM-yyyy").format(new java.util.Date()));
			
            //show all tasks done today 
			tasks = taskservice.getAllTasksByTaskDate(fdate, tdate);
			
			
			
			
		}else {
			//onsubmit
			System.out.println("On Submit");
			
			mav.addObject("fromDate", fromdate);
			mav.addObject("toDate", todate);
			
			//date handling
			try {
				fdate = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MMM-yyyy").parse(fromdate));
				tdate = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("dd-MMM-yyyy").parse(todate));
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				fdate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
				tdate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
				
				
			}
			
			if(piid!=null) {
				
				if(projid!=null) {
					//get tasks by projectid +piid
				   tasks =	taskservice.getTasksByAllParams(fdate, tdate, piid, projid);
				}else {
					//get tasks only by  piid
				tasks =	taskservice.getTasksByDateAndPerson(fdate, tdate, piid);
				}
			}else if((piid==null) && (projid!=null)) {
					//get tasks only by projectid
				tasks = taskservice.getAllTasksByDateAndProject(fdate, tdate, projid);
			
			}else {
				tasks = taskservice.getAllTasksByTaskDate(fdate, tdate);
			}
			
			
		}
		
		mav.addObject("tasklist",tasks);
        mav.setViewName("DailyTaskReport");
		
        return mav;
	}
	
	
}
