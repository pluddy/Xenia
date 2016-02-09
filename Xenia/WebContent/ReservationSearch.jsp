<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Reservation Search Results</title>
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

		<div id="ReservationDiv">
			<table id="ReservationTable" class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>Description</th>
						<th>Room Type</th>
						<th>Rating</th>
						<th>Price Per Night</th>
						<th>Amenities</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Hotel California</td>
						<td>9999 Disney Dr.<br>Orlando, FL, USA</td>
						<td>A beautiful suite overlooking the Disney Hollywood Studios Park</td>
						<td>Suite</td>
						<td>4.5 Stars</td>
						<td>$499.00</td>
						<td>Pool, Paid Internet Access, Pet Friendly</td>
						<td>
							<form class="form" action="ViewAndBookReservations.jsp">
								<button class="btn btn-default pull-right" type="submit">View & Book</button>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>