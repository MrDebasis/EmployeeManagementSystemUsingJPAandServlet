package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emp.dto.Employee;
import com.emp.service.EmployeeService;

@WebServlet("/getById")
public class GetEmployeeById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();

		String id=request.getParameter("id");

		Employee employee=new Employee();
		employee.setId(id);

		EmployeeService employeeService=new EmployeeService();
		Employee emp=employeeService.getEmployeeById(employee);
		if(employee!=null)
		{
			printWriter.print("<h1>"+"Employee Details are :"+"<br>");

			printWriter.print("<h3>"+"Emp Id is :"+emp.getId());
			printWriter.print("<h3>"+"Emp firstName is :"+emp.getFirstName());
			printWriter.print("<h3>"+"Last Name is :"+emp.getLastName());
			printWriter.print("<h3>"+"email is :"+emp.getEmailId());
			printWriter.print("<h3>"+"dob is :"+emp.getDOB());
			printWriter.print("<h3>"+"phNo is :"+emp.getPhNo());
			printWriter.print("<h3>"+"password is :"+emp.getPassword());
			printWriter.print("<h3>"+"salary is :"+emp.getSalary());
			printWriter.print("<h3>"+"role is :"+emp.getRole());

		}
		else
		{
			printWriter.print("<h3>"+"<center>"+"EMPLOYEE NOT AVAILABLE"+"</h3>"+"<center>");
		}
	}

}		

