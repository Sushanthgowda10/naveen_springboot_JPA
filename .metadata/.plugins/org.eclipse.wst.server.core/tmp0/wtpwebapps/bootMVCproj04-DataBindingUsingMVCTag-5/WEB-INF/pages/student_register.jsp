<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:blue;text-align:center">student registration form</h1>	
 <frm:form modelAttribute="stud">
	
	
	
	
	
	

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
</frm:form>