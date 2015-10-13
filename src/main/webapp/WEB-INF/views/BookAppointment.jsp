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
	<h3 class="text-info text-center">Book Appointment</h3>
	<div align="center">
		<form id="createAppointmentFrm" action="#" method="get">
		<div class="row">
			<div class="col-md-3"></div>	
			<div class="col-md-6">
				<div class="row">
					<div class="col-md-6">
						<input required="required" class="form-control input-group-lg" ng-model="appointment.firstName" placeholder="First Name"/>
					</div>
					<div class="col-md-6">
						<input required="required" class="form-control input-group-lg" ng-model="appointment.lastName" placeholder="Last Name"/>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-6">
						<input maxlength="10" required="required" type="tel" class="form-control input-group-lg" ng-model="appointment.mobileNo" placeholder="Mobile No"/>
					</div>
					<div class="col-md-6">
						<input type="email" class="form-control input-group-lg" ng-model="appointment.emailId" placeholder="EmailId"/>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<input required="required" type="date" class="form-control input-group-lg" ng-model="appointment.datedOn" placeholder="For Date"/>
					</div>
				</div>
				<br/>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<button ng-click="create(appointment)" class="btn btn-lg btn-primary btn-block" type="submit">CREATE</button>
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
</div>
</body>
</html>