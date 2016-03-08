<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<jsp:include page="/Header.jsp" />
	<div class="container">

		<h1>Register</h1>

		<form class="form-horizontal" action="Register" method="post" id="registerform">
			<div class="form-group" id="usernamegroup">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" placeholder="Username" name="username" id="username">
				</div>
			</div>
			<div class="form-group" id="passwordgroup1">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" placeholder="Password" name="password" id="password">
				</div>
			</div>
			<div class="form-group" id="passwordgroup2">
				<label for="inputPassword3" class="col-sm-2 control-label">Confirm Password</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" placeholder="Password" name="confirmPassword" id="confirmPassword">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="John" name="firstname" id="firstname">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name</label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="Smith" name="lastname" id="lastname">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Address 1</label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="1900 Appleseed Dr." name="address1" id="address1">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Address 2 </label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="Apt 104" name="address2" id="address2">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">City </label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="Potomac" name="city" id="city">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">State </label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="VA" name="state" id="state">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">ZIP Code</label>
				<div class="col-sm-6">
					<input class="form-control" placeholder="22152" name="zip" id="zip">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default disabled" id="registerButton">Register</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/Footer.jsp" />
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
		$('#password,#confirmPassword').on(
				'keyup click',
				function() {
					if ($('#password').val().length != 0
							&& $('#confirmPassword').val().length != 0
							&& $('#password').val() == $('#confirmPassword')
									.val()) {
						$('#passwordgroup1,#passwordgroup2').addClass(
								"has-success");
						$('#passwordgroup1,#passwordgroup2').removeClass(
								"has-error");
						$('#registerButton').removeClass("disabled");
						passwordValid = true;
					} else {
						$('#passwordgroup1,#passwordgroup2').addClass(
								"has-error");
						$('#passwordgroup1,#passwordgroup2').removeClass(
								"has-success");
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