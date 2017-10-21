<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty</title>
</head>
<body>
<p>ECST Faculty</p>
<br>
<p><a href="AddDepartment">Add Department</a> | <a href="AddFaculty">Add Faculty</a></p>

<table border="1" cellpadding="2">
    <tr>
        <th>Department</th><th>Faculty</th>
    </tr>
     <c:forEach items="${entries}" var="entry">
  <tr>
    <td>${entry.department}</td><td>${entry.name}<c:if test="${entry.isChairperson == true }"> (Chair) </c:if></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>