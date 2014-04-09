<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="/WEB-INF/views/includes/header.jsp" />
<body>

<h1>Add Court for hall(${hall.name})</h1>

<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Court Name</th>
					<th>Introduction</th>
					
				</tr>
				</thead>
				<c:forEach items="${courts}" var="court">
					<tr class="hoverable" id="id${court.id}" onClick="document.location.href = 'getCourt?courtId=${court.id}';">
						<td>${court.name}</td>
						<td>${court.introduction}</td>
						<td><a href="hallAddCourt?hallId=${hall.id}&courtId=${court.id}">Add</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="hallList">Go Back to Hall List</a>


</body>
</html>