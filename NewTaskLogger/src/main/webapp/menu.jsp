<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="css/navbar-top-fixed.css" rel="stylesheet">
</head>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
    </style> 


<body>
<%
try{
String uname = session.getAttribute("username").toString();
}catch(NullPointerException e){
	response.sendRedirect("login.jsp?message=session timed out");
}
%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <div class="container-fluid">
    <!-- <a class="navbar-brand" href="#">TW</a> -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav me-auto mb-2 mb-md-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home">Home</a>
        </li>
        <!-- <li class="nav-item">
          <a class="nav-link" href="create">Create Request</a>
        </li> -->
					<!-- <li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-bs-toggle="dropdown" aria-expanded="false">Data Entry</a>
						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item" href="addproject">Add New Project</a></li>
						</ul>
					</li> -->


					<li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">Reports</a>
           <ul class="dropdown-menu" aria-labelledby="dropdown01">
              <li><a class="dropdown-item" href="taskreport">Daily Task Report</a></li>
            </ul> 
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-expanded="false">Entry Form</a>
           <ul class="dropdown-menu" aria-labelledby="dropdown01">
              <li><a class="dropdown-item" href="addtask">Add Daily Task</a></li>
              <li><a class="dropdown-item" href="AddProject.jsp">Add New Project</a></li>
              <li><a class="dropdown-item" href="UserRegistration.jsp">Add New User</a></li>
            </ul> 
          </li>
         
        
          
        
        
        
      </ul>
    
    </div>
  </div>
   <a class="navbar-brand" href="#">Task Logger - <%=session.getAttribute("fname")%> <%=session.getAttribute("lname") %></a>
</nav>


<!-- <main class="container">
  <div class="bg-light p-5 rounded">
    <h1>Navbar example</h1>
    <p class="lead">This example is a quick exercise to illustrate how fixed to top navbar works. As you scroll, it will remain fixed to the top of your browser’s viewport.</p>
    <a class="btn btn-lg btn-primary" href="../components/navbar/" role="button">View navbar docs &raquo;</a>
  </div>
</main> -->
<br><br>
</body>
</html>