<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

				<table>
					<tr>
						<td>Start Time</td>
						<td>
							<form:input type="hidden" path="id" value="${timeInterval.id}"/>
							<form:input type="text" path="startTime" value="${timeInterval.startTime}"/>
						</td>
					</tr>
					
					<tr>
						<td>Date</td>
						<td>
							<form:input type="date" path="date" value="${timeInterval.date}"/>
						</td>
					</tr>
					
					
					
					
				</table>