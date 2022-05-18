<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:BurlyWood">
<div align="center">
<h1> Update Contact</h1>
<h2>User Details</h2>
<br><br>
<form action="updateContact" method="post">
<br>
${student.student_ID}<br> 
<input type="text" name="student_ID" value="${student.student_ID}" hidden ="true"><br>
UCMO_ID<br> 
<input type="text" name="ucmo_ID" value="${student.ucmo_ID}"><br>
First Name:<br>
<input type="text" name="firstName" value="${student.firstName}"> <br>
Last Name:<br> 
<input type="text" name="lastName" value="${student.lastName}"> <br>
Department:<br>
<input type="text" name="department" value="${student.department}"> <br>
Contact Number:<br>
<input type="text" name="contactNumber" value="${student.contactNumber}"> <br>
${student.emailId}<br>
<input type="text" name="emailId" value="${student.emailId}" hidden ="true"> <br>
<br><br>
<button type="submit">Edit My Details</button>
<br><br>
</form>

<form action="userHome" method="post">
<input type="text" name="student_ID" value="${student.student_ID}" hidden="true">
<input type="text" name="emailId" value="${student.emailId}" hidden="true">
<button type="submit">Go To Home Page</button>
</form><br><br>

<form action="loginPage" method="post">
<button type="submit">Logout</button>
</form>
</div>
 </body>
</html>