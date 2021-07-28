<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
	<title>User Dashboard</title>
	</head>
	<body>
		</b>User ID: </b> ${Uid}
		<br>
		</b>Email ID: </b> ${EmailId}
		<center>
			<h1>Welcome ${Name} <h1>
			<table>
				<tr>
					<td>
						<a href="/course/listAllCourse/user/${Uid}" target="_self">List all Course</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="/course/enrolledCourses/${Uid}" target="_self">List all enrolled Course</a>
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>
						<a href="/user/delete/${Uid}" target="_self">Delete my Account</a>
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>