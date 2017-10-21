<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Course</title>
</head>
<body>


	<form id="newCourse" action="AddCourse" method="post">
		<p>Course: <input type="text" name="name" />
		
		<select name='courseType'>
			<option>Quarter</option>
			<option>Semester</option>
		</select>
		
		<input type="submit" name="submit" value="Add" /></p>
	</form>

</body>
</html>