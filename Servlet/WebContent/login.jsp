<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">
	<form action="LoginServlet" method="post">
		E-mail: <input type="text" name="email" pattern="\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}\b" title="must contain a proper @domain" required placeholder="Enter your email" >
		<br></br> 
		Password:<input type="password" name="password" required placeholder="Enter your password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[!@#\$%\^&\*])(?=.*[A-Z]).{8,}" title="Must contain at least one number,one uppercase and lowercase letter,one special symbol and at least 8 or more characters" >
		<br></br> 
		<input type="submit" value="login">
		<br></br>	
	</form>
	<form action="PreRegister" method = "post" > <input type="submit" value="Registration??"></form>
	<form action="PreEmail" method = "post" > <input type="submit" value="Forgot Password??"></form>
</body>
</html>