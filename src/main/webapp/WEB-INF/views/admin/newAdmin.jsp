<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
	<body>
	<jsp:include page="/WEB-INF/views/includes/logo.jsp" />
		<div>
		
			<h1>New Admin</h1>
			
			
			<form:form name="newAdminForm" commandName="admin" action="saveAdmin" method="post">
				<jsp:include page="/WEB-INF/views/includes/admin/adminDetails.jsp" />
				<br/>
				<a href="adminList">Back to list</a>&nbsp;&nbsp;&nbsp;
				<a href="javascript: document.forms.newAdminForm.submit();">Create new admin</a>&nbsp;&nbsp;&nbsp;
			</form:form>
			
			<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
		
		 </div>
	 </body>
 </html>