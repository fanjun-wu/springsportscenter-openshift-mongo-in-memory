<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<title>Home</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
<h1>
	Demo Spring on MongoDB
</h1>

<p>
	The following controllers are available:
	<ul>
		
		<li><a href="/SportReservation-MONGO/hallList">HallController</a></li>
		<li><a href="/SportReservation-MONGO/adminList">AdminController</a></li>
		<li><a href="/SportReservation-MONGO/courtList">CourtController</a></li>
		<li><a href="/SportReservation-MONGO/capabilityList">CapabilityController</a></li>
		<li><a href="/SportReservation-MONGO/reservationList">ReservationController</a></li>
		<li><a href="/SportReservation-MONGO/timeIntervalList">TimeIntervalController</a></li>
		<li><a href="/SportReservation-MONGO/subscriberList">SubscriberController</a></li>
		
	</ul>
</p>

<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>
