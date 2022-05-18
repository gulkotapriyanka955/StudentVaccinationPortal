<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:PowderBlue  ;">
<div align="center">
<p>${result}</p>
Welcome ${student.firstName}
<br><br>
<form action="userDetails" method="post">
<input type="text" hidden="true" name="emailId" value="${student.emailId}" >
<input type="text" name="student_ID" value="${student.student_ID}" hidden="true">
<br><button type="submit">Update my Info </button><br><br>
</form>
<form action="appointmentPage" method="post">
<input type="text" name="student_ID" value="${student.student_ID}" hidden="true">
<input type="text" hidden="true" name="emailId" value="${student.emailId}" >
<button type="submit">My Appointments</button><br><br>
</form>
<br>
<form action="viewVaccines" method="post">
<input type="text" name="student_ID" value="${student.student_ID}" hidden="true">
<input type="text" name="emailId" value="${student.emailId}" hidden="true">
<button type="submit">New Appointment for Vaccination</button><br><br>
</form>
<br>
<form action="loginPage" method="post">
<button type="submit">Logout</button>
</form>
<br>
<br>
<br>
<br>
<br>


</div>
</body>
</html>