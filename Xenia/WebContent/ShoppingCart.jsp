<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">

		<div id="ReservationDiv">
			<table id="ReservationTable" class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>Description</th>
						<th>Room Type</th>
						<th>Check In</th>
						<th>Check Out</th>
						<th>Price/Night</th>
						<th>Rooms</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${shoppingCart.getReservations()}">
					<tr>
						<td><c:out value="${item.getHotel().getName()}"/></td>
						<td><c:out value="${item.getHotel().getAddress()}"/></td>
						<td><c:out value="${item.getHotel().getDescription()}"/></td>
						<td><c:out value="${item.getRoom().getRoomType().getRoomType()}"/></td>
						<td><c:out value="${item.getQuery().getCheckInString()}"/></td>
						<td><c:out value="${item.getQuery().getCheckOutString()}"/></td>
						<td>$<c:out value="${item.getRoom().getPricePerNight()}"/></td>
						<td><c:out value="${item.getQuery().getNumRooms()}"/></td>
						<td>$<c:out value="${item.getPrice()}"/></td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<tr>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
						<th>Total</th>
						<td>$<c:out value="${shoppingCart.getTotalPrice()}"/></td>
					</tr>
				</tfoot>
			</table>
			<form action="ReservationTransaction.jsp" >
				<button type="submit" class="btn btn-primary pull-right">Check Out</button>
			</form>
		</div>
	</div>

	<jsp:include page="/Footer.jsp"/>

</body>
</html>