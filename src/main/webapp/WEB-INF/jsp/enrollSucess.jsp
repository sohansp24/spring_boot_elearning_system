<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<script language="JavaScript"> 
		alert("Enrollment Sucess\nClick OK to go back");
		const queryString = window.location.search;
		console.log(queryString);
		const urlParams = new URLSearchParams(queryString);
		const Uid = urlParams.get('uid');
		const url=("/course/listAllCourse/user/${Uid}");
		window.location.href = url;
		</script>
	</head>
</html>