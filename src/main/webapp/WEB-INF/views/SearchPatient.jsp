<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Patient</title>
<%@include file="Include.jsp"%>
<script type="text/javascript">

	function fnDelPatient() {
		var form = document.getElementById('patientActions');
		form.action = 'deletepatient';
		form.submit();
	}
	
	function fnFetchVisits(p){
		var form = document.getElementById('patientActions');
		form.action = '../visitshome/fetch';
		form.submit();
	}

	function fnChangeSearchType(curr) {
		console.log('Criteria : ' + curr.value);
		var crit = document.getElementById('searchCrit');
		if (curr.value == 1) {
			crit.value = 'Patient Id';
		} else if (curr.value == 2) {
			crit.value = 'Name';
		} else if (curr.value == 3) {
			crit.value = 'MRD';
		}
	}
</script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container content-pane">
		<h2 class="form-signin-heading">Search Patient</h2>
		<form role="form" class="patient-form" action="search" method="post">

			<table class="table-condensed">
				<tbody>
					<tr>
						<th>Search for</th>
						<td colspan="2"><select class="form-control" name="searchFor">
								<option value="101">Patient Id</option>
								<option value="102">Name</option>
								<option value="103">MRD</option>
						</select></td>
						<td><input id="searchCrit" autofocus="" required=""
							placeholder="Enter a value" class="form-control"
							name="searchText"></td>

						<td colspan="2">
							<button id="searchBtn" type="submit" class="btn btn-lg btn-success">Search</button>
						</td>
						<td colspan="2"></td>
					</tr>
				</tbody>
			</table>

		</form>
		<c:if test="${PatientTo != null}">
			<div class="jumbotron">
				<h3>Search Results</h3>
				<div class="patient-action-buttons">
					<form id="patientActions" action="editpatient" method="post">
						<input type="hidden" name="patientId" value="${PatientTo.id}" />
						<button id="visitsBtn" class="btn btn-xs btn btn-primary" onclick="fnFetchVisits(${PatientTo.id})" type="button">Visits</button>
						<button id="updateBtn" class="btn btn-xs btn-info" type="submit">Update</button>
						<button id="deleteBtn" class="btn btn-xs btn-danger" onclick="fnDelPatient()"
							type="button">Delete</button>
					</form>
				</div>
			
				<table width="100%" class="table-condensed">
					<tbody>
						<tr>
							<td width="30%" valign="top">
								<div class="row">
									<div id="prof-pic" class="col-sm-6 col-md-4">
										<div class="thumbnail">
											<img
												src="fetchprofilepic?q=${PatientTo.id}"
												alt="No Image Uploaded" width="200">
											<div class="caption" align="center">
												<h3>${PatientTo.firstName}&nbsp;${PatientTo.lastName}</h3>
											</div>
										</div>
									</div>
								</div>
							</td>
							<td>
								<table class="patient-details" width="100%">
									<tr>
										<th>Patient Id</th>
									</tr>
									<tr>
										<td id="patientId">${PatientTo.id}</td>
									</tr>									
									<tr>
										<th>Mobile No</th>
										<th>Email</th>
									</tr>
									<tr>
										<td id="mobileNo">${PatientTo.contact.mobileNo}</td>
										<td id="emailId">${PatientTo.contact.personalEmail}</td>
									</tr>
									<tr>
										<th>AddrLine1</th>
										<th>AddrLine2</th>
									</tr>
									<tr>
										<td id="addrLine1">${PatientTo.contact.address.addrLine1}</td>
										<td id="addrLine2">${PatientTo.contact.address.addrLine2}</td>
									</tr>
									<tr>
										<th>City</th>
										<th>State</th>
									</tr>
									<tr>
										<td id="city">${PatientTo.contact.address.city}</td>
										<td id="state">${PatientTo.contact.address.state}</td>
									</tr>
									<tr>
										<th>Zipcode</th>
									</tr>
									<tr>
										<td id="zipCode">${PatientTo.contact.address.pinCode}</td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			<h3>Patient Visits</h3>	
			<c:if test="${fn:length(Visits)>0}">
				<div class="patient-action-buttons">
					<form id="patientActions" action="editpatient" method="post">
						<input type="hidden" name="patientId" value="${PatientTo.id}" />
						<button class="btn btn-xs btn-info" type="submit">Update</button>
						<a href="../patient/searchpatient" class="btn btn-xs btn-primary">Back</a>
					</form>
				</div>
				<c:forEach items="${Visits}" var="visit">
					<div class="jumbotron">
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
									<th>Prescription</th>
								</tr>
								<tr>
									<td>${visit.problems}</td>
									<td>${visit.prescription}</td>
								</tr>
								<tr>
									<th>Allergies</th>
									<th>Test Results</th>
								</tr>
								<tr>
									<td>
										<c:if test="${visit.allergies != ''}">
											${visit.allergies}
										</c:if>
										<c:if test="${visit.allergies == ''}">
											NA
										</c:if>
									</td>
									<td>
										<c:if test="${visit.testResults != ''}">
											${visit.testResults}
										</c:if>
										<c:if test="${visit.testResults == ''}">
											NA
										</c:if>
									</td>
								</tr>
								<tr>
									<th>Symptoms</th>
								</tr>
								<tr>
									<td>
										<c:if test="${visit.symptoms != ''}">
											${visit.symptoms}
										</c:if>
										<c:if test="${visit.symptoms == ''}">
											NA
										</c:if>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${fn:length(Visits)==0}">
				<a id="createVisitBtn" class="btn btn-lg btn-primary" type="button" href="${pageContext.request.contextPath}/visitshome/createvisit">Create Visit</a>
			</c:if>	
			</div>
		</c:if>
	</div>
</body>
</html>