<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Manager</title>
</head>
<body>
<p align="right"><a href="Logout">Logout</a></p>


<p>[<a href="CreateFolder?id=1&accId=${acId}">New Folder</a> |<a href="Upload?accId=${acId}">Upload</a>]</p>
		


<table border='1' cellpadding='2'>
	<tr>
		<th>Name</th><th>Date</th><th>Size</th><th>Operations</th>
	</tr>
	<c:forEach items="${entries}" var="entry"> 
        <c:if test="${entry.parentId == 1 && entry.accId == acId}">
	<tr>
		<td><a href="ViewFolder?id=${entry.id}&accId=${entry.accId}">${entry.name}</a></td>
		<td></td>
		<td></td>
		<td><a href="EditFolder?id=${entry.id}&accId=${entry.accId}">Rename</a> | <a href="DeleteFolder?id=${entry.id}&accId=${entry.accId}">Delete</a></td>
	</tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>