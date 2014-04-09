<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of College</title>
</head>
<body>
<form:form action="Allcollege" method="GET" > 



<table border="1">
	
	<th>ID</th>
	<th>Name</th>
	
	
	<c:forEach items="${collegeList}" var="college">
		<tr>
			<td>${college.collegeId}</td>
			<td>${college.collegeName}</td>

	<td><%= request.getParameter("id")%> </td>
	<%-- <c:set var="salary" scope="session" value="<%= request.getParameter("id")%>"/> --%>
<c:url var="JoinCollegeUrl2" value="/add?id=4&c_id=${college.collegeId}" />
				
				<td><a href="${JoinCollegeUrl2}">+</a></td>
				
				
		</tr>
	</c:forEach>
</table>

</form:form> 

</body>
</html>