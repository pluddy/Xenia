<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Transaction Confirmation</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">
		<div class="alert alert-success" role="alert">Your Reservation has been Confirmed</div>
		<form class="form-horizontal" id="reservationTransaction" action="ReservationTransactionConfirmation.jsp" method="post">
			<div class="panel panel-default">
				<div class="panel-heading">Booking Summary</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Hotel: </label>
						<div class="col-sm-10">
							<p class="form-control-static">Hotel California</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Location: </label>
						<div class="col-sm-10">
							<p class="form-control-static">Orlando, FL</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Number of Rooms: </label>
						<div class="col-sm-10">
							<p class="form-control-static">4</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Dates: </label>
						<div class="col-sm-10">
							<p class="form-control-static">10/31/2016-11/1/2016</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Price: </label>
						<div class="col-sm-10">
							<p class="form-control-static">$499.00</p>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Credit Card Information</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">First Name </label>
						<div class="col-sm-10">
							<p class="form-control-static">John</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name </label>
						<div class="col-sm-10">
							<p class="form-control-static">Smith</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Type </label>
						<div class="col-sm-10">
							<p class="form-control-static">American Express</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Number </label>
						<div class="col-sm-10">
							<p class="form-control-static">XXXX-XXXX-XXXX-1234</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Security Code </label>
						<div class="col-sm-10">
							<p class="form-control-static">XXX</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Expires</label>
						<div class="col-sm-10">
							<p class="form-control-static">2/2020</p>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Billing Information</div>
				<div class="panel-body">
					<address class="col-sm-offset-2">
						<strong>John Smith</strong><br> 1900 Appleseed Dr., Apt 104<br> Potomac, VA, USA 22152<br>
					</address>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/Footer.jsp"/>
</body>
</html>