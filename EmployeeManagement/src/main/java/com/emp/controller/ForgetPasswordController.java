package com.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emp.dto.Employee;
import com.emp.service.EmployeeService;

@WebServlet("/forgetpass")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("eid");
		String firstName = request.getParameter("ename");
		String password = request.getParameter("npass");
		String conpassword = request.getParameter("cpass");
		if(password.equals(conpassword))
		{
			Employee employee= new Employee();
			employee.setId(id);
			employee.setFirstName(firstName);
			employee.setPassword(conpassword);

			EmployeeService empService=new EmployeeService();
			String msg=empService.forgetPassword(employee);
			if(msg.equals("SUCESSFULLY UPDATED YOUR PASSWORD")) {
				response.sendRedirect("./Sucesspass.jsp");
			}
			else if (msg.equals("Employee Not Found With Your Empid:"+employee.getId())) {
				response.sendRedirect("./Errorpass.jsp");
			}
			else {
				response.sendRedirect("./Errorpass.jsp");

			}
		}
	}

}
