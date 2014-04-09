<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Teacher Manager
</h1>

Show the list of teachers from MongoDB:

<table border="1">
	
	<th>Name</th>
	<th>Area</th>
	<th>Age</th>
	
	<c:forEach items="${teacherList}" var="data">
		<tr>
			<td>${data.username}</td>
			<td>${data.area}</td>
			<td>${data.age}</td>
			<td><input type="button" value="delete" onclick="window.location='teacher/delete?id=${data.id}'"/></td>
			
		</tr>
	</c:forEach>
</table>



<br/>
<a href="./addTeacher">Add a new teacher</a>
</body>
</html>
