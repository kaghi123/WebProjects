<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Folder</title>
</head>
<body>


<c:forEach items="${entries}" var="entry"> 
	<c:if  test="${entry.id == id }">
		<form id="newFolder" action="CreateFolder" method="post">
		<p><input type="text" name="folderName" />
		<input type="hidden" name="id" value="${entry.id}"/>
		<input type="submit" name="submit" value="Create Folder" /></p>
		</form>
	</c:if>
</c:forEach>

</body>
</html>