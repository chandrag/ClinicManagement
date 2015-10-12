<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Visit</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">

		<form role="form" class="patient-form" action="update"
			enctype="multipart/form-data" method="post">
			<input type="hidden" name="id" value="${visit.id}" />
			<table class="table-condensed" width="100%">
				<thead>
					<tr>
						<td colspan="2" align="center">
							<h2 class="form-signin-heading">Update Visit</h2>
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
							<table class="patient-visit-table" width="100%">
								<tbody>
									<tr>
										<th class="required-field">PatientId</th>
										<td><input placeholder="Patient Id" class="form-control"
											name="patient.id" value="${visit.patient.id}" /></td>
										<th>Visit Date</th>
										<td><input id="visitDate" class="form-control"
											name="visitDt" type="text" value="${visit.visitDt}" /></td>
									</tr>
									<tr>
										<th>Symptoms</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Disease Symptoms" class="form-control"
												name="symptoms">${visit.symptoms}</textarea></td>
										<th class="required-field">Problems</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Patient Problems" class="form-control"
												name="problems">${visit.problems}</textarea></td>
									</tr>
									<tr>
										<th>Allergies</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Patient Allergies" class="form-control"
												name="allergies">${visit.allergies}</textarea></td>
										<th class="required-field">Prescription</th>
										<td><textarea rows="3" cols="20"
												placeholder="Suggest Prescriptions" class="form-control"
												name="prescription">${visit.prescription}</textarea></td>
									</tr>
									<tr>
										<th>Test Results</th>
										<td><textarea rows="3" cols="20"
												placeholder="Save Test Results" class="form-control"
												name="testResults">${visit.testResults}</textarea></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button id="saveChangesBtn" type="submit" class="btn btn-lg btn-primary btn-block">Save
								Changes</button>
						</td>
					</tr>
				</tfoot>
			</table>

		</form>
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