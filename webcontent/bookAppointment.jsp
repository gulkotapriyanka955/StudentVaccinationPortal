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
<body style="background-color:Gold">
<div align="center">
<form action="newAppointment" method="post">
<input type="text" name="student_ID" value="${student_ID}" hidden="true">
<input type="text" name="emailId" value="${emailId}" hidden="true">
<input type="text" name="vaccine_ID" value="${vaccine_ID}" hidden="true">
<input type="text" name="vaccineName" value="${vaccineName}" hidden="true">
<%-- <input type="text" name="appointment" value="${appointments}" hidden="true">  --%>
User Email ID: ${emailId} <br> <br>
Vaccine: ${vaccineName} <br> <br>
Appointment Date: 
<select name="appointmentDate">
    <option value="${selectedDate}" selected>${selectedDate}</option>
    <c:forEach items="${availableDates}" var="date">        
            <option value="${date}">${date}</option>        
    </c:forEach>
</select>

 <br> <br>
 <button type="submit">Book Appointment</button>
</form>
<br><br>
<form action="viewVaccines" method="post">
<button type="submit">Go Back</button>
</form>
</div>

</body>
</html>