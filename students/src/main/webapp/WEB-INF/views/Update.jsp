<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>

	<c:choose>

		<c:when test="${student != null }">

			<fieldset>
				<legend>:::Update Student:::</legend>
				<form action="./updateData" method="post">
					<table>
						<tr hidden="true">
							<td>ID</td>
							<td><input type="hidden" value="${student.id }" name="id"></td>
						</tr>
						<tr>
							<td>Name</td>
							<td><input type="text" value="${student.name }" name="name"></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" value="${student.email }"
								name="email"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Update"></td>
						</tr>
					</table>
				</form>
			</fieldset>
		</c:when>
		<c:otherwise>

			<c:if test="${msg != null }">

				<h3 align="center">${msg}</h3>

			</c:if>

		</c:otherwise>


	</c:choose>
	
	

	<div align="center">
	<c:if test="${student == null }">
		<table border="1" cellpadding="10">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>

			</tr>
			<c:forEach items="${students }" var="student" varStatus="status">

				<tr>
					<td>${student.id}</td>
					<td>${ student.name}</td>
					<td>${ student.email}</td>

				</tr>

			</c:forEach>

		</table>
		</c:if>
	</div>

</body>
</html>