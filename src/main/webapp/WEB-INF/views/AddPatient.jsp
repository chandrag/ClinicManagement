<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
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

		<form role="form" class="patient-form" action="create"
			enctype="multipart/form-data" method="post">

			<table class="table-condensed" width="100%">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2 class="form-signin-heading">Add Patient</h2>
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
											src="${pageContext.request.contextPath}/resources/images/edit_profile.png"
											width="200" alt="No Image Uploaded">
										<div class="caption" align="center">
											<p>
												<a href="#" onclick="fnShowPopUp()" class="btn btn-default"
													role="button">Image Upload</a> <input id="profPic"
													type="file" name="profilePic" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td valign="top">
							<table class="patient-details" width="100%">
								<tbody>
									<tr>
										<th>First Name</th>
										<td><input autofocus="" required=""
											placeholder="First Name" class="form-control"
											name="firstName"></td>
										<th>Middle Name</th>
										<td><input autofocus="" required=""
											placeholder="Middle Name" class="form-control"
											name="middleName"></td>
									</tr>
									<tr>
										<th>Last Name</th>
										<td><input autofocus="" required=""
											placeholder="Last Name" class="form-control" name="lastName"></td>
									</tr>
									<tr>
										<th>Mobile No</th>
										<td><input autofocus="" required=""
											placeholder="Mobile No" class="form-control"
											name="contact.mobileNo"></td>
										<th>Email</th>
										<td><input type="email" autofocus="" required=""
											placeholder="Email" class="form-control"
											name="contact.personalEmail"></td>
									</tr>
									<tr>
										<th>AddrLine1</th>
										<td><input autofocus="" required=""
											placeholder="AddrLine1" class="form-control"
											name="contact.address.addrLine1"></td>
										<th>AddrLine2</th>
										<td><input autofocus="" required=""
											placeholder="AddrLine2" class="form-control"
											name="contact.address.addrLine2"></td>
									</tr>
									<tr>
										<th>City</th>
										<td><input autofocus="" required="" placeholder="City"
											class="form-control" name="contact.address.city"></td>
										<th>State</th>
										<td><input autofocus="" required="" placeholder="State"
											class="form-control" name="contact.address.state"></td>
									</tr>
									<tr>
										<th>Zipcode</th>
										<td><input autofocus="" required="" placeholder="Zipcode"
											class="form-control" name="contact.address.pinCode"></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button id="addBtn" type="submit"
								class="btn btn-lg btn-primary btn-block">Add</button>
						</td>
					</tr>
				</tfoot>
			</table>

		</form>
		<c:if test="${Message != null}">
			<div role="alert" class="alert alert-success"
				style="text-align: center;">
				<strong id="message">${Message}</strong>
			</div>
		</c:if>
	</div>

</body>
</html>