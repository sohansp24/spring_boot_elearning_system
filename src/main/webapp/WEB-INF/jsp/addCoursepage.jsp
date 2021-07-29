<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
	<head><title>Course Registeration</title> 
	</head>
	<body>
	<center>
	<h1>Course Registeration Page</h1><br><br><br>
		<s:form  method="POST" modelAttribute="course" action="/course/addCourse">
			<table border="0" cellpadding="2" cellspacing="2">
				<tr>
					<td>Course Name</td>
					<td>
						<s:input path="CourseName" required="required"/>
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Course Fee</td>
					<td>
						<s:input path="CourseFee" required="required"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Course Description</td>
					<td>
						<s:input path="CourseDesc" required="required"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Course Resource</td>
					<td>
						<s:input path="CourseResource" required="required"/>
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