package com.emp.dao;

import java.util.List;
import com.emp.dto.Employee;

public interface EmployeeDAO {
	public String login(Employee emp);
	public boolean createEmployee(Employee employee);
	public Boolean updateEmployee(String employeeId, Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Employee employeeId);
	public boolean deleteEmployeeById(String employeeId);
	public String forgetPassword(Employee employee);
}
