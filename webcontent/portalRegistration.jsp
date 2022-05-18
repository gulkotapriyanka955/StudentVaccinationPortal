<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: LightGreen;">
	<div align="center">
		<h1>Vaccination Registration Form</h1>
		<form action ="vaccinationRegistration" method ="post">
			<table style="with: 70%">
				<tr>
					<td>700 Number</td>
					<td><input type="text" name="ucmo_ID" pattern="700[0-9]{6}" title="starts with 700 followed by 6 digits" required/></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" required /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" required /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" name="department" /></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><input type="text" name="contactNumber" pattern="[0-9]{10}" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="emailId" pattern=".+@ucmo.edu$" title=" @ucmo.edu" required/></td>
				</tr>
				<tr>
					<td>Set Password</td>
					<td><input type="password" name="password" required /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>