<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Medicine</title>
<%@include file="Include.jsp"%>
<script type="text/javascript">

function fnDelete(id){
	$('#mediFrm').attr('action','delete');
	$('#medId').val(id);
	$('#mediFrm').submit();
}

</script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">

		<form id="mediFrm" role="form" class="patient-form" action="search" method="post">
			<input id="medId" type="hidden" name="mi"/>
			<table class="table-condensed" width="100%">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2 class="form-signin-heading">Search Medicine</h2>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td valign="top">
							<table class="patient-details" width="100%">
								<tbody>
									<tr>
										<th class="required-field">Name</th>
										<td><input placeholder="Enter a medicine name" class="form-control"
											name="txt"></td>
										<td>
											<button id="addBtn" type="submit"
												class="btn btn-lg btn-primary btn-block">Search</button>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<c:if test="${fn:length(Medicines)>0}">
		<div class="panel panel-default">
		  <div class="panel-heading">Searched Medicines</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Manufacturer</th>
					<th>Type</th>
					<th>Unit</th>
					<th>Action</th>
				</tr>
			</thead>
		<c:forEach items="${Medicines}" var="medi">
			<tr>
				<td>${medi.name}</td>
				<td>${medi.manufacturer}</td>
				<td>${medi.type}</td>
				<td>${medi.unit}</td>
				<td><a href="#" onclick="fnDelete('${medi.id}')" class="delete-icon glyphicon glyphicon-remove">Delete</a></td>
			</tr>			
		</c:forEach>
		</table>
		</div>
		</c:if>
		<c:if test="${Message != null}">
			<c:choose>
				<c:when test="${SUCCESS == true}">
					<div role="alert" class="alert alert-success"
						style="text-align: center;">
						<strong id="message">${Message}</strong>
					</div>
				</c:when>
				<c:otherwise>
					<div role="alert" class="alert alert-danger"
						style="text-align: center;">
						<strong id="message">${Message}</strong>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>

</body>
</html>