<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Xenia</a>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
		
	 <button id="ManageReservations" class="btn btn-default">Manage Reservations</button>
	 <button id="Logout" class="btn btn-default">Log Out</button>
		
	<div id="ReservationDiv">
	<table id="ReservationTable">
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
		<td> </td>
		<td> </td>
		<td> </td>
		<td> </td>
		<td> </td>
		<td> </td>
		<td> </td>
		<td> <input type="button" id="ViewAndBook" class="btn btn-default">View and Book</input> </td>
	</tr>
	</tbody>
	</table>
	</div>	
	
</body>
</html>