<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reservation Search Results</title>
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
						<th>Rating</th>
						<th>Price Per Night</th>
						<th>Amenities</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Hotel California</td>
						<td>9999 Disney Dr.<br>Orlando, FL, USA
						</td>
						<td>A beautiful suite overlooking the Disney Hollywood Studios Park</td>
						<td>Suite</td>
						<td><input id="rating" class="rating" data-size="xs" data-symbol="&#xe006;" data-readonly="true" value="4.5" data-show-clear="false" data-show-caption="false"></td>
						<td>$499.00</td>
						<td>Pool, Paid Internet Access, Pet Friendly</td>
						<td>
							<form class="form" action="ViewAndBookReservations.jsp">
								<button class="btn btn-default pull-right" type="submit">View & Book</button>
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