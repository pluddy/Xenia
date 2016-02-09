<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Manage Reservations</title>
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
			<a class="navbar-brand" href="CustomerHomepage.jsp">Home</a>
			<a class="navbar-brand" href="#">Xenia</a>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="table-responsive">	 
		 <table class="table table-bordered">
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
		 <td> </td>
		 <td> </td>
		 <td> </td>
		 <td> 
		 <form class="form" action="CancelReservations.jsp">
		 <button class="btn btn-default" type="submit">Cancel Reservations</button>
		 </form>
		 </td>
		 </tr>
		 </tbody>
		 </table>
	</div>
	
			<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>