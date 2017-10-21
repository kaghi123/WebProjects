<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Folder</title>
</head>
<body>

<c:forEach items="${entries}" var="entry"> 
	<c:if  test="${entry.id == id }">
		<form action="EditFolder" method="post">
		<p><input type="text" name="folderName" value="${entry.name}"/>
		<input type="hidden" name="id" value="${entry.id}" />
		<input type="submit" name="save" value="Save" />
		</p></form>
	</c:if>
</c:forEach>
</body>
</html>