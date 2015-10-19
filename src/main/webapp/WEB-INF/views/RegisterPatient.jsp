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
		<form action="save" method="post">
			<input type="hidden" name="id" value="${patient.id}"/>
			<div align="center">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" value="${patient.mrdNo}" name="mrdNo" placeholder="MRD No" />
							</div>
						</div>
						<br/>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<input class="form-control input-group-lg" value="${patient.name}" name="name" placeholder="Name" />
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<input max="200" maxlength="3" value="${patient.age}" class="form-control input-group-lg" name="age" placeholder="Age" />
							</div>
							<div class="col-md-4">
								<select name="sex" class="form-control input-group-lg" value="${patient.sex}">
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
								<textarea class="form-control input-group-lg" name="address" placeholder="Address" cols="" rows="3">${patient.address}</textarea>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" value="${patient.contactNo}" name="contactNo" placeholder="Contact No"/>
							</div>
							<div class="col-md-4">
								<select name="referredBy" class="form-control input-group-lg" value="${patient.referredBy}">
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
								<input class="form-control input-group-lg" value="${patient.fees}" name="fees" placeholder="Fees"/>
							</div>
							<div class="col-md-4">
								<input class="form-control input-group-lg" value="${patient.procedureFees}" name="procedureFees" placeholder="Procedure Fees"/>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<textarea class="form-control input-group-lg" name="diseaseHistory" placeholder="Disease History" cols="" rows="3">${patient.diseaseHistory}</textarea>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<textarea class="form-control input-group-lg" name="allergies" placeholder="Allergies" cols="" rows="3">${patient.allergies}</textarea>
							</div>
						</div>
						<br />
						<div class="row">
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<button class="btn btn-md btn-primary btn-block" type="submit">SAVE</button>
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