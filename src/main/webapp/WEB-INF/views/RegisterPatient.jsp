<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register New</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<div class="container">
		<%@include file="Header.jsp"%>
		<br>
		<h3 class="text-info text-center">Register New</h3>
		<form action="create" method="post">
			<div align="center">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" name="mrdNo" placeholder="MRD No" />
							</div>
						</div>
						<br/>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<input class="form-control input-group-lg" name="name" placeholder="Name" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<input max="200" maxlength="3" class="form-control input-group-lg" name="age" placeholder="Age" />
							</div>
							<div class="col-md-4">
								<select name="sex" class="form-control input-group-lg">
									<option value="Sex">Sex</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<textarea class="form-control input-group-lg" name="address" placeholder="Address" cols="" rows="3"></textarea>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" name="contactNo" placeholder="Contact No"/>
							</div>
							<div class="col-md-4">
								<select name="referredBy" class="form-control input-group-lg">
									<option value="RefBy">RefBy</option>
									<option value="DoctorA">DoctorA</option>
									<option value="DoctorB">DoctorB</option>
								</select>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" name="fees" placeholder="Fees"/>
							</div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" name="procedureFees" placeholder="Procedure Fees"/>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<button ng-click="create()"
									class="btn btn-md btn-primary btn-block" type="submit">CREATE</button>
							</div>
							<div class="col-md-3">
								<button ng-click="update()"
									class="btn btn-md btn-primary btn-block" type="button">UPDATE</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<br/>
		<c:if test="${Message != null}">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div align="center" class="alert alert-success" role="alert">${Message}</div>
				</div>
			</div>
		</c:if>
	</div>

</body>
</html>