package com.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;
import com.emp.service.EmployeeService;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getContentType();
		//user name and password we r getting from frontend
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");

		//asignning the value to pojo classes
		Employee employee=new Employee();
		employee.setFirstName(uname);
		employee.setPassword(pass);

		//passing the value to the employee service
		EmployeeDAO empService= new EmployeeService(); //abstruction
		String msg=empService.login(employee);

		//we are getting the value msg from srvice
		if(msg.equals("Admin_Role"))
		{
			System.out.println("Admin's Home");

			HttpSession session = request.getSession(); //Creating a session
			session.setAttribute("Admin", uname); //setting session attribute
			request.setAttribute("userName", uname);

			request.getRequestDispatcher("./Admin.jsp").forward(request, response);
		}
		else if(msg.equals("User_Role"))
		{
			System.out.println("User's Home");

			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10*60);
			session.setAttribute("User", uname);
			request.setAttribute("userName", uname);

			request.getRequestDispatcher("./User.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Error message = "+msg);
			request.setAttribute("errMessage", msg);

			request.getRequestDispatcher("./Login.jsp").forward(request, response);
		}
	}	
}


