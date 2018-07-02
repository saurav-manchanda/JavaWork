<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<form action="RegisterServltet" method="post" name="registeration">
			Name:<input type="text" name="name" requred placeholder="Please Enter your name">
			<br></br>
			Phone Number:<input type="text" name="phoneNumber" pattern= ".{10,10}" title="Must be a 10 digit number." required placeholder="Please enter your Phone number" >
			<br></br>
			Email:<input type="text" name="email" pattern="\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}\b" title="must contain a proper @domain" required placeholder="Please enter your email id">	
			<br></br>
			Password:<input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[!@#\$%\^&\*])(?=.*[A-Z]).{8,}" title="Must contain at least one number,one uppercase and lowercase letter,one special symbol and at least 8 or more characters" required placeholder="Please Enter your Password" >
			<br></br>
			<input type="submit" value="register">
			
   
	</form>
</body>
</html>