<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Folder</title>
</head>
<body>

<c:forEach items="${entries}" var="entry"> 
<c:if  test="${entry.id == id }"> 
	<c:if  test="${entry.parentId == 1 }"> 
		<p><a href="FileManager"> ..\\</a> ${entry.name} [ 
		<a href="CreateFolder?id=${entry.id}" >New Folder</a> | 
		<a href="Upload">Upload</a>]</p> 
	</c:if>
	
	<c:if test="${entry.parentId != 1 }"> 
		<p><a href="ViewFolder?id=${entry.parentId}" > ..\\</a> ${entry.name} [ 
		<a href="CreateFolder?id=${entry.id}" >New Folder</a> | 
		<a href="Upload">Upload</a>]</p> 
	</c:if>
</c:if>
</c:forEach>
	
<table border='1' cellpadding='2'>
	<tr>
		<th>Name</th><th>Date</th><th>Size</th><th>Operations</th>
	</tr>
	<c:forEach items="${entries}" var="entry"> 
        <c:if test="${mainId == entry.parentId}"> 
	<tr>
		<td><a href="ViewFolder?id=${entry.id}">${entry.name}</a></td>
		<td></td>
		<td></td>
		<td><a href="EditFolder?id=${entry.id}">Rename</a> | <a href="DeleteFolder?id=${entry.id}">Delete</a></td>
	</tr>
        </c:if>
    </c:forEach>
</table>


</body>
</html>