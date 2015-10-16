<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spectacle Prescription</title>
<%@include file="Include.jsp"%>
</head>
<body>
<div class="container">
	<%@include file="Header.jsp"%>
	<br>
	<div align="center">
		<div class="prescription-container">
			<div class="row">
				<div class="col-md-6">
					<div class="row">
						<h2 class="text-info">Smith Eye Clinic</h2>
					</div>
					<div class="row">
						<img alt="NoImage" src="resources/images/Eye-icon.png" width="100">
					</div>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<div class="row">
						<h3 align="right" class="text-info">Dr. Smith Johnson</h3>
					</div>
					<div class="row" align="right">1 Main Street</div>
					<div class="row" align="right">Boston, Massachusetts</div>
					<div class="row" align="right">SL1 4DX</div>
					<div class="row" align="right">Tel.(617) 262-2020</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-9" align="left">Name:_______________________________________________</div>
				<div class="col-md-3">Date:_____________</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-12" align="left">Address:______________________________________________________________________________________</div>
			</div>
			<br>
			<div class="row">
				<table class="table table-bordercolor" border="1">
					<thead>
						<tr>
							<th colspan="2">Rx</th>
							<th>Spherical</th>
							<th>Cylindrical</th>
							<th>Axis</th>
							<th>Prism</th>
							<th>Base</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th rowspan="2" valign="middle">D.V</th>
							<th>O.D</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
						</tr>
						<tr>
							<th>O.S</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
						</tr>
						<tr>
							<th rowspan="2" valign="middle">N.V</th>
							<th>O.D</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
						</tr>
						<tr>
							<th>O.S</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
							<th>
								<input class="form-control input-md"/>
							</th>
						</tr>
					</tbody>
				</table>
			</div>
			<br>
			<div class="row">
				<div class="col-md-9" align="left">REMARKS:_______________________________________________</div>
				<div class="col-md-3">Signature:_____________</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>