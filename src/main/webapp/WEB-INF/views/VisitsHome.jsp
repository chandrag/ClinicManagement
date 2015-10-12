<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visits Home</title>
<%@include file="Include.jsp"%>
</head>
<body>
<%@include file="Header.jsp"%>
	<br/><br/>
	<div class="jumbotron">

      <div class="starter-template">
        <h1>Visits Home</h1>
        <p class="lead">
        	Here you can Add, Update and Search Patient Visits Details.
        </p>
      </div>
		<a class="btn btn-lg btn-primary" type="button" href="./visitshome/createvisit">Add</a>
		<a class="btn btn-lg btn-primary" type="button" href="./visitshome/search">Search</a>
    </div>
</body>
</html>