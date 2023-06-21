<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Student
		RegistrationForm</h1>
	<form action="register" method="POST">
		<table align="center" bgcolor="blue">
			<tr>
				<td>Student Number</td>
				<td><input type="text" name="sno"></td>
			<tr />
			<tr>
				<td>Student Name</td>
				<td><input type="text" name="sname"></td>
			<tr />
						
						
						
			<tr>
				<td>Student Address</td>
				<td><input type="text" name="saddrs"></td>
			<tr />
			<tr>
			<tr>
				<td>Student Average</td>
				<td><input type="text" name="savg"></td>
			<tr />
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>