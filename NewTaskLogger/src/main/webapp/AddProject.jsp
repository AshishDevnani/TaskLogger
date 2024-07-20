<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">

<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Insert title here</title>
<script>
function validate(){
	ProjectName = document.getElementById("projectName").value;
	projectid = document.getElementById("projectid").value;
	
	if(ProjectName==""){
		alert("Project Name cannot be empty");
		return false;
	}
	
	
	
	if(projectid==""){
		alert("project Id cannot be empty");
		return false;
	}
	
	
	
	return true;
}
</script>
</head>
<body>
<div class="card">
	<h3 align="center">Add New Project</h3>
</div>
<%


String addFlag="";
String message ="";

if(request.getAttribute("addFlag")!=null){

addFlag = request.getAttribute("addFlag").toString();
message = request.getAttribute("message").toString();

out.println("<script>alert('"+message+"')</script>");
	
}

%>

                 <div class="card-body card">
                 <form action="addprojectaction" onsubmit="return validate()" method="post">
								<div class="row col-12">
										  <div class="col-6">
												<div class="md-2">
												<span style="color:red;">*</span>
													<label for=" First Name:-" class="tcolor"><b>Project Name</b></label><br>
													<div class="input-container">
														<input class="form-control" type="text"
															placeholder=" Enter Project Name" name="projectName" id="projectName" >
													</div>
												</div>
											</div>
											
										
										
										  <div class="col-6">
												<div class="md-2">
												<span style="color:red;">*</span>
													<label for=" First Name:-" class="tcolor"><b>ProjectId</b></label><br>
													<div class="input-container">
														<input class="form-control" type="text"
															placeholder="Enter Project Id" name="projectid" id="projectid" >
													</div>
												</div>
											</div>
										</div>	
										
										 <div class="d-grid gap-2 col-4 mx-auto mt-2">
												<button class="btn btn-primary btn2" type="submit">Submit Form</button>
											</div>
                                   
                                   </form>
                                   </div>
                                   
     

</body>
</html>