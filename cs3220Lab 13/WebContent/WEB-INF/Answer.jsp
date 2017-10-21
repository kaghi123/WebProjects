<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CurrencyConverter</title>
</head>
<body>
<p>${initValue} ${convertFrom} = <fmt:formatNumber value="${value}" pattern="0.###" /> ${convertTo}</p>


<p><a href='CurrencyConverter'>Back</a></p>
</body>
</html>