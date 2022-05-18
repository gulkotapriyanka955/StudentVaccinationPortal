<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Appointment"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:Lavender   ;">
<div align="center">
<h2 style="color:Black;"> List of Appointments: </h2>
<table border=1 style="width:50%;text-align:left;background-color:LightGray;">
<tr>
<th>Appointment ID</th>
<th>Vaccine Name</th>
<th>Appointment Date</th>
</tr>
  <c:forEach items="${appointments}" var="appointment">
    <tr>
      <td><c:out value="${appointment.appointment_ID}" /></td>
      <td><c:out value="${appointment.vaccineName}" /></td>
      <td><c:out value="${appointment.appointmentDate}" /></td>
      <td>
      <form action="cancelAppointment" method="post"> 
      	<input type="text" name="student_ID" value="${student_ID}" hidden="true">
      	<input type="text" name="emailId" value="${emailId}" hidden="true">
      	<input type="text" name="appointment_ID" value="${appointment.appointment_ID}" hidden="true">
      	<input type="text" name="vaccineName" value="${appointment.vaccineName}" hidden="true">
      	<button type="submit">Cancel Appointment</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>
<form action="userHome" method="post">
<input type="text" name="student_ID" value="${student_ID}" hidden="true">
<input type="text" name="emailId" value="${emailId}" hidden="true">
<button type="submit">Go To Home Page</button>
</form>
<br><br>
<form action="loginPage" method="post">
<button type="submit">Logout</button></form>
<br><br>
<p>${result}</p>
</div>
</body>
</html>