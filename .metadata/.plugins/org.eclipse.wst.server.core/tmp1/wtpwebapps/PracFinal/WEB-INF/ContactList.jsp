<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Contact List</title>
</head>
<body>
	<h2>Contacts</h2>
	<p><a href="AddContact?">Add Contact</a>
	
	<table border="1">
	
	<c:forEach items="${entries}" var="entry"> 
	<tr>
		<th>${fn:substring(entry.name, 0, 1)}</th>
	</tr>
	<tr>
		<td><a href="ViewContact?id=${entry.id}">${entry.name}</a></td>
		<td>${entry.number}</td>
	</tr>
    </c:forEach>
</table>
</body>
</html>


//make the top like the bottom, sort through letters first and the put the names under the letter


<table border="1">
<tr><th>Department</th><th>Faculty</th></tr>
<c:forEach items="${letter}" var="letter">
  <c:choose>
    <c:when test="${fn:length(department.faculty) == 0}">
      <tr><td>${department.name}</td><td></td></tr>
    </c:when>
    <c:otherwise>
      <tr>
        <td rowspan="${fn:length(department.faculty)}">${department.name}</td>
        <td>
          ${department.faculty[0].name}
          <c:if test="${department.faculty[0].chair}">(Chair)</c:if>
        </td>
      </tr>
      <c:forEach items="${department.faculty}" var="faculty" varStatus="status">
        <c:if test="${not status.first}">
        <tr>
          <td>
            ${faculty.name}
            <c:if test="${faculty.chair}">(Chair)</c:if>
          </td>
        </tr>
        </c:if>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</c:forEach>
</table>