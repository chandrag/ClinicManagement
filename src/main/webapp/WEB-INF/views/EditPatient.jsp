<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Patient</title>
<%@include file="Include.jsp"%>
<script type="text/javascript">
	function fnShowPopUp() {
		document.getElementById('profPic').click();
	}
</script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">

		<form:form role="form" class="patient-form" action="savechanges"
			method="post" enctype="multipart/form-data"
			modelAttribute="PatientTo">
			<form:hidden path="id" />
			<table width="100%" class="table-condensed">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2 class="form-signin-heading">Edit Patient Details</h2>
							<hr>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td valign="top">
							<div class="row">
								<div id="prof-pic" class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<img
											src="fetchprofilepic?q=${PatientTo.id}"
											width="200"
											alt="No Image Uploaded">
										<div class="caption" align="center">
											<h3>${PatientTo.firstName}&nbsp;${PatientTo.lastName}</h3>
											<p>
												<a href="#" onclick="fnShowPopUp()" class="btn btn-default"
													role="button">Image Upload</a>
												<input id="profPic" type="file" name="profilePic"/>
											</p>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td valign="top">
							<table width="100%" class="patient-details">
								<tbody>
									<tr>
										<th>First Name</th>
										<td><form:input placeholder="First Name"
												class="form-control" path="firstName"></form:input></td>
										<th>Middle Name</th>
										<td><form:input autofocus="" required=""
												placeholder="Middle Name" class="form-control"
												path="middleName"></form:input></td>
									</tr>
									<tr>
										<th>Last Name</th>
										<td><form:input autofocus="" required=""
												placeholder="Last Name" class="form-control" path="lastName"></form:input></td>
									</tr>
									<tr>
										<th>Mobile No</th>
										<td><form:input autofocus="" required=""
												placeholder="Mobile No" class="form-control"
												path="contact.mobileNo"></form:input></td>
										<th>Email</th>
										<td><form:input type="email" autofocus="" required=""
												placeholder="Email" class="form-control"
												path="contact.personalEmail"></form:input></td>
									</tr>
									<tr>
										<th>AddrLine1</th>
										<td><form:input autofocus="" required=""
												placeholder="AddrLine1" class="form-control"
												path="contact.address.addrLine1"></form:input></td>
										<th>AddrLine2</th>
										<td><form:input autofocus="" required=""
												placeholder="AddrLine2" class="form-control"
												path="contact.address.addrLine2"></form:input></td>
									</tr>
									<tr>
										<th>City</th>
										<td><form:input autofocus="" required=""
												placeholder="City" class="form-control"
												path="contact.address.city"></form:input></td>
										<th>State</th>
										<td><form:input autofocus="" required=""
												placeholder="State" class="form-control"
												path="contact.address.state"></form:input></td>

									</tr>
									<tr>
										<th>Zipcode</th>
										<td><form:input autofocus="" required=""
												placeholder="Zipcode" class="form-control"
												path="contact.address.pinCode"></form:input></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" align="center">
							<button id="saveChangesBtn" type="submit" class="btn btn-lg btn-primary btn-block">Save
								Changes</button>
						</td>
					</tr>
				</tfoot>
			</table>

		</form:form>
		<c:if test="${Message != null}">
			<div role="alert" class="alert alert-success"
				style="text-align: center;">
				<strong id="message">${Message}</strong>
			</div>
		</c:if>
	</div>
</body>
</html>