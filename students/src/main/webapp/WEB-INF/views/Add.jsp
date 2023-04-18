<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="NavBar.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
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
	<fieldset>
		<legend>:::Add Student Details:::</legend>
		<form action="./add" method="post">
			<table >
				<tr>
					<td>id :</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email" name="email"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<c:if test="${msg != null }">

		<h3 align="center">${msg}</h3>

	</c:if>

</body>
</html>