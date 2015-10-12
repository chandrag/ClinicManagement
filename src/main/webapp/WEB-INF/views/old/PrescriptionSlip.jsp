<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prescription Slip</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<div class="container pres-container">
		<div class="header">
			<div class="Table">
				<div class="Row">
					<div class="Cell valign-top">
						<img width="50" alt="No Image"
							src="${pageContext.request.contextPath}/resources/images/RxSymbol.png">
					</div>
					<div class="Cell valign-top">
						<div class="Table">
							<div class="Row">
								<div class="Cell">
									<span class="doctor-name">Dr. Rajesh Ugale</span><br /> <span>M.D.
										Eye Specialist</span>
								</div>
							</div>
						</div>
					</div>
					<div class="Cell" style="vertical-align: bottom;">
						<div class="central-patient-details">${visit.patient.firstName}&nbsp;${visit.patient.middleName}&nbsp;${visit.patient.lastName}</div>
					</div>
					<div class="Cell valign-top">
						<div class="Table">
							<div class="Row">
								<div class="Cell valign-top">
									<strong>Address</strong>
								</div>
								<div class="Cell">
									<span>A-1, Complex</span><br /> <span>Amankha Plot</span><br />
									<span>Akola-444001</span><br /> <span>Mob:9870098600</span><br />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="horizontal-line"></div>
		<br />
		<div class="Table">
			<div class="Row">
				<div class="Cell label">Patient Id:</div>
				<div class="Cell label">${visit.patient.id}</div>
			</div>
		</div>
		<div class="Table">
			<div class="Row">
				<div class="Cell presc-medicine-panel">
					<div class="panel panel-success">
						<div class="panel-heading">Prescribed Medicines</div>
						<table class="table">
							<thead>
								<tr>
									<th>Sr.No</th>
									<th>Medicine</th>
									<th>Frequency</th>
									<th>Quantity</th>
									<th>Max</th>
								</tr>
							</thead>
							<c:forEach items="${visit.prescriptions}" var="presc"
								varStatus="stat">
								<tr>
									<td>${stat.count}</td>
									<td>${presc.medicine.name}</td>
									<td>${presc.frequency} times a day</td>
									<td>${presc.medQuantity} tablet</td>
									<td>10</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>