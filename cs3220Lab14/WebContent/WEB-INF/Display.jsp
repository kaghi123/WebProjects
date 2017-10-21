<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DrivingTest</title>
</head>
<body>
	<p>${desc}<br>
	<form id="question "action="DrivingTestBrowser" method="get">
		1. ${a}<input type="radio" name="uanswer" value="a"><br>
		2. ${b}<input type="radio" name="uanswer" value="b"><br>
		3. ${c}<input type="radio" name="uanswer" value="c"><br><br></p>
		<c:if test="${index < 9 }"><button type="submit" form="question" value="Submit">Next</button></c:if>
		<c:if test="${index == 9 }"><button type="submit" form="question" value="Submit">Finish</button></c:if>
	</form>
	
	
	<!-- Correct answer: ${answer}<br><br> 
	
	
	-->
	
</body>
</html>