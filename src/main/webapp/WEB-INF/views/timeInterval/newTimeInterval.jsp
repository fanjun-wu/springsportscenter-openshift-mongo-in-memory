<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
		<div>
		
			<h1>New TimeInterval</h1>
			
			
			<form:form name="newTimeIntervalForm" commandName="timeInterval" action="saveTimeInterval" method="post">
				<jsp:include page="/WEB-INF/views/includes/timeInterval/timeIntervalDetails.jsp" />
				<br/>
				<a href="timeIntervalList">Back to list</a>&nbsp;&nbsp;&nbsp;
				<a href="javascript: document.forms.newTimeIntervalForm.submit();">Create new timeInterval</a>&nbsp;&nbsp;&nbsp;
			</form:form>
			
			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
		 </div>
	 </body>
 </html>