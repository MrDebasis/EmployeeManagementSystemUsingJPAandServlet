package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emp.service.EmployeeService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("delete");
		PrintWriter out=response.getWriter();
		EmployeeService employeeService=new EmployeeService();
		boolean b=employeeService.deleteEmployeeById(id);
		if(b){
			out.print("<h1>"+"Delete Employee Successufully"+"</h1>");
		}else {
			response.sendRedirect("./DeleteEmployee.jsp");
		}

	}

}
