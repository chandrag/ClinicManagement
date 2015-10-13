<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="Include.jsp"%>
</head>
<body>
<div class="container">
	<%@include file="Header.jsp"%>
	<br>
	<h3 class="text-info text-center">Search Patient</h3>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<input name="searchTxt" class="form-control input-lg" placeholder="Enter name to search..."/>
		</div>
	</div>
	<br/>
	<div class="row">
		<div class="col-md-12 panel panel-default">
			<table class="table">
				<thead>
					<tr>
						<th>Sr.No</th>
						<th>Name</th>
						<th>Contact</th>
						<th>City</th>
						<th>
							<div align="center">Actions</div>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">{{$index+1}}</td>
						<td>{{patient.firstName}} {{patient.lastName}}</td>
						<td>{{patient.mobileNo}}</td>
						<td>{{patient.city}}</td>
						<td>
							<div align="center">
								<button class="btn-link">Edit</button>
								<button class="btn-link">Visit</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>