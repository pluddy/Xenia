<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
</head>
<body>

	<jsp:include page="/Header.jsp" />
	<div class="container">

		<h1>Change Password</h1>

		<form class="form-horizontal" action="UpdatePassword" method="post" id="updatePasswordForm">
						<div class="form-group" id="usernamegroup">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" placeholder="Username" name="username" id="username">
				</div>
			</div>
			<div class="form-group" id="previousPasswordgroup">
				<label for="previousPassword" class="col-sm-2 control-label">Old Password</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" placeholder="Previous Password" name="previousPassword" id="previousPassword">
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
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default disabled" id="updatePasswordButton">Update Password</button>
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