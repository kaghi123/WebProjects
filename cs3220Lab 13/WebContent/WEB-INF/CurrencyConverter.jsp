<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CurrencyConverter</title>
</head>
<body>
	<form action='CurrencyConverter' method='post'>
		<input type='text' name='initValue' />
		<select name='convertFrom'>
		<c:forEach items="${data.keySet()}" var="entry">
			<option>${entry}</option>
		</c:forEach>
		</select>

		= ?

		<select name='convertTo'>
		<c:forEach items="${data.keySet()}" var="entry">
			<option>${entry}</option>
		</c:forEach>
		</select>

		<input type='submit' name='convert' value='Convert' />
	</form>

</body>
</html>