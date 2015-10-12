<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Header.jsp"%>
		<br>
		<div class="row">
			<div class="col-md-12" align="center">
				<h3>Create Patient</h3>
			</div>
		</div>
		<div align="center">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="row">
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="firstName"
								placeholder="First Name" />
						</div>
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="lastName"
								placeholder="Last Name" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="mobileNo"
								placeholder="Mobile No" />
						</div>
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="emailId"
								placeholder="EmailId" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-12">
							<input class="form-control input-group-lg" name="addrLine1"
								placeholder="Address Line 1" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-12">
							<input class="form-control input-group-lg" name="addrLine2"
								placeholder="Address Line 2" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="city"
								placeholder="City" />
						</div>
						<div class="col-md-6">
							<input class="form-control input-group-lg" name="state"
								placeholder="State" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-4">
							<input class="form-control input-group-lg" name="zipCode"
								placeholder="ZipCode" />
						</div>
					</div>
					<br />
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-4">
							<button ng-click="create()"
								class="btn btn-lg btn-primary btn-block" type="button">CREATE</button>
						</div>
						<div class="col-md-4">
							<button ng-click="update()"
								class="btn btn-lg btn-primary btn-block" type="button">UPDATE</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>