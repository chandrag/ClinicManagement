<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Visit</title>
<%@include file="Include.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/AddVisit.js"></script>
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
							<h2 class="form-signin-heading">Add Visit</h2>
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
											name="patient.id"></td>
										<th>Visit Date</th>
										<td><input id="visitDate" disabled="disabled"
											class="form-control" type="text"></td>
									</tr>
									<tr>
										<th>Symptoms</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Disease Symptoms" class="form-control"
												name="symptoms"></textarea></td>
										<th class="required-field">Problems</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Patient Problems" class="form-control"
												name="problems"></textarea></td>
									</tr>
									<tr>
										<th>Allergies</th>
										<td><textarea rows="3" cols="20"
												placeholder="Enter Patient Allergies" class="form-control"
												name="allergies"></textarea></td>
										<th>Test Results</th>
										<td><textarea rows="3" cols="20"
												placeholder="Save Test Results" class="form-control"
												name="testResults"></textarea></td>
									</tr>
									<tr>
										<td class="jumbotron" colspan="4">
											<table id="presc-tab">
												<tr>
													<th class="required-field" colspan="4">Prescription
														Details</th>
												</tr>
												<tr>
													<td>
														<input type="hidden" name="prescriptions[0].medicine.name" value=""/>
													</td>
													<td><input placeholder="Medicine" class="form-control"
														name="prescriptions[0].medicine.name"></td>
													<td><input placeholder="Frequency"
														class="form-control" name="prescriptions[0].frequency"></td>
													<td><input placeholder="Quantity" class="form-control"
														name="prescriptions[0].medQuantity"></td>
													<td><input placeholder="Frequency Type" class="form-control"
														name="prescriptions[0].freqType"></td>
													<td style="width: 60px;">
														<div onclick="fnAdd()" class="add-presc-btn glyphicon glyphicon-plus add-prescription"></div>
													</td>
												</tr>
											</table>
										</td>
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