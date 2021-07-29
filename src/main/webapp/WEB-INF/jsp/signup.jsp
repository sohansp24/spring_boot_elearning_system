<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
	<head><title>Admin Registeration</title> 
	</head>
	<body>
	<center>
	<h1>Admin Registeration Page</h1><br><br><br>
		<s:form  method="POST" modelAttribute="admin" action="/admin/save">
			<table border="0" cellpadding="2" cellspacing="2">
				<tr>
					<td>Name</td>
					<td>
						<s:input path="Name" required="required"/>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>EMail ID</td>
					<td>
						<s:input path="EmailId" type="email" required="required"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Password</td>
					<td>
						<s:input path="Password" type="password" required="required"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
						<td>&nbsp;</td>
						<td>
							<input type="submit" value="Save" />
						</td>
				</tr>
			</table>
		</s:form>
	</center>
	</body>
</html>