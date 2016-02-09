<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Login</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container">
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
	<div class="container">

		<h1>Login</h1>

		<form class="form-horizontal" action="Login" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-4">
					<input type="username" class="form-control" placeholder="Username"
						name="username" id="username">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" placeholder="Password"
						name="password" id="password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> Remember me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary disabled" id="signinButton">Sign in</button>
				</div>
			</div>
		</form>

		<form class="form" action="Register.jsp">
			<button class="btn btn-default" type="submit">Register</button>
		</form>
	</div>
	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	var userValid = false;
	$("#username,#password").on('keyup click', function(){
		if ($("#username").val().length != 0 && $("#password").val().length != 0) {
			$("#signinButton").removeClass("disabled");
			userValid = true;
		} else {
			$("#signinButton").addClass("disabled");
			userValid = false;
		}
	});
	
	$('#registerform').on('keyup keypress', function(e) {
		  var keyCode = e.keyCode || e.which;
		  if (keyCode === 13 && !userValid) { 
		    e.preventDefault();
		    return false;
		  }
		});
	</script>
	
</body>
</html>