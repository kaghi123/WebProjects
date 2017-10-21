<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Courses</title>
</head>
<body>
<p><a href="AddCourse">Add Course</a> | <a href="CreateMapping">Create Course Mapping</a></p>
<table border="1">
<tr><th>Quarter Courses</th><th>Semester Courses</th><th>Course Mappings</th></tr>
	
  		
    		
	      <tr>
	      	<td>
	      		<c:forEach items="${entries}" var="entry">
	      		<c:if test="${entry.courseType == 'Quarter'}">
	      			<li>${entry.name}</li>
	    		</c:if>
	    		</c:forEach>  
	      	</td>
	      	<td>
	      	<c:forEach items="${entries}" var="entry">
	      		<c:if test="${entry.courseType == 'Semester'}">
	      			<li>${entry.name}</li>
	    		</c:if>
	    		</c:forEach>  
	      	</td>
	      	<td>
	      	<c:forEach items="${entries}" var="entry">
	      		<c:if test="${entry.name == 'hello' }">
	      			<li>${entry.name}</li>
	    		</c:if>
	    		</c:forEach>  
	      	</td>
	      </tr>
	      
    	 
      
</table>
</body>
</html>