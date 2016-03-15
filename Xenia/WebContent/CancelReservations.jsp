<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<label id="Hotel" class="col-sm-10">
					<c:out value="${reservation.getHotel().getName()}"/></label>
				<label class="col-sm-2">City: </label>
				<label id="City" class="col-sm-10">
				<c:out value="${reservation.getHotel().getCity()}, "/>
				<c:out value="${reservation.getHotel().getState()}"/></label>
				<label class="col-sm-2">Dates:</label>
				<label id="Dates" class="col-sm-10">
				<c:out value="${reservation.getCheckInDate() } - "/>
				<c:out value="${reservation.getCheckOutDate() }"/>
				</label>
			</div>
			<div class="panel-footer">
				<div class="clearfix">
					<form class="form" action="CancelReservation" method="post">
						<button class="btn btn-danger pull-right" name="reservationId" type="submit" value="${reservation.getId()}">Confirm Cancellation</button>
					</form>
					<form class="form" action="ManageReservation" method="get">
						<button class="btn btn-default pull-right" name="Cancel" type="submit" value="Cancel">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/Footer.jsp"/>
</body>
</html>