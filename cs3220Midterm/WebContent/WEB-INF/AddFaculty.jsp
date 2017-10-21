<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Faculty</title>
</head>
<body>
<p><a href="ECSTFaculty">ECST Faculty</a> > Add Faculty</p>

<table border="1" cellpadding="2">
<form action="AddFaculty" method="post">
    <tr>
        <th>Department:</th>
        <td>
        	<select name="department">
    			<c:forEach items="${dEntries}" var="dEntry">
					<option>${dEntry}</option>
				</c:forEach>
			</select>
       </td>
    </tr>
    <tr>
        <th>Name:</th>
        <td><input type="text" name="name" value="" /></td>
    </tr>
    <tr>
        <th>Chairperson:</th>
        <td><input name=“chairperson” type="checkbox" ></td>
    </tr>
    <tr>
    	<td>
        	<input type="submit" name="add"  value="Add" />
    	</td>
    </tr>
</form>
</table>

</body>
</html>