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
				<div class="form-group">
					<label class="col-sm-2 control-label">Hotel:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">Hotel California</p>
	    			</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Address:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">9999 Disney Dr.<br>Orlando, FL, USA</p>
	    			</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Dates:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">10/31/2016-11/1/2016</p>
	    			</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Number Of Rooms:</label>
					<div class="col-sm-10">
	      				<input type="number" class="form-control col-sm-4" placeholder="Number Of Rooms" name="numberOfRooms" min="1" max="15" />
	    			</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Price Per Night:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">$499.00</p>
	    			</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Full Description:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">A beautiful suite overlooking the Disney Hollywood Studios Park.  A bunch of fun as long as you survive the elevator ride!</p>
	    			</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Amenities:</label>
					<div class="col-sm-12">
						<span class="label label-default">Pool</span>
						<span class="label label-default">Paid Internet Access</span>
						<span class="label label-default">Pet Friendly</span>
	    			</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Rating:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">4.5 Stars</p>
	    			</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Reviews:</label>
					<div class="col-sm-10">
	      				<p class="form-control-static">"For some reason we had to go to the basement to ride the elevator, but it was a great time and a beautiful hotel!"</p>
	    			</div>
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
						<form class="form" action="ReservationTransaction.jsp">
							<button class="btn btn-primary" type="submit">Book</button>
						</form>
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