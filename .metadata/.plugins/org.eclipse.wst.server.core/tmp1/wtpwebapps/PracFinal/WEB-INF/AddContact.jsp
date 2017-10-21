<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact</title>
</head>
<body>

<table border='1' cellpadding='2'>
<form id="newContact" action="AddContact" method="post">
	<tr>
		<p><td>Name:</td><td><input type="text" name="name" /></td></p>
	</tr>
	<tr>	
		<p><td>Phone: </td><td><input type="text" name="number" /></td></p>
	</tr>
	<tr>	
		<p><td colspan=2 align="center" ><input type="submit" name="submit" value="Add Contact" /></td></p>
	</tr>
</form>
</table>
	

</body>
</html>