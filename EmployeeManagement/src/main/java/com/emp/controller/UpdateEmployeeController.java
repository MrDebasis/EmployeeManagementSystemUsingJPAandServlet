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

@WebServlet("/Update")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String DOB = request.getParameter("DOB");
		String phNo = request.getParameter("PhNo");
		String password = request.getParameter("password");
		String salary = request.getParameter("salary");
		String role = request.getParameter("role");

		Employee employee= new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmailId(emailId);
		employee.setDOB(DOB);
		employee.setPhNo(phNo);
		employee.setPassword(password);
		employee.setSalary(salary);
		employee.setRole(role);
		System.out.println("update data in pojo class");

		EmployeeService empService=new EmployeeService();
		System.err.println("going update service");
		Boolean b=empService.updateEmployee(id, employee);
		if(b){
			out.print("<h1>"+"Employee Update Successufully"+"</h1>");
		}else {
			response.sendRedirect("./UpdateEmployee.jsp");
		}	
	}
}