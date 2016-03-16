<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
					<label id="Hotel" class="col-sm-8">
					<c:out value="${reservation.get(0).getHotel().getName()}"/></label>
				<label class="col-sm-4">City: </label>
				<label id="City" class="col-sm-8">
				<c:out value="${reservation.get(0).getHotel().getCity()}, "/>
				<c:out value="${reservation.get(0).getHotel().getState()}"/></label>
				<label class="col-sm-4">Dates:</label>
				<label id="Dates" class="col-sm-8">
				<c:out value="${reservation.get(0).getCheckInDate() } - "/>
				<c:out value="${reservation.get(0).getCheckOutDate() }"/>
				</label>
				<label class="col-sm-4">Status:</label>
				<label id="Status" class="col-sm-8">Cancelled</label>
				<label class="col-sm-4">Money Credited Back to Card:</label>
				<label id="MoneyBack" class="col-sm-8">${moneyBack}</label>
			</div>
		</div>
	</div>

	<jsp:include page="/Footer.jsp"/>
</body>
</html>