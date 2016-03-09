<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>View and Book Reservations</title>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">View and Book Reservation</div>
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-2 control-label">Hotel:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							<c:out value="${hotel.getHotelName()}" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Address:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							<c:out value="${hotel.getHotelAddress()}" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Dates:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							<c:out value="${hotel.getReservationDates()}" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Number Of Rooms:</label>
					<div class="col-sm-10">
						<input type="number" class="form-control col-sm-4" placeholder="Number Of Rooms" name="numberOfRooms" value="${hotel.getNumRooms()}" min="1" max="15" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Price Per Night:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							$
							<c:out value="${hotel.getPricePerNight()}" />
						</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Full Description:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							<c:out value="${hotel.getHotelDescription()}" />
						</p>
					</div>
				</div>

				<div class="form-group clearfix">
					<label class="col-sm-2 control-label">Amenities:</label>
					<div class="col-sm-10">
						<c:forEach var="amen" items="${hotel.getAmenities()}">
							<span class="label label-default">
								<c:out value="${amen}" />
							</span>
						</c:forEach>
					</div>
				</div>
				<p></p>

				<div class="form-group clearfix">
					<label class="col-sm-2 control-label">Rating:</label>
					<div class="col-sm-10">
						<p class="form-control-static">
							<input id="rating" class="rating" data-size="xs" data-symbol="&#xe006;" data-readonly="true" value="${hotel.getHotelRating()}" data-show-clear="false" data-show-caption="false">
						</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Reviews:</label>
					<div class="col-sm-10">
						<c:forEach var="review" items="${hotel.getReviews()}">
							<p class="form-control-static">
								"
								<c:out value="${review}" />
								"
							</p>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="panel-footer clearfix">
				<div class="col-sm-5">
					<form class="form" action="ReservationSearch.jsp">
						<button class="btn btn-default" type="submit">Back</button>
					</form>
				</div>
				<div class="col-sm-5 pull-right">
					<form class="form" action="ReservationTransaction.jsp">
						<button class="btn btn-primary" type="submit">Book</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />
</body>
</html>