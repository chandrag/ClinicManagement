<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Patient</title>
<%@include file="Include.jsp"%>
<script type="text/javascript" src="../resources/js/app/Patient.js"></script>
</head>
<body>
<div class="container">
	<%@include file="Header.jsp"%>
	<br>
	<h3 class="text-info text-center">Search Patient</h3>
	<form action="searchby">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<input name="searchTxt" class="form-control input-lg" placeholder="Enter name to search..."/>
			</div>
			<div class="col-md-4">
				<button class="btn btn-lg btn-primary" type="submit">Search</button>
			</div>
		</div>
	</form>
	<br/>
	<c:if test="${fn:length(patients) > 0}">
	<div class="row">
		<div class="col-md-12 panel panel-default">
			<form id="editPatientFrm" action="edit" method="post">
				<input id="pid" type="hidden" name="pid" value="-1"/>
				<table class="table">
					<thead>
						<tr>
							<th>MrdNo</th>
							<th>Name</th>
							<th>Contact</th>
							<th>ReferredBy</th>
							<th>Sex</th>
							<th>Address</th>
							<th>
								<div align="center">Actions</div>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${patients}" var="patient" varStatus="stat">
						<tr>
							<td scope="row">${patient.mrdNo}</td>
							<td>${patient.name}</td>
							<td>${patient.contactNo}</td>
							<td>${patient.referredBy}</td>
							<td>${patient.sex}</td>
							<td>${patient.address}</td>
							<td>
								<div align="center">
									<button type="button" title="${patient.id}" id="editBtn" class="btn-link">Edit</button>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	</c:if>
	<c:if test="${Message != null}">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div align="center" class="alert alert-info" role="alert">${Message}</div>
			</div>
		</div>
	</c:if>
</div>
</body>
</html>