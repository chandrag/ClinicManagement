<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Home</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br/><br/>
	<div class="jumbotron">

      <div class="starter-template">
        <h1>Appointment Home</h1>
        <p class="lead">
        	Here you can Create and Cancel appointment.
        </p>
      </div>
		
		<a id="addBtn" class="btn btn-lg btn-primary" type="button" href="appointment/add">Add</a>
		<a id="cancelBtn" class="btn btn-lg btn-primary" type="button" href="./searchpatient">Cancel</a>
		<a id="patientQueueBtn" class="btn btn-lg btn-primary" type="button" href="appointment/queue">Patient Queue</a>
		
    </div>
</body>
</html>