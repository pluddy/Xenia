<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Xenia</title>
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
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	
	<div class="container">
		<h1>Customer Homepage</h1>
	</div>
	
	<form class="form-horizontal" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Check In Date:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="Check In Date"
						name="checkInDate">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Check Out Date:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="Check Out Date"
						name="checkOutDate">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Location City</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="Location City"
						name="locationCity">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Number of Rooms</label>
				<div class="col-sm-4">
					<input type="number" class="form-control" placeholder="Number Of Rooms"
						name="numberOfRooms" min="1" max="100">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Room Type</label>
				<div class="col-sm-4">
					<select>
					<option value="Standard">Standard</option>
					<option value="Family">Family</option>
					<option value="Suite">Suite</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Amenities</label>
				<div class="col-sm-4 checkbox">
					<label><input type="checkbox" value="BathtubInRoom">Bathtub In Room</label>
					<label><input type="checkbox" value="FreeBreakfast">Free Breakfast</label>
					<label><input type="checkbox" value="FreeWiFi">Free Wi-Fi</label>
					<label><input type="checkbox" value="Gym">Gym</label>
					<label><input type="checkbox" value="PaidInternetAccess">Paid Internet Access</label>
					<label><input type="checkbox" value="Pool">Pool</label>
					<label><input type="checkbox" value="PetFriendly">Pet Friendly</label>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" id="registerButton">Register</button>
				</div>
			</div>
		</form>
		<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
	  $(function() {
		    $("#checkInDate").datepicker();
		  });
	  $(function() {
		    $("#checkOutDate").datepicker();
		  });
	</script>
</body>
</html>