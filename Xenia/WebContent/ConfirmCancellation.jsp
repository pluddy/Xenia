<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancellation Confirmation</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
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

	<jsp:include page="/Footer.jsp"/>
</body>
</html>