<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Cancellation Confirmation</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="CustomerHomepage.jsp">Xenia</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="ManageReservations.jsp">Manage</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Login.jsp">Logout</a></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container">
	<div class="alert alert-danger" role="alert">Your Reservation has been Cancelled</div>
	<div class="panel panel-default">
		<div class="panel-heading">Information</div>
		<div class="panel-body">
		<label class="col-sm-4">Hotel: </label> 
		<label id="Hotel" class="col-sm-8">Hotel California</label>
		<label class="col-sm-4">City: </label>
		<label id="City" class="col-sm-8">Orlando, FL</label>
		<label class="col-sm-4">Dates:</label>
		<label id="Dates" class="col-sm-8">10/31/2016 - 11/1/2016</label>
		<label class="col-sm-4">Status:</label>
		<label id="Status" class="col-sm-8">Cancelled</label>
		<label class="col-sm-4">Money Credited Back to Card:</label>
		<label id="MoneyBack" class="col-sm-8">$499.00 to Card XXXX-XXXX-XXXX-1234</label>
		</div>
		</div>
	</div>

	<script type="text/javascript"
		src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>