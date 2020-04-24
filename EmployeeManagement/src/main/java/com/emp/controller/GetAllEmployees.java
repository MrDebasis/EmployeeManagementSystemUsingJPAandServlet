package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getall")
public class GetAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<html><body>");  
		try 
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login?user=root&password=1234");  

			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("select * from Employee");  
			out.println("<table border=3 width=90% height=60%>");  
			out.println("<tr><th>EmpId</th><th>firstName</th><th>lastName</th><th>emailId</th><th>DOB</th><th>PhNo</th><th>password</th><th>salary</th>"
					+ "<th>role</th><tr>");  
			while (rs.next()) 
			{  
				String id=rs.getString("id");
				String firstName=rs.getString("firstName");
				String lastName=rs.getString("lastName");
				String emailId=	rs.getString("emailId");
				String DOB=rs.getString("DOB");
				String PhNo =rs.getString("PhNo");
				String password=rs.getString("password");
				String salary=rs.getString("salary");
				String role=rs.getString("role");


				out.println("<tr><td>" + id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>"+
						emailId +"</td><td>" +DOB + "</td><td>" +PhNo +"</td><td>" + password + "</td><td>" + salary + "</td><td>" + role +"</td></tr>" );   
			}  
			out.println("</table>");  
			out.println("</html></body>");  
			con.close();  
		}  
		catch (Exception e) 
		{  
			out.println("error");  
		}   
	}
}