<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>
		
			<h1>Hall List</h1>
			
		 <table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Hall Name</th>
					<th>Open Time</th>
					<th>Close Time</th>
					<th>Description</th>
				</tr>
				</thead>
				<c:forEach items="${halls}" var="hall">
				 <tr class="hoverable" id="id${hall.id}" onClick="document.location.href = 'getHall?hallId=${hall.id}';"> 
					
						<td>${hall.name}</td>
						<td>${hall.openTime}</td>
						<td>${hall.closeTime}</td>
						<td>${hall.introduction}</td>
						<td><a href="hallCourtList?hallId=${hall.id}">Add Court</a></td>
						<td><a href="showhallCourtList?hallId=${hall.id}">Court List</a></td>
						
					</tr>
				</c:forEach> 
				
					
				
				
			</table>
			<br/>
		 <a href="newHall">Add Hall</a>  
			
			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
		 </div>
	 </body>
 </html>