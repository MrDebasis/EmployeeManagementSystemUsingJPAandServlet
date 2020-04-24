package com.emp.service;

import java.util.List;
import com.emp.dao.EmployeeDAO;
import com.emp.dao.EmployeeDAOImpl;
import com.emp.dto.Employee;

public class EmployeeService implements EmployeeDAO {
	EmployeeDAOImpl daoImpl=new EmployeeDAOImpl();

	public String login(Employee login) {
		String mag  =daoImpl.login(login);
		return mag;	
	}
	public boolean createEmployee(Employee employee) {
		return daoImpl.createEmployee(employee);
	}
	public Boolean updateEmployee(String employeeId, Employee employee) {
		return daoImpl.updateEmployee(employeeId, employee);
	}
	public List<Employee> getAllEmployees() {
		return null;
	}
	public Employee getEmployeeById(Employee employee) {
		return	daoImpl.getEmployeeById(employee);
	}
	public boolean deleteEmployeeById(String employeeId) {
		return daoImpl.deleteEmployeeById(employeeId);
	}
	public String forgetPassword(Employee employee) {
		String msg=daoImpl.forgetPassword(employee);
		return msg;
	}
}
