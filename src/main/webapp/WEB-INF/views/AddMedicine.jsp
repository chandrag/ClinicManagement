<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Medicine</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">

		<form role="form" class="patient-form" action="add" method="post">

			<table class="table-condensed" width="100%">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2 class="form-signin-heading">Add Medicine</h2>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="left"><span
							class="mandatory-field-msg">Fields with asterisk (*) are
								mandatory</span></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td valign="top">
							<table class="patient-details" width="100%">
								<tbody>
									<tr>
										<th class="required-field">Name</th>
										<td><input placeholder="Name" class="form-control"
											name="name"></td>
										<th class="required-field">Manufacturer</th>
										<td><input placeholder="Manufacturer"
											class="form-control" name="manufacturer"></td>
									</tr>
									<tr>
										<th class="required-field">Type</th>
										<td><select class="form-control" name="type"
											placeholder="Type">
												<option value="NONE">Select</option>
												<option value="CAPSULE">Capsule</option>
												<option value="TABLET">Tablet</option>
												<option value="TONIC">Tonic</option>
										</select></td>
										<th class="required-field">Unit</th>
										<td><input placeholder="Unit" class="form-control"
											name="unit"></td>
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