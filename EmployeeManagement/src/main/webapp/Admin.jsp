<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<% //In case, if Admin session is not set, redirect to Login page
if((request.getSession(false).getAttribute("Admin")== null) )
{
%>
<jsp:forward page="./Login.jsp"></jsp:forward>
<%} %>
</head>
<body>
<center><h2>Admin's Home</h2>

Welcome <%=request.getAttribute("userName") %><br><br><br>
</center>
<a href="./Logout">Logout</a></div><br>
<a href="./UpdateEmployee.jsp">Update Employee</a></div><br>
<a href="./getall">Get AllEmployee</a></div><br>
<a href="./DeleteEmployee.jsp">Delete Employee</a></div><br>
<a href="./GetEmployeeById.jsp">Get by id</a></div><br>

</body>

</body>
</html>