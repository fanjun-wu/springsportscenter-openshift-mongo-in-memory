<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>

			<h1>Subscriber List</h1>

			<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Subscriber Name</th>
					<th>Email</th>
					<th>Telephone</th>
					<th>Gender</th>
					<th>Age</th>
					 <th>AuthenKey</th> 
					
				</tr>
				</thead>
				<c:forEach items="${subscribers}" var="subscriber">
					<tr class="hoverable" id="id${subscriber.id}" onClick="document.location.href = 'getSubscriber?subscriberId=${subscriber.id}';">
						<td>${subscriber.name}</td>
						<td>${subscriber.email}</td>
						<td>${subscriber.telephone}</td>
						<td>${subscriber.gender}</td>
						<td>${subscriber.age}</td>
						<td>${subscriber.authenKey}</td>
						<td><a href="showReservationList?subscriberId=${subscriber.id}">Reservation Management</a></td>
					
						
					</tr>
				</c:forEach>
			</table>
			<br/>
			<a href="newSubscriber">Add Subscriber</a>

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 </body>
 </html>