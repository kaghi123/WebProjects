<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECST Faculty</title>
</head>
<body>
<h3>ECST Faculty</h3>
<p><a href="AddDepartment">Add Department</a> | <a href="AddFaculty">Add Faculty</a></p>
<table border="1">
<tr><th>Department</th><th>Faculty</th></tr>
<c:forEach items="${entriesD}" var="entriesD">
  <c:choose>
    <c:when test="${fn:length(entriesD.name) == 0}">
      <tr><td>${entriesD.name}</td><td></td></tr>
    </c:when>
    <c:otherwise>
      <tr>
        <td rowspan="${fn:length(entriesD.name)}">${entriesD.name}</td>
        <td>
          ${entriesF[0].name}
          <c:if test="${entriesF[0].chair}">(Chair)</c:if>
        </td>
      </tr>
      <c:forEach items="${entriesF}" var="entriesF" varStatus="status">
        <c:if test="${not status.first}">
        <tr>
          <td>
            ${entriesF.name}
            <c:if test="${entriesF.chair}">(Chair)</c:if>
          </td>
        </tr>
        </c:if>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</c:forEach>
</table>
</body>
</html>