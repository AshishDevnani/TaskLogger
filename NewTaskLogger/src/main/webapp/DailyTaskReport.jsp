<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="menu.jsp" %>
     <%@page import="java.util.List"
     import="java.util.Date" 
     import="java.text.SimpleDateFormat"
     import="com.logger.entities.TaskDetailsMaster"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<style>
table, th, td {
  border: 1px solid;
}
table{
width:100%;
}
</style>
</head>
<script>
function validate(){
	
	var chkf="";
 	var chkt="";
 	var objFromDate = document.getElementById("fromDate").value;
 	
 	
 	var fdate=objFromDate.split("-");
 	if(fdate[1]=="Jan")
 	{
 		chkf="01";
 	}
 	if(fdate[1]=="Feb")
 	{
 		chkf="02";
 	}
 	if(fdate[1]=="Mar")
 	{
 		chkf="03";
 	}
 	if(fdate[1]=="Apr")
 	{
 		chkf="04";
 	}
 	if(fdate[1]=="May")
 	{
 		chkf="05";
 	}
 	if(fdate[1]=="Jun")
 	{
 		chkf="06";
 	}
 	if(fdate[1]=="Jul")
 	{
 		chkf="07";
 	}
 	if(fdate[1]=="Aug")
 	{
 		chkf="08";
 	}
 	if(fdate[1]=="Sep")
 	{
 		chkf="09";
 	}
 	if(fdate[1]=="Oct")
 	{
 		chkf="10";
 	}
 	if(fdate[1]=="Nov")
 	{
 		chkf="11";
 	}
 	if(fdate[1]=="Dec")
 	{
 		chkf="12";
 	}
 	var objFromDate1=""+fdate[2]+"-"+chkf+"-"+fdate[0]+"";
     var objToDate = document.getElementById("toDate").value;
     var tdate=objToDate.split("-");
     if(tdate[1]=="Jan")
 	{
     	chkt="01";
 	}
 	if(tdate[1]=="Feb")
 	{
 		chkt="02";
 	}
 	if(tdate[1]=="Mar")
 	{
 		chkt="03";
 	}
 	if(tdate[1]=="Apr")
 	{
 		chkt="04";
 	}
 	if(tdate[1]=="May")
 	{
 		chkt="05";
 	}
 	if(tdate[1]=="Jun")
 	{
 		chkt="06";
 	}
 	if(tdate[1]=="Jul")
 	{
 		chkt="07";
 	}
 	if(tdate[1]=="Aug")
 	{
 		chkt="08";
 	}
 	if(tdate[1]=="Sep")
 	{
 		chkt="09";
 	}
 	if(tdate[1]=="Oct")
 	{
 		chkt="10";
 	}
 	if(tdate[1]=="Nov")
 	{
 		chkt="11";
 	}
 	if(tdate[1]=="Dec")
 	{
 		chkt="12";
 	}
     var objToDate1=""+tdate[2]+"-"+chkt+"-"+tdate[0]+"";
    // alert("Entry from date > "+objFromDate1+" Todate > "+objToDate1);
      
     var date1 = new Date(objFromDate1);
     var date2 = new Date(objToDate1);
     
     //alert("from > "+date1+" Todate > "+date2);
     
     var date3 = new Date();
     var date4 = date3.getMonth() + "-" + date3.getDay() + "-" + date3.getYear();
     var currentDate = new Date(date4);
      
         if(date1 > date2)
         {
             alert("From Date Should be Less Than To Date");
             return false; 
         }
         return true;
}
</script>
<body>

<%
String datex1 = request.getAttribute("fromDate").toString();
String datex2 = request.getAttribute("toDate").toString();
%>

<form action="taskreport" method="get" onsubmit="return validate()">
<div class="row col-12 mt-2" style="align:center">
<div class="col-md-2"></div>
<div class="col-md-2">
 <label>From Date</label>
 <input type="text" class="form-control" id="fromDate" name="fromDate" value="<%=datex1%>">
 <script>

						$(document).ready(function() {
							$( function() {
   				 $( "#fromDate" ).datepicker({
		    dateFormat: 'dd-M-yy',
			changeMonth: true,
            changeYear: true
	});
  } );
				
});

				   </script>
</div>
<div class="col-md-2">
 <label>To Date</label>
 <input type="text" class="form-control" id="toDate" name="toDate" value="<%=datex2%>">
 <script>

						$(document).ready(function() {
							$( function() {
   				 $( "#toDate" ).datepicker({
		    dateFormat: 'dd-M-yy',
			changeMonth: true,
            changeYear: true
	});
  } );
				
});

				   </script>
</div>


<div class="col-md-1">
 <input type="submit" class="btn btn-primary" style="margin-top: 20px;" name="submit" value="submit">
</div>
</div>
</form>
<br><br>
<table>
<thead>
<tr>
<th>FromDateTime</th>
<th>ToDateTime</th>
<th>UserID</th>
<th>Duration</th>
<th>Project ID</th>
<th>Task</th>
<th>Task Description</th>
<th>Assign To</th>
</tr>
</thead>
<tbody>
<% 
if(request.getAttribute("tasklist")!=null){
double duration = 0d;
Date from = null,to = null;
long diff = 0;

String submitfrom = "", submitto="",assignTo="";

List<TaskDetailsMaster> tasklist = (List<TaskDetailsMaster>)request.getAttribute("tasklist");

for(TaskDetailsMaster task : tasklist){
	
	//System.out.println("task from time: "+task.getTaskDate()+" "+task.getFromtime());
	//System.out.println("task from time: "+task.getTaskDate()+" "+task.getTotime());
	
	 from = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(task.getTaskDate()+" "+task.getFromtime());
	 to = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(task.getTaskDate()+" "+task.getTotime());
	
	diff = to.getTime() - from.getTime();
	duration =  diff/3600000;
	
	submitfrom = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(task.getFromDate()));
	submitto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(task.getToDate()));
	
	assignTo = task.getAssignTo();
	
	if(assignTo==null ||assignTo.equals("")){
		assignTo="-";
	}
	
	%>
	<tr>
	<td><%=submitfrom%></td>
	<td><%=submitto%></td>
	<td><%=task.getPiid()%></td>
	<td><%=duration%></td>
	<td><%=task.getProjectid()%></td>
	<td><%=task.getTaskTitle()%></td>
	<td><%=task.getTaskDescription()%></td>
	<td><%=assignTo%></td>
	</tr>
	<%
}

}
%>


</tbody>
<tfoot>
<tr>
<th>FromDateTime</th>
<th>ToDateTime</th>
<th>UserID</th>
<th>Duration</th>
<th>Project ID</th>
<th>Task</th>
<th>Task Description</th>
<th>Assign To</th>
</tr>
</tfoot>
</table>
</body>
</html>