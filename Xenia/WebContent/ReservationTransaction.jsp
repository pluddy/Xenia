<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Transaction</title>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<div class="container">
		<div id="results">
	</div>
		<form class="form-horizontal" id="reservationTransaction" action="TransactionConfirmation" method="post">
		<button class="btn btn-primary pull-right" type="submit" id="makeReservation" style="display: none">Finish Reservation</button>
				<div class="panel panel-default">
					<div class="panel-heading">Booking Summary</div>
					<div class="panel-body">
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
										<td><c:out value="${item.getHotel().getName()}" /></td>
										<td><c:out value="${item.getHotel().getAddress()}" /></td>
										<td><c:out value="${item.getHotel().getDescription()}" /></td>
										<td><c:out value="${item.getRoom().getRoomType().getRoomType()}" /></td>
										<td><c:out value="${item.getQuery().getCheckInString()}" /></td>
										<td><c:out value="${item.getQuery().getCheckOutString()}" /></td>
										<td>$<c:out value="${item.getRoom().getPricePerNight()}" /></td>
										<td><c:out value="${item.getQuery().getNumRooms()}" /></td>
										<td>$<c:out value="${item.getPrice()}" /></td>
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
									<td id="totalPrice">$<c:out value="${shoppingCart.getTotalPrice()}" /></td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			<div class="panel panel-default">
				<div class="panel-heading">Credit Card Information</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">First Name </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="John" name="creditFirstName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Smith" name="creditLastName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Type </label>
						<div class="col-sm-2">
							<select class="form-control">
								<option value="Visa" name="creditCardType">Visa</option>
								<option value="Master Card" name="creditCardType">Master Card</option>
								<option value="Discover" name="creditCardType">Discover</option>
								<option value="American Express" name="creditCardType">American Express</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Card Number </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="XXXX-XXXX-XXXX-1234" id="creditCardNumber" name="creditCardNumber">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Security Code </label>
						<div class="col-sm-2">
							<input class="form-control" placeholder="XXX" id="creditCardCVV" name="creditCardCVV">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Expires</label>
						<div class="col-sm-2">
							<input type="text" class="form-control datepicker" placeholder="mm/yyyy" name="creditCardExpirationDate">
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
							<input class="form-control" placeholder="John" name="billingFirstName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Last Name</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Smith" name="billingLastName">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Address 1</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="1900 Appleseed Dr." name="billingAddress1">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Address 2 </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Apt 104" name="billingAddress2">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">City </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="Potomac" name="billingCity">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">State </label>
						<div class="col-sm-2">
							<input class="form-control" placeholder="VA" name="billingState">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Country </label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="United States of America" name="billingCountry">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ZIP Code</label>
						<div class="col-sm-4">
							<input class="form-control" placeholder="22152" name="billingZip">
						</div>
					</div>
				</div>
				<div class="panel-footer clearfix">
					<button class="btn btn-default" type="button" onclick="cancel()">Cancel</button>
					<button class="btn btn-primary pull-right" type="button" id="submitButton">Confirm Reservation</button>
				</div>
			</div>
						</form>
	</div>


	<jsp:include page="/Footer.jsp" />
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

				var creditCardNumber = $("#creditCardNumbr").val();
				var creditCardCVV  = $("#creditCardCVV").val();
				var totalCost = $("#price").val();
				alert("Before Get");
			    $.get("../Banking/BankServlet", {creditCardNumber:creditCardNumber, CVV:creditCardCVV, totalCost:totalCost}, function(data,status) {
			    	alert(data);
			    	$("#results").html(data);
			    });
			    alert("After Get");
				//form.action="ReservationTransactionConfirmation.jsp";
				//form.submit();
			}
			
			$("#submitButton").click(function(){
				var creditCardNumber = $("#creditCardNumber").val();
				var creditCardCVV  = $("#creditCardCVV").val();
				var totalCost = $("#totalPrice").text();

			    $.get("../Banking/Bank", {creditCardNumber:creditCardNumber, CVV:creditCardCVV, totalCost:totalCost}, function(data,status) {
			    	alert(data);
			    	$("#results").html(data);
			    });
			    
			    $("#makeReservation").show();

			});
			</script>
</body>
</html>