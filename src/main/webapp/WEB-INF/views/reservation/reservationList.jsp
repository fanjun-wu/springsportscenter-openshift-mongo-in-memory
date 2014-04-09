<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>

			<h1>Reservation List</h1>

			<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Discription</th>
					<th>Tips</th>
					
					
				</tr>
				</thead>
				<c:forEach items="${reservations}" var="reservation">
					<tr class="hoverable" id="id${reservation.id}" onClick="document.location.href = 'getReservation?reservationId=${reservation.id}';">
						<td>${reservation.discription}</td>
						<td>${reservation.tips}</td>
						<td><a href="showTimeIntervalList?reservationId=${reservation.id}">Add TImeInterval</a></td>
					
						
					</tr>
				</c:forEach>
			</table>
			<br/>
			<a href="newReservation">Add Reservation</a>

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 </body>
 </html>