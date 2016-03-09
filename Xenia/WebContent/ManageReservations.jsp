<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Reservations</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Current Reservations</div>
			<table class="table table-responsive">
				<thead>
					<tr>
						<th>Hotel</th>
						<th>City</th>
						<th>Dates</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
					<c:forEach var="reservation" items="${reservations}">
					<tr>
						<td><c:out value="${reservation.getHotel().getName()}"/></td>
						<td><c:out value="${reservation.getHotel().getCity()}"/></td>
						<td><c:out value="${reservation.getCheckInDate()"/> " - " <c:out value="${reservation.getCheckOutDate()"/></td>
						<td>
							<form class="form" action="ReservationSearchResults" method="post">
								<button class="btn btn-default pull-right" type="submit" name="hotelId" value="${reservation.getId()}">Cancel Reservation</button>
							</form>
						</td>
					</tr>
				</c:forEach>
						<td>Hotel California</td>
						<td>Orlando, Florida</td>
						<td>10/31/2016 - 11/1/2016</td>
						<td>
							<form class="form" action="CancelReservations.jsp">
								<button class="btn btn-danger pull-right" type="submit">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									Cancel
								</button>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/Footer.jsp"/>
</body>
</html>