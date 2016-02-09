<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Cancel Reservations</title>
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
			<a class="navbar-brand" href="#">Xenia</a>
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
	<div class="panel panel-default">
		<div class="panel-heading">Cancel Reservation?</div>
		<div class="panel-body">
		<label class="col-sm-2">Hotel: </label> 
		<label id="Hotel" class="col-sm-10">Hotel California</label>
		<label class="col-sm-2">City: </label>
		<label id="City" class="col-sm-10">Orlando, FL</label>
		<label class="col-sm-2">Dates:</label>
		<label id="Dates" class="col-sm-10">10/31/2016 - 11/1/2016</label>
		</div>
		<div class="panel-footer clearfix">
		<div class="pull-right">
			<div class="col-sm-4">
				<form class="form" action="CustomerHomepage.jsp">
					<button class="btn btn-default" type="submit">Cancel</button>
				</form>
			</div>
			<div class="col-sm-4">
				<form class="form" action="ConfirmCancellation.jsp">
					<button class="btn btn-danger" type="submit">Confirm
						Cancellation</button>
				</form>
			</div>
			</div>
		</div>
		</div>
	</div>

	<script type="text/javascript"
		src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>