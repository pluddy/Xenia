<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>View and Book Reservations</title>
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
		<div class="panel panel-default">
			<div class="panel-heading">View and Book Reservation</div>
			<div class="panel-body">
				<div class="col-sm-12">
					<label class="col-sm-6">Hotel: </label> <label id="Hotel"
						class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Address: </label> <label id="Address"
						class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Dates: </label> <label id="Dates"
						class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Number Of Rooms: </label> <input
						type="number" class="form-control col-sm-4"
						placeholder="Number Of Rooms" name="numberOfRooms" min="1"
						max="15" />
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Price Per Night: </label> <label
						id="PricePerNight" class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Full Description: </label> <label
						id="FullDescription" class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Amenities: </label> <label id="Amenities"
						class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Rating: </label> <label id="Rating"
						class="col-sm-6"></label>
				</div>

				<div class="col-sm-12">
					<label class="col-sm-6">Reviews: </label> <label id="Reviews"
						class="col-sm-6"></label>
				</div>
				</div>

				<div class="panel-footer clearfix">
					<div class="pull-right">
						<div class="col-sm-5">
							<form class="form" action="ReservationSearch.jsp">
								<button class="btn btn-default" type="submit">Back</button>
							</form>
						</div>
						<div class="col-sm-5">
							<form class="form" action="ConfirmCancellation.jsp">
								<button class="btn btn-primary" type="submit">Book</button>
							</form>
						</div>
					</div>
				
			</div>
		</div>
	</div>
	</div>

	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>