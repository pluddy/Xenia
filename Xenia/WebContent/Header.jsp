<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<link rel='stylesheet' href='webjars/bootstrap-datepicker/1.6.0/dist/css/bootstrap-datepicker.min.css'>
<link rel='stylesheet' href='webjars/bootstrap-star-rating/3.5.4/css/star-rating.min.css'>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="CustomerHomepage.jsp">Xenia</a>
		</div>
		<div class="collapse navbar-collapse">
			<c:if test="${user != null}">
				<ul class="nav navbar-nav">
					<li>
						<a href="ManageReservation">Manage</a>
					</li>
				</ul>
				<ul class="nav navbar-nav">
					<li>
						<a href="Client/ClientHomepage.jsp">Client Homepage</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<form class="form" action="ShoppingCart.jsp">
							<button type="submit" class="btn btn-default navbar-btn">
								<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								<c:if test="${shoppingCart.getReservations().size() > 0}">
									<span class="badge">
										<c:out value="${shoppingCart.getReservations().size()}"></c:out>
									</span>
								</c:if>
							</button>
						</form>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${user.getFirstName() }"></c:out> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<a href="UpdatePassword.jsp">Change Password</a>
							</li>
							<li role="separator" class="divider"></li>
							<li>
								<a href="Logout">Logout</a>
							</li>
						</ul>
					<li>
				</ul>
			</c:if>
			<c:if test="${user == null}">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="Login">Login</a>
					</li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>