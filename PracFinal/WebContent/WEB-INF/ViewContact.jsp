<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Contact</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(function(){
    $("#add").click(function(){
    	$(".input").replaceWith(function(){
    		   return "<span>" + this.value + "<span>" 
    		});
    	
    	$(".new").html("<td><input class='input' type='text' name='field' />" +
    		"</td><td><input class='input' type='text' name='field_entry' /></td>" +
    		"<td><button class='input' id='add'>Add</button></td>");
    	
    });
});
</script>

</head>
<body>

<c:forEach items="${entries}" var="entry"> 
	<c:if  test="${entry.id == id }"> 
		<p><a href="ContactList">Contacts</a> - ${entry.name}</p> 
	</c:if>
</c:forEach>

<table border='1' cellpadding='2'>
	<c:forEach items="${entries}" var="entry"> 
        <c:if test="${id == entry.id}"> 
	<tr>
		<td>Name:</td><td>${entry.name}</td><td></td>
	</tr>
	<tr>	
		<td>Phone: </td><td>${entry.number}</td><td></td>
	</tr>
	
	<tr>
	
		<td><input class="input" type="text" name="field" /></td>
		<td><input class="input" type="text" name="field_entry" /></td>
		<td><button class="input" id="add">Add</button></td>
			
	</tr>
	
	<tr class="new"></tr>
	
        </c:if>
    </c:forEach>
</table>

</body>
</html>