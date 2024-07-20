package com.logger.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TaskDetailsMaster {

	@Id
	@GeneratedValue
	int taskid;
	String fromDate;
	String toDate;
	String taskTitle;
	String taskDescription;
	int projectid;
	int piid;
	String taskDate;
	String fromtime;
	String totime;
	String assignTo;
	Timestamp entrydatetime;
	
	
	public TaskDetailsMaster(String fromDate, String toDate, String taskTitle, String taskDescription,
			int projectid, int piid,String taskDate ,String fromtime, String totime,String assignTo ,Timestamp entrydatetime) {
		super();
		
		
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.projectid = projectid;
		this.piid = piid;
		this.taskDate = taskDate;
		this.fromtime = fromtime;
		this.totime = totime;
		this.assignTo = assignTo;
		this.entrydatetime = entrydatetime;
	}

	

	public String getAssignTo() {
		return assignTo;
	}



	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}



	public int getTaskid() {
		return taskid;
	}


	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	public String getTaskTitle() {
		return taskTitle;
	}


	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}


	public String getTaskDescription() {
		return taskDescription;
	}


	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public int getProjectid() {
		return projectid;
	}


	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}


	public int getPiid() {
		return piid;
	}


	public void setPiid(int piid) {
		this.piid = piid;
	}


	public String getFromtime() {
		return fromtime;
	}


	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}


	public String getTotime() {
		return totime;
	}


	public void setTotime(String totime) {
		this.totime = totime;
	}


	public Timestamp getEntrydatetime() {
		return entrydatetime;
	}


	public void setEntrydatetime(Timestamp entrydatetime) {
		this.entrydatetime = entrydatetime;
	}


	public TaskDetailsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getTaskDate() {
		return taskDate;
	}


	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}


	@Override
	public String toString() {
		return "TaskDetailsMaster [taskid=" + taskid + ", fromDate=" + fromDate + ", toDate=" + toDate + ", taskTitle="
				+ taskTitle + ", taskDescription=" + taskDescription + ", projectid=" + projectid + ", piid=" + piid
				+ ", taskDate=" + taskDate + ", fromtime=" + fromtime + ", totime=" + totime + ", entrydatetime="
				+ entrydatetime + "]";
	}


	
	
	
	
}
