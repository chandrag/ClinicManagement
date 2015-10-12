<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Queue</title>
<%@include file="Include.jsp"%>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br />
	<br />
	<div class="container content-pane" align="center">
		<h2 class="form-signin-heading">Today's Patient Queue</h2>
		<c:if test="${PatientQueue != null && fn:length(PatientQueue)>0}">
			
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div align="left" class="thumb-title">Patients in Queue</div>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${PatientQueue}" var="patQueue" varStatus="stat" begin="0">
					
					<div class="col-xs-6 col-md-3">
						
						<div class="thumbnail">
							<div class="queue-index">${stat.index+1}</div>
							<img
								width="150" height="150"
								src="${pageContext.request.contextPath}/patient/fetchprofilepic?q=${patQueue.patient.id}"
								alt="No Image">
							<div class="caption">
								<h3>${patQueue.patient.firstName}&nbsp;${patQueue.patient.lastName}</h3>
								<p>
									<a  href="#" class="btn btn-primary" role="button">Done</a>
									<a  href="#" class="btn btn-default" role="button">NA</a>
								</p>
							</div>
						</div>
					</div>

				</c:forEach>
			</div>
		</c:if>
		<c:if test="${fn:length(PatientQueue)==0}">
			No appointments yet!
		</c:if>
	</div>
</body>
</html>