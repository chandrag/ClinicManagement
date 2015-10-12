<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Appointment</title>
<%@include file="Include.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/Appointment.js"></script>

</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">

		<form role="form" class="appointment-form" action="create"
			method="post">

			<table class="table-condensed" align="center">
				<thead>
					<tr>
						<td colspan="6" align="center">
							<h2 class="form-signin-heading">Create Appointment</h2>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Date</th>
						<td>
							<div class="input-append date" id="appntDate">
								<input name="date" placeholder="Appointment Date"
									class="datepicker form-control-appntDt span2" type="text">
								<span class="add-on"><i class="icon-th"></i></span>
							</div>
						</td>

					</tr>
					<tr>
						<th>Appointment Type</th>
						<td>
							<div class="dropdown">
								<input type="hidden" name="type.id" id="typeId"/>
								<button class="btn btn-default dropdown-toggle" type="button"
									id="appointmentTypeDD" data-toggle="dropdown">
									<span id="appointmentTypeDDVal">Select</span><span class="caret"></span>
								</button>
								<ul id="typesDD" class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">

								</ul>
							</div>
						</td>
					</tr>
					<tr>
						<th>Patient Id</th>
						<td><input autofocus="" required="" placeholder="Patient Id"
							class="form-control" name="patient.id"></td>
					</tr>
					<tr>
						<th valign="top">Details</th>
						<td>
							<textarea class="form-control" name="details" rows="3" cols="30"></textarea>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button id="addBtn" type="submit" class="btn btn-lg btn-primary btn-block">Create</button>
						</td>
					</tr>
				</tfoot>
			</table>

		</form>
		<c:if test="${Message != null}">
			<div role="alert" class="alert alert-success"
				style="text-align: center;">
				<strong>${Message}</strong>
			</div>
		</c:if>
	</div>

</body>
</html>