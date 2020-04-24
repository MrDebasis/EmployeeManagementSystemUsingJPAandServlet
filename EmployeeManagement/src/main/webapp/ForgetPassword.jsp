<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ForgetPassword</title>
</head>
<body>
<form name="form" action="./forgetpass" method="post">

<center>
<h3>FORGET PASSWORD</h3>
Employee Id:<input type=text name="eid" required="required">
Employee Name:<input type=text name="ename" required="required">
New password :<input type=text name="npass" required="required">
Conform Password:<input type=text name="cpass" required="required">
<input type=submit  value="Submit">
</center>

</from>

</body>
</html>