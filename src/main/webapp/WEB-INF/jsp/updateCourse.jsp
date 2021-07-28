<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
	<head><title>Course Registeration</title>
		<script language="JavaScript">
		function temp(){
			var url="/course/updateSave/"+${cid};
			document.frm1.action = url;
		}
		</script>
	</head>
	<body onload="temp()">
	<center>
	<h1>Course Registeration Page</h1><br><br><br>
		<s:form  name="frm1" id="frm1" method="GET"  modelAttribute="course" action= "javascript:temp();">
			<table border="0" cellpadding="2" cellspacing="2">
				<tr>
					<td>Course Name</td>
					<td>
						<s:input path="CourseName" />
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Course Fee</td>
					<td>
						<s:input path="CourseFee"/>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Course Description</td>
					<td>
						<s:input path="CourseDesc" />
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Course Resource</td>
					<td>
						<s:input path="CourseResource" />
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