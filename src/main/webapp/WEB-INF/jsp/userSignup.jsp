<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
	<head><title>User Registeration</title> 
	</head>
	<body>
	<center>
	<h1>User Registeration Page</h1><br><br><br>
		<s:form  method="POST" modelAttribute="user" action="/user/save">
			<table border="0" cellpadding="2" cellspacing="2">
				<tr>
					<td>Name</td>
					<td>
						<s:input path="Name" />
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Phone Number</td>
					<td>
						<s:input path="PhoneNumber" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>EMail ID</td>
					<td>
						<s:input path="EmailId" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Address</td>
					<td>
						<s:input path="Address" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
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
							<input type="submit" value="Save" />
						</td>
				</tr>
			</table>
		</s:form>
	</center>
	</body>
</html>