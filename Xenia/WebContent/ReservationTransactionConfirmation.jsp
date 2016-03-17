<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Transaction Confirmation</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">
		<div class="alert alert-success" role="alert"><c:out value="${message }" /></div>
		<form class="form-horizontal" id="reservationTransaction" action="ReservationTransactionConfirmation.jsp" method="post">
			<div class="panel panel-default">
				<div class="panel-heading">Booking Summary</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Hotel: </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${hotel.getHotel().getName() }" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Location: </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${hotel.getHotel().getCity() }" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Number of Rooms: </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${hotel.getQuery().getNumRooms() }" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Dates: </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${hotel.getQuery().getCheckInString() }" />-<c:out value="${hotel.getQuery().getCheckOutString() }" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Price: </label>
						<div class="col-sm-10">
							<p class="form-control-static">$<c:out value="${hotel.getRoom().getPricePerNight() }" /></p>
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
							<p class="form-control-static"><c:out value="${user.getFirstName()}" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${user.getLastName()}" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Type </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${transaction.getCardNickname()}" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Number </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${transaction.getCreditCardNumber()}" /></p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Security Code </label>
						<div class="col-sm-10">
							<p class="form-control-static"><c:out value="${transaction.getCvv()}" /></p>
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
						<strong><c:out value="${user.getFirstName()}" /> <c:out value="${user.getLastName()}" /></strong><br><c:out value="${user.getAddress1()}" />, <c:out value="${user.getAddress2()}" /><br> <c:out value="${user.getCity()}" />, <c:out value="${user.getState()}" />, <c:out value="${user.getZip()}" /><br>
					</address>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/Footer.jsp"/>
</body>
</html>