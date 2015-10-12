<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Prescription</title>
<%@include file="Include.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/AddPrescription.js"></script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container">
		<div align="center">
			<h2 class="form-signin-heading">Add Prescription</h2>
		</div>

		<form role="form" class="patient-form" action="add"
			enctype="multipart/form-data" method="post">
			<div class="Table table-condensed" width="100%">
				<div class="Row">
					<div class="Cell" align="left">
						<span class="mandatory-field-msg">Fields with asterisk (<i class="glyphicon glyphicon-asterisk"></i>)
							are mandatory</span>
					</div>
					
				</div>
				<div class="Row">
					<div style="display: none;">
						<input value="${vi}" type="hidden" name="visit.id" />
					</div>
					<div class="Cell" valign="top">
						<div class="Table add-medicine-tab">
							<div class="Row">
								<div class="Cell">Medicine<i class="glyphicon glyphicon-asterisk"></i></div>
								<div class="Cell">
									<input placeholder="Medicine"
										class="form-control medicine-name" name="medicine.name">
								</div>
							</div>
							<div class="Row">
								<div class="Cell">Frequency<i class="glyphicon glyphicon-asterisk"></i></div>
								<div class="Cell">
									<input placeholder="Frequency" class="form-control"
										name="frequency">
								</div>
							</div>
							<div class="Row">
								<div class="Cell">Quantity<i class="glyphicon glyphicon-asterisk"></i></div>
								<div class="Cell">
									<input placeholder="Quantity" class="form-control"
										name="medQuantity">
								</div>
							</div>
							<div class="Row">
								<div class="Cell">Frequency Type<i class="glyphicon glyphicon-asterisk"></i></div>
								<div class="Cell">
									<input placeholder="Frequency Type" class="form-control"
										name="freqType">
								</div>
							</div>
							<div class="Row">
								<div class="Cell"></div>
								<div class="Cell">
									<button id="addBtn" type="submit"
										class="btn btn-lg btn-primary btn-block">Add</button>
								</div>
							</div>
						</div>
					</div>
					<div class="Cell" style="vertical-align: top;">
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
							<c:forEach items="${prescriptions}" var="presc" varStatus="stat">
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
					</div>
				</div>
			</div>
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