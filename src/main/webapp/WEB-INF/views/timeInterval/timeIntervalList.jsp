<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
	
	
		<div>

			<h1>TimeInterval List</h1>

			<table id="hovertable" class="hoverable">
				<thead>
				<tr>
					<th>Start Time</th>
					<th>Date</th>
					
					
				</tr>
				</thead>
				<c:forEach items="${timeIntervals}" var="timeInterval">
					<tr class="hoverable" id="id${timeInterval.id}" onClick="document.location.href = 'getTimeInterval?timeIntervalId=${timeInterval.id}';">
						<td>${timeInterval.startTime}</td>
						<td>${timeInterval.date}</td>
					
						
					</tr>
				</c:forEach>
			</table>
			<br/>
			<a href="newTimeInterval">Add TimeInterval</a>

			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

		 </div>
	 </body>
 </html>