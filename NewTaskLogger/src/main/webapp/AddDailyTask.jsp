<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*"
    		import="java.util.List"
            import="com.logger.entities.ProjectMaster" %>
    <%@include file="menu.jsp" %>
    
    
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Registration  Template · Bootstrap v5.0</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
     
      
     /*  body {
	background-image: url('images/registerbg.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	backdrop-filter: blur(5px);
} */
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
    
   
  </head>
  <body class="text-center">
  <%
   if(request.getParameter("message")!=null){
	  
	  String message = request.getParameter("message").toString();
	  System.out.println("message sent by controller:::::::"+message);
	  
	  out.println("<script>alert('"+message+"')</script>");
	  
  } 
  
  
  %>  
<main class="form-signin">

<div class="card mt-6">
  
  <form action="createnewtask" method="post">
    <!-- <img class="mb-4" src="assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
    <h1 class="h3 fw-normal my-auto mx-auto">Add Daily Task Form</h1>
    
   
    <div class="form-floating"	>
      <input type="text" name="fromDate" class="form-control" id="fromDate">
      <label for="floatingInput">Submission From Date</label>
					<script>
						$(document).ready(function() {
							$(function() {
								$("#fromDate").datepicker({
									dateFormat : 'dd-M-yy',
									changeMonth : true,
									changeYear : true
								});
							});

						});
					</script>
				</div>
    <div class="form-floating">
      <input type="text" name="toDate" class="form-control" id="toDate">
      <label for="floatingInput">Submission To Date</label>
					<script>
						$(document).ready(function() {
							$(function() {
								$("#toDate").datepicker({
									dateFormat : 'dd-M-yy',
									changeMonth : true,
									changeYear : true
								});
							});

						});
					</script>
				</div>
    
    <div class="form-floating">
      <input type="text" name="taskTitle" class="form-control" id="taskTitle">
      <label for="floatingInput">Task Title</label>
    </div>
    
    <div class="form-floating">
      <textarea name="taskDescription" class="form-control" id="taskFescription"></textarea>
      <label for="floatingInput">Task Description</label>
    </div>
    
    <div class="form-floating">
      <input type="text" name="piid" id="piid" class="form-control" value="<%=session.getAttribute("piid")%>" readonly>
      <label for="floatingInput">PI-ID</label>
    </div>
    
    
    
     <div class="form-floating">
       <select  name="projectid" id="projectid"  class="form-select"> 
       <%
         List<ProjectMaster> projects = (List<ProjectMaster>)request.getAttribute("projectlist");
       	 
    	 for(ProjectMaster project : projects){
    		 %>
    		 <option value="<%=project.getProjectid()%>"><%=project.getProjectName()%>(<%=project.getProjectid()%>)</option>
    		 <%
    	 }
       %>
       </select>      
       <label for="floatingInput">Project ID</label>
    </div>
    
    <div class="form-floating">
      <input type="text" name="taskDate" class="form-control" id="taskDate">
      <label for="floatingInput">Task Date</label>
					<script>
						$(document).ready(function() {
							$(function() {
								$("#taskDate").datepicker({
									dateFormat : 'dd-M-yy',
									changeMonth : true,
									changeYear : true
								});
							});

						});
					</script>
				</div>
    
     <div class="form-floating">
      <input type="time" name="fromtime" class="form-control" id="fromtime">
      <label for="floatingInput">Task From Time</label>
    </div>
    <div class="form-floating">
      <input type="time" name="totime" class="form-control" id="totime">
      <label for="floatingInput">Task To Time</label>
    </div>
    
    
    <input type="hidden" name="assignTo" id="assignTo" value="<%=session.getAttribute("fname")%> <%=session.getAttribute("lname")%>">
   
    <button class="w-100 btn btn-lg btn-primary" type="submit">Add Task</button>
  
    <p class="mt-5 mb-3 text-muted">&copy; 2017–2023</p>
  </form>
  </div>
</main>


    
  </body>
</html>

