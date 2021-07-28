<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
	<title>Admin Dashboard</title>
	</head>
	<body>
		<b>Admin ID: </b> ${AdminId}
		<br>
		<b>Email ID: </b> ${EmailId}
		<center>
			<h1>Welcome ${Name} <h1>
			<table>
				<tr>
					<td>
						<a href="/admin/signup">Add new admin</a>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/course/add">Add new course</a>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/user/listAllUsers" target="_self">List all Users</a>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/admin/viewall" target="_self">List all admins</a>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/course/listAllCourse" target="_self">List all Course</a>
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/admin/delete/${AdminId}" target="_self">Delete my Account</a>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>