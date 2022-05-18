<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<a href="index.html">Home</a>
<body style="background-color: LightBlue;">
	<div align="center">
		<h1>Student Login Form</h1>
		<p>${result}</p>
		<form action="studentLogin" method="post">
			<pre>
EmailId: <input type="text" name="emailId" required>

Password: <input type="password" name="password" required>

<button type="Submit">Login</button>
</pre>
		</form>
	</div>
</body>
</html>