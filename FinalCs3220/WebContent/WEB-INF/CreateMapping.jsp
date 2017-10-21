<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Course Mapping</title>
</head>
<body>

<form id="newMapping" action="CreateMapping" method="post">

<table border="1">
<tr><th>Quarter Courses</th><th>Semester Courses</th></tr>
	<tr>
	      	<td>
	      		<c:forEach items="${entries}" var="entry">
	      		<c:if test="${entry.courseType == 'Quarter'}">
	      			<li>${entry.name}<input type="radio" name="mapQ" value="${entry.name}" /></li>
	    		</c:if>
	    		</c:forEach>  
	      	</td>
	      	<td>
	      	<c:forEach items="${entries}" var="entry">
	      		<c:if test="${entry.courseType == 'Semester'}">
	      			<li>${entry.name}<input type="radio" name="mapS" value="${entry.name}" /></li>
	    		</c:if>
	    		</c:forEach>  
	      	</td>
	      </tr>  
</table>

<input type="submit" name="submit" value="Create Mapping" /></p>

</form>

</body>
</html>