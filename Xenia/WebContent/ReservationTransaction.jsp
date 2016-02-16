<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Transaction</title>
</head>
<body>
	<jsp:include page="/Header.jsp"/>
	<div class="container">
		<form class="form-horizontal" id="reservationTransaction" action="ReservationTransactionConfirmation.jsp" method="post">
			<div class="panel panel-default">
				<div class="panel-heading">Booking Summary</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">Hotel: </label>
						<div class="col-sm-10">
							<p class="form-control-static">Hotel California</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Location: </label>
						<div class="col-sm-10">
							<p class="form-control-static">Orlando, FL</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Number of Rooms: </label>
						<div class="col-sm-10">
							<p class="form-control-static">4</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Dates: </label>
						<div class="col-sm-10">
							<p class="form-control-static">10/31/2016-11/1/2016</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Price: </label>
						<div class="col-sm-10">
							<p class="form-control-static">$499.00</p>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Credit Card Information</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">First Name </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="John">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Smith">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Type </label>
						<div class="col-sm-2">
							<select class="form-control">
								<option value="Visa">Visa</option>
								<option value="Master Card">Master Card</option>
								<option value="Discover">Discover</option>
								<option value="American Express">American Express</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Number </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="XXXX-XXXX-XXXX-1234">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Security Code </label>
						<div class="col-sm-2">
							<input class="form-control" placeholder="XXX">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Expires</label>
						<div class="col-sm-2">
							<input type="text" class="form-control datepicker" placeholder="mm/yyyy" name="expirationDate">
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Billing Information</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">First Name</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="John">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Smith">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Address 1</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="1900 Appleseed Dr.">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Address 2 </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Apt 104">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">City </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Potomac">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">State </label>
						<div class="col-sm-2">
							<input class="form-control" placeholder="VA">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Country </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="United States of America">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ZIP Code</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="22152">
						</div>
					</div>
				</div>
				<div class="panel-footer clearfix">
					<button class="btn btn-default" onclick="cancel()">Cancel</button>
					<button class="btn btn-primary pull-right" onclick="submit()">Confirm Reservation</button>
				</div>
			</div>
		</form>
	</div>


	<jsp:include page="/Footer.jsp"/>
	<script type="text/javascript">
			$(".datepicker").datepicker( {
			    format: "mm/yyyy",
			    startView: "months", 
			    minViewMode: "months"
			});
			var form = document.getElementById("reservationTransaction");
			
			function cancel() {
				form.action="ReservationSearch.jsp";
				form.submit();
			}
			function submit() {
				form.action="ReservationTransactionConfirmation.jsp";
				form.submit();
			}
			</script>
</body>
</html>