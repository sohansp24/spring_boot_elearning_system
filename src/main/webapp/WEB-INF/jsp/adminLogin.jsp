<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<title>Admin Login Page</title>
	</head>
	<body>
	<center>
	<h1>Admin Registeration Page</h1><br><br><br>
	<s:form  method="POST" modelAttribute="admin" action="/admin/validation">
	<table>
		<tr>
			<td>EMail ID</td>
			<td>
				<s:input path="EmailId" />
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr></tr>
		<tr>
			<td>Password</td>
			<td>
				<s:input path="Password" />
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr></tr>
		<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="Login" />
				</td>
		</tr>
	</table>
	</s:form>
	</center>
</html>