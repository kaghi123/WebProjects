<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form id="login" action="Login" method="post">
		<p>Username: <input type="text" name="user" value=""/></p>
		<p>Password: <input type="text" name="pass" value=""/></p>
		<p><input type="submit" name="submit" value="Login" /></p>
	</form>
	
	<p><a href="CreateAccount">Create Account</a></p>
	
</body>
</html>