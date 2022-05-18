<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.Vaccine"%>
     <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:Aquamarine">
<div align="center">
<h2>Available Vaccines: </h2>
<table border=1 style="width:50%;text-align:left;background-color:PaleGreen;">
<tr>
<th>vaccineName</th>
<th>manufacturer</th>
<th>type</th>
<th>cost</th>
</tr>
  <c:forEach items="${vaccines}" var="vaccine">
    <tr>
      <td><c:out value="${vaccine.vaccineName}" /></td>
      <td><c:out value="${vaccine.manufacturer}" /></td>
      <td><c:out value="${vaccine.type}" /></td>
      <td><c:out value="${vaccine.cost}" /></td>
      <td>
      <form action="newAppointmentPage"> 
      	<input type="text" name="student_ID" value="${student_ID}" hidden="true">
      	<input type="text" name="emailId" value="${emailId}" hidden="true">
      	<input type="text" name="vaccine_ID" value="${vaccine.vaccine_ID}" hidden="true">
      	<input type="text" name="vaccineName" value="${vaccine.vaccineName}" hidden="true">
      	<button type="submit">Book Appointment</button>
      </form>
      </td>
    </tr>
  </c:forEach>
</table><br>


<br><br>
<form action="userHome" method="post">
<button type="submit">Go Back</button></form>
</div>

</body>
</html>