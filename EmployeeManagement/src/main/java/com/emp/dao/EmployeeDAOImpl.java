package com.emp.dao;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.emp.dto.Employee;
import com.emp.repo.RepositoryUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	java.sql.Connection con=null;
	java.sql.PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	boolean b=false;
	PrintWriter out= new PrintWriter(System.out);

	public String login(Employee employee) {

		try {
			Class.forName(RepositoryUtils.getDriverName());
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());
			stmt = con.createStatement();
			rs = stmt.executeQuery("select firstName,password,role from Employee");

			while(rs.next())
			{
				String nameDB = rs.getString("firstName");
				String	passwordDB = rs.getString("password");
				String	roleDB = rs.getString("role");

				if(employee.getFirstName().equals(nameDB) && employee.getPassword().equals(passwordDB) && roleDB.equals("admin"))
					return "Admin_Role";
				else if(employee.getFirstName().equals(nameDB) &&employee.getPassword().equals(passwordDB) && roleDB.equals("user"))
					return "User_Role";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
	}

	public boolean createEmployee(Employee employee) {
		try {
			Class.forName(RepositoryUtils.getDriverName());

			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());

			String query= "insert into Employee values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, employee.getId());
			pstmt.setString(2, employee.getFirstName());
			pstmt.setString(3, employee.getLastName());
			pstmt.setString(4, employee.getEmailId());
			pstmt.setString(5, employee.getDOB());
			pstmt.setString(6, employee.getPhNo());
			pstmt.setString(7, employee.getPassword());
			pstmt.setString(8, employee.getSalary());
			pstmt.setString(9, employee.getRole());

			int count =pstmt.executeUpdate();
			if(count>0) {
				b= true;   			
			} else {
				b= false;
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}
	public Boolean updateEmployee(String employeeId, Employee employee) {
		try
		{
			Class.forName(RepositoryUtils.getDriverName());
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());

			String query= "update Employee set firstName=?,lastName=?,emailId=?,DOB=?,PhNo=?,password=?,salary=?,role=? where id=?";
			pstmt = con.prepareStatement(query);
			System.out.println("Update queryis fine");

			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmailId());
			pstmt.setString(4, employee.getDOB());
			pstmt.setString(5, employee.getPhNo());
			pstmt.setString(6, employee.getPassword());
			pstmt.setString(7, employee.getSalary());
			pstmt.setString(8, employee.getRole());
			pstmt.setString(9, employeeId);

			int count =pstmt.executeUpdate();

			if(count>0) {
				b= true;   			
			}else{
				b= false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}
	public List<Employee> getAllEmployees() {
		return null;
	}

	public Employee getEmployeeById(Employee emp) {
		try{
			Class.forName(RepositoryUtils.getDriverName());
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from  Employee where id="+emp.getId());
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

				emp.setId(id);
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setEmailId(emailId);
				emp.setDOB(DOB);
				emp.setPhNo(PhNo);
				emp.setPassword(password);
				emp.setSalary(salary);
				emp.setRole(role);
			}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return emp;

	}
	public boolean deleteEmployeeById(String employeeId) {

		try{
			Class.forName(RepositoryUtils.getDriverName());
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());

			String query= "delete from  Employee where id=?";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, employeeId);

			int count =pstmt.executeUpdate();

			if(count>0) {
				b= true;   			
			} else {
				b= false;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	public String forgetPassword(Employee employee) {
		String msg = null;
		try
		{
			Class.forName(RepositoryUtils.getDriverName());
			con = DriverManager.getConnection(RepositoryUtils.getDbUrl());

			String query= "update Employee set password=? where id=? AND firstName=?";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, employee.getPassword());
			pstmt.setString(2, employee.getId());
			pstmt.setString(3, employee.getFirstName());

			int count =pstmt.executeUpdate();

			if(count>0) {
				return msg="SUCESSFULLY UPDATED YOUR PASSWORD"; 

			}else{
				return msg="Employee Not Found With Your Empid:"+employee.getId(); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return msg;
	}
}
