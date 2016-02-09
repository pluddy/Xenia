<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Reservation Transaction Confirmation</title>
</head>
<body>
		<nav class="navbar navbar-default">
	<div class="container-fluid">
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
			<a class="navbar-brand" href="ManageReservations.jsp">Manage Reservations</a>
			<a class="navbar-brand" href="Login.jsp">Log Out</a>
			
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	
	<div class="Container">
	
	<div class="col-sm-12">
	<label class="col-sm-12">Your reservation has been confirmed!</label>
	</div>
	
	<div class="col-sm-12">
		<label class="col-sm-3">Hotel: </label>
		<label id="Hotel" class="col-sm-12"></label>
		<label class="col-sm-6">Location: </label>
		<label id="Location" class="col-sm-12"></label>
		<label class="col-sm-6">Number of Rooms: </label>
		<label id="NumberOfRooms" class="col-sm-12"></label>
		<label class="col-sm-6">Dates: </label>
		<label id="Dates" class="col-sm-12"></label>
		<label class="col-sm-6">Price: </label>
		<label id="Price" class="col-sm-12"></label>
	</div>
	
	
		<div id="BillingAddress" class="col-sm-12">
				<label for="BillingInformation" class="col-sm-12 control-label">Billing Address</label>
				</div>
			
	
							<label for="Name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-4">
							<label for="Name" class="col-sm-6 control-label">Name</label>
				</div>
				
					<label for="Address1" class="col-sm-2 control-label">Address 1</label>
				<div class="col-sm-4">
							<label for="Address1" class="col-sm-6 control-label">Address 1</label>
				</div>
				
					<label for="Address2" class="col-sm-2 control-label">Address 2(Apt, PO Box, etc.)</label>
				<div class="col-sm-4">
					<label for="Address2" class="col-sm-6 control-label">Address 2(Apt, PO Box, etc.)</label>

				</div>
				
					<label for="City" class="col-sm-2 control-label">City</label>
				<div class="col-sm-4">
					<label for="City" class="col-sm-6 control-label">City</label>
				</div>
				
					<label for="State" class="col-sm-2 control-label">State</label>
				<div class="col-sm-4">
					<label for="State" class="col-sm-6 control-label">State</label>
				</div>
				
					<label for="Country" class="col-sm-2 control-label">Country</label>
				<div class="col-sm-4">
					<label for="Country" class="col-sm-6 control-label">Country</label>
				</div>
				
					<label for="ZipCode" class="col-sm-2 control-label">Zip Code</label>
				<div class="col-sm-4">
					<label for="ZipCode" class="col-sm-6 control-label">Zip Code</label>
				</div>
	
	</div>
	
			<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>