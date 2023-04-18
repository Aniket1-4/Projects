<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="NavBar.jsp" />


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
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

	<div align="center">

		<h1>Students Data</h1>
		
		<h3><a href="./add">Add</a></h3>
		<h3><a href="./search">Search</a></h3>

		<table border="1" cellpadding="10">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>
			
			</tr>
			<c:forEach items="${students }" var="student" varStatus="status">

				<tr>
					<td>${student.id}</td>
					<td>${ student.name}</td>
					<td>${ student.email}</td>
					<td>
					<a href="update?id=${student.id }">Update</a>
					<a href="remove?id=${student.id }">Delete</a>
					</td>
				</tr>

			</c:forEach>

		</table>

	</div>

</body>
</html>