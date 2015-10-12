<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Visit</title>
<%@include file="Include.jsp"%>

</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container content-pane">
		<div align="center">
			<h2 class="form-signin-heading">Search Visit</h2>
		</div>
		<form role="form" class="patient-form" action="fetch" method="post">

			<table class="table-condensed">
				<tbody>
					<tr>
						<th>PatientId</th>
						<td><input id="searchCrit" placeholder="Enter a value"
							class="form-control" name="patientId"></td>
						<td>
							<button id="searchBtn" type="submit"
								class="btn btn-lg btn-success">Search</button>
						</td>
					</tr>
				</tbody>
			</table>

		</form>

		<c:if test="${fn:length(Visits)>0}">
			<h3>Patient Visits</h3>
			<c:forEach items="${Visits}" var="visit">
				<div class="jumbotron">
					<div class="patient-action-buttons">
						<form id="patientActions" action="editpatient" method="post">
							<input type="hidden" name="patientId" value="${PatientTo.id}" />
							<a id="updateVisitBtn" class="btn btn-xs btn-primary"
								href="${pageContext.request.contextPath}/visitshome/generateslip?vid=${visit.id}">Generate Slip</a>
							<a id="updateVisitBtn" class="btn btn-xs btn-info"
								href="${pageContext.request.contextPath}/visitshome/updatevisit?vi=${visit.id}">Update</a>
						</form>
					</div>
					<table width="100%" class="table-condensed">
						<tbody>

							<tr>
								<th>Patient Id</th>
								<th>Visit Date</th>
							</tr>
							<tr>
								<td>${visit.patient.id}</td>
								<td>${visit.visitDt}</td>
							</tr>
							<tr>
								<th>Problems</th>
								<th>Symptoms</th>
							</tr>
							<tr>
								<td>${visit.problems}</td>
								<td><c:if test="${visit.symptoms != ''}">
										${visit.symptoms}
									</c:if> <c:if test="${visit.symptoms == ''}">
										NA
									</c:if></td>
							</tr>
							<tr>
								<th>Allergies</th>
								<th>Test Results</th>
							</tr>
							<tr>
								<td><c:if test="${visit.allergies != ''}">
										${visit.allergies}
									</c:if> <c:if test="${visit.allergies == ''}">
										NA
									</c:if></td>
								<td><c:if test="${visit.testResults != ''}">
										${visit.testResults}
									</c:if> <c:if test="${visit.testResults == ''}">
										NA
									</c:if></td>
							</tr>
							<tr>
								<th>Prescriptions</th>
							</tr>
							<c:choose>
								<c:when test="${fn:length(visit.prescriptions)>0}">
									<tr>
										<td>
											<div class="Table">
												<div class="Row">
													<div class="CellBordered">
														<label>Sr.No</label>
													</div>
													<div class="CellBordered">
														<label>Medicine</label>
													</div>
													<div class="CellBordered">
														<label>Frequency</label>
													</div>
													<div class="CellBordered">
														<label>Quantity</label>
													</div>
													<div class="CellBordered">
														<label>Frequency Type</label>
													</div>
													<div class="CellBordered">
														<label>Actions</label>
													</div>
												</div>
												<c:forEach items="${visit.prescriptions}" var="presc" varStatus="stat">
													<div class="Row">
														<div class="CellBordered">${stat.count}</div>
														<div class="CellBordered">${presc.medicine.name}</div>
														<div class="CellBordered">${presc.frequency}</div>
														<div class="CellBordered">${presc.medQuantity}</div>
														<div class="CellBordered">${presc.freqType}</div>
														<div class="CellBordered">
															<a href="#" class="glyphicon glyphicon-trash"></a>
														</div>
													</div>
												</c:forEach>
											</div>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td>
										Click 
										<a href="${pageContext.request.contextPath}/prescription/addpres?vi=${visit.id}">here</a>
										to View or Add prescription.
										</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>