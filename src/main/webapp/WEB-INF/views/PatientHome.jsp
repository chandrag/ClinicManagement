<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Home</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br/><br/>
	<div class="jumbotron">

      <div class="starter-template">
        <h1>Patient Home</h1>
        <p class="lead">
        	Here you can Add, Update, Delete and Search Patient Details.
        </p>
      </div>
		
		<a id="addBtn" class="btn btn-lg btn-primary" type="button" href="./addpatient">Add</a>
		<a id="searchPatientBtn" class="btn btn-lg btn-success" type="button" href="./searchpatient">Search</a>
	
    </div>
</body>
</html>