<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form name="form" action="./Restn" method="post">
<center><h3 color="red">EMPLOYEE RGISTRACTION PAGE</h3></center><br>
<center>
Emp Id: <input type="text" name="id"  required="required"/><br><br><br>
FirstName:<input type="text" name="firstName"  required="required"/><br><br><br>
LastName:<input type="text" name="lastName" required="required" /><br><br><br>
Email ID:<input type="text" name="emailId"  required="required"/><br><br><br>
DOB:<input type="text" name="DOB"  required="required"/><br><br><br>
Phone Number:<input type="text" name="PhNo"  required="required"/><br><br><br>
password:<input type="text" name="password"  required="required"/><br><br><br>
Salary:<input type="text" name="salary"  required="required"/><br><br><br>
role:<input type="text" name="role"  required="required"/><br><br><br>
<input type="submit" value="Register" /><br><br><br>
</center>
</form>
</body>
</html>