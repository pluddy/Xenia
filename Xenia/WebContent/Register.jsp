<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet'
	href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<title>Register</title>
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

		<h1>Register</h1>

		<form class="form-horizontal" action="Register" method="post" id="registerform">
			<div class="form-group" id="usernamegroup">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="Username"
						name="username" id="username">
				</div>
			</div>
			<div class="form-group" id="passwordgroup1">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" placeholder="Password"
						name="password" id="password">
				</div>
			</div>
			<div class="form-group" id="passwordgroup2">
				<label for="inputPassword3" class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" placeholder="Password"
						name="confirmPassword" id="confirmPassword">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default disabled" id="registerButton">Register</button>
				</div>
			</div>
		</form>
	</div>
		<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
	var usernameValid = false;
	var passwordValid = false;
	$('#username').on('keyup click', function() {
		if ($('#username').val().length != 0) {
			$('#usernamegroup').removeClass("has-error");
			$('#usernamegroup').addClass("has-success");
			usernameValid = true;
		} else {
			$('#usernamegroup').removeClass("has-success");
			$('#usernamegroup').addClass("has-error");
			usernameValid = false;
		}
	});
	$('#password,#confirmPassword').on('keyup click', function() {
		if ($('#password').val().length != 0 &&
				$('#confirmPassword').val().length != 0 &&
				$('#password').val() == $('#confirmPassword').val()) {
			$('#passwordgroup1,#passwordgroup2').addClass("has-success");
			$('#passwordgroup1,#passwordgroup2').removeClass("has-error");
			$('#registerButton').removeClass("disabled");
			passwordValid = true;
		} else {
			$('#passwordgroup1,#passwordgroup2').addClass("has-error");
			$('#passwordgroup1,#passwordgroup2').removeClass("has-success");
			$('#registerButton').addClass("disabled");
			passwordValid = false;
		}
	});
	
	$('#registerform').on('keyup keypress', function(e) {
		  var keyCode = e.keyCode || e.which;
		  if (keyCode === 13 && (!usernameValid || !passwordValid)) { 
		    e.preventDefault();
		    return false;
		  }
		});
	</script>
</body>
</html>