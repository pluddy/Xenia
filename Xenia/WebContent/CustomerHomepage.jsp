<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xenia</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">
		<div class="jumbotron">
			<h2>Customer Homepage</h2>
		</div>
		<div class="col-sm-6">
			<form class="form-horizontal" method="post" action="ReservationSearch.jsp">
				<div class="panel panel-default">
					<div class="panel-heading">Search Reservations</div>
					<div class="panel-body">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Check In Date</label>
							<div class="col-sm-9">
								<input type="text" class="form-control datepicker" placeholder="Check In Date" name="checkInDate">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Check Out Date</label>
							<div class="col-sm-9">
								<input type="text" class="form-control datepicker" placeholder="Check Out Date" name="checkOutDate">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Location City</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" placeholder="Location City" name="locationCity">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Number of Rooms</label>
							<div class="col-sm-9">
								<input type="number" class="form-control" placeholder="Number Of Rooms" name="numberOfRooms" min="1" max="100">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Room Type</label>
							<div class="col-sm-9">
								<select class="form-control">
									<option value="Standard">Standard</option>
									<option value="Family">Family</option>
									<option value="Suite">Suite</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Amenities</label>
							<div class="col-sm-9 btn-group-vertical" data-toggle="buttons">
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="Bathtub">Bathtub
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="FreeBreakfast">Free Breakfast
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="FreeWiFi">Free Wi-Fi
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="Gym">Gym
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="PaidInternetAccess">Paid Internet Access
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="Pool">Pool
								</label>
								<label class="btn btn-primary">
									<input type="checkbox" autocomplete="off" value="PetFriendly">Pet Friendly
								</label>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<button type="submit" class="btn btn-default pull-right" id="searchButton">Search</button>
						<div class="clearfix"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/Footer.jsp"/>
	<script type="text/javascript">
	$(function() {
		$('.datepicker').datepicker({
			format : 'mm/dd/yyyy',
			todayHighlight : 'true'
		});
	});
</script>
</body>
</html>