<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Reservations</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
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
			<div class="panel-footer">
				<div class="clearfix">
					<form class="form" action="ConfirmCancellation.jsp">
						<button class="btn btn-danger pull-right" type="submit">Confirm Cancellation</button>
					</form>
					<form class="form" action="CustomerHomepage.jsp">
						<button class="btn btn-default pull-right" type="submit">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/Footer.jsp"/>
</body>
</html>