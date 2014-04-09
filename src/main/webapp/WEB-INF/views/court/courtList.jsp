<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>

			<h1>Court List</h1>

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
						
						
					</tr>
				</c:forEach>
			</table>
			<br/>
			<a href="newCourt">Add Court</a>

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 </body>
 </html>