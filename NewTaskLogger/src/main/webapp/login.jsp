<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Signin Template · Bootstrap v5.0</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

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
      
      body {
	background-image: url('images/loginbg.jpg');
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	backdrop-filter: blur(5px);
}
    </style>
<script>
 function validate(){
	 
	 username = document.getElementById("username").value;
	 password = document.getElementById("password").value;
	 
	if(username==""){
		alert("please enter username");
		return false;
	}
	
	if(password==""){
		alert("please enter password");
		return false;
	}
	
	return true 
} 

</script>
    
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin"> 
  <form action="loginaction" method="post" onsubmit="return validate()">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
<div class="form-floating">
      <input type="username" name="username" class="form-control" id="username" placeholder="Username">
      <label for="floatingInput">Username</label>
    </div>
    <div class="form-floating">
      <input type="password" name="password" class="form-control" id="password" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>
<button class="w-100 btn btn-lg btn-success"  type="submit" >Sign in</button>
</form>
</main>
<%

if(request.getAttribute("status")!=null){
	String loginstatus = request.getAttribute("status").toString();
	if(loginstatus.equals("failed")){
		%>
		<script>alert("Login Failed")</script>
		<%
	}
	
}

if(request.getParameter("message")!=null){
	
	String msg = request.getParameter("message").toString();

	out.println("<script>alert('"+msg+"')</script>");
	
}
    		  


%>

    
  </body>
</html>
