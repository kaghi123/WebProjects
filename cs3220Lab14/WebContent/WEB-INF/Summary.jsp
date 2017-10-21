<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driving Test</title>
</head>
<body>
<table border="1">
  <tr><th>Question</th><th>Correct Answer</th><th>Your Answer</th></tr>
  <c:forEach items="${entries}" var="entry">
  <tr>
    <td></td><td>${entry.correctAnswer}</td><td></td>
  </tr>
  </c:forEach>
  </table>
  
  Your score: 
  
  <a href="DrivingTestBrowser">Start Over</a>

</body>
</html>