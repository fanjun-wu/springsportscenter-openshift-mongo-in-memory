<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Management</title>
</head>
<body>
<h1>College Data</h1>
<form:form action="college.do" method="POST" commandName="college">
	<table>
		<tr>
			<td>College ID</td>
			<td><form:input path="collegeId" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><form:input path="collegeName" /></td>
		</tr>
		
		
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>Name</th>
	<th>List</th>
	
	<c:forEach items="${collegeList}" var="college">
		<tr>
			<td>${college.collegeId}</td>
			<td>${college.collegeName}</td>
			<td>
				
				<c:forEach items="${studentList}" var="student">
				<td>
					<td>${student.firstname}</td>
				</td>
				
				</c:forEach>
			</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>