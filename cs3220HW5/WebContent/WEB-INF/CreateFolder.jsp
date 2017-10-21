<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Folder</title>
</head>
<body>



<c:forEach items="${entries}" var="entry"> 
	<c:if  test="${entry.id == id && entry.accId == acId}">
		<form id="newFolder" action="CreateFolder" method="post">
		<p><input type="text" name="folderName" />
		<input type="hidden" name="id" value="${entry.id}"/>
		<input type="hidden" name="accId" value="${entry.accId}"/>
		<input type="submit" name="submit" value="Create Folder" /></p>
		</form>
	</c:if>
</c:forEach>

</body>
</html>