<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Reservation Transaction</title>
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
						<a class="navbar-brand" href="Login.jsp">Log Out</a>
			
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
<div class="container">
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
	<div id="CreditCardInformation" class="col-sm-12">
			<div class="col-sm-12">
				
					<label for="FirstName" class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="First Name"
						name="FirstName" id="FirstName">
				</div>
				
					<label for="LastName" class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Last Name"
						name="LastName" id="LastName">
				</div>
				
					<label for="CardType" class="col-sm-2 control-label">Card Type</label>
				<div class="col-sm-4">
					<select>
						<option value="Visa">Visa</option>
						<option value="Master Card">Master Card</option>
						<option value="Discover">Discover</option>
						<option value="American Express">American Express</option>
					</select>
				</div>
				
					<label for="CreditCardNumber" class="col-sm-2 control-label">Credit Card Number</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Credit Card Number"
						name="CreditCardNumber" id="CreditCardNumber">
				</div>
				
					<label for="SecurityCode" class="col-sm-2 control-label">Security Code</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-3" placeholder="Security Code"
						name="SecurityCode" id="SecurityCode">
				</div>
				
					<label for="ExpirationDate" class="col-sm-2 control-label">Expiration Date </label>
				<div class="col-sm-4">
					<select>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
				<div class="col-sm-4">
					<select>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
						<option value="2023">2023</option>
					</select>
				</div>
				
				<div id="BillingAddress" class="col-sm-12">
				
				</div>
			</div>
	
							<label for="Name" class="col-sm-2 control-label">Name</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Name"
						name="Name" id="Name">
				</div>
				
					<label for="Address1" class="col-sm-2 control-label">Address 1</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Address 1"
						name="Address1" id="Address1">
				</div>
				
									<label for="Address2" class="col-sm-2 control-label">Address 2(Apt, PO Box, etc.)</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Address 2"
						name="Address2" id="Address2">
				</div>
				
											<label for="City" class="col-sm-2 control-label">City</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="City"
						name="City" id="City">
				</div>
				
					<label for="State" class="col-sm-2 control-label">State</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="State"
						name="State" id="State">
				</div>
				
									<label for="Country" class="col-sm-2 control-label">Country</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Country"
						name="Country" id="Country">
				</div>
				
									<label for="ZipCode" class="col-sm-2 control-label">Zip Code</label>
				<div class="col-sm-4">
					<input type="text" class="form-control col-sm-4" placeholder="Zip Code"
						name="Zip Code" id="Zip Code">
	</div>

		<div class="col-sm-12">
		 <div class="col-sm-3">
		 <form class="form" action="ReservationSearch.jsp">
		 <button class="btn btn-default" type="submit">Cancel</button>
		 </form>
		 </div>
		 		<div class="col-sm-3">
		 <form class="form" action="ConfirmReservation.jsp">
		 <button class="btn btn-default" type="submit">Confirm Reservation</button>
		 </form>
		 </div>
		</div>

	</div>


		<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>