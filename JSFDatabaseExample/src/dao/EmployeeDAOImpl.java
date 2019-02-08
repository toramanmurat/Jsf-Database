package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;


import com.mysql.cj.jdbc.PreparedStatement;

import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String INSERT_EMPLOYEE="insert into employee(name,surname,age) values(?,?,?)";
	private static final String ALL_EMPLOYEE="select * from employee";
	private static final String DELETE_EMPLOYEE="delete from employee where id=?";
	
	
	@Override
	public void insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		ConnectionManager manager=ConnectionManager.getInstance();
		DataSource dataSource=manager.getMySQLDataSource();
		String name=employee.getName();
		String surname=employee.getSurname();
		int age=employee.getAge();
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement ps= (PreparedStatement) connection.prepareStatement(INSERT_EMPLOYEE);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setInt(3, age);
			ps.executeUpdate();
			connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		ConnectionManager manager=ConnectionManager.getInstance();
		DataSource dataSource=manager.getMySQLDataSource();
		Connection connection;
		try {
			connection=dataSource.getConnection();
			PreparedStatement ps=(PreparedStatement) connection.prepareStatement(DELETE_EMPLOYEE);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employeeList=new ArrayList<Employee>();
		ConnectionManager manager=ConnectionManager.getInstance();
		DataSource dataSource=manager.getMySQLDataSource();
		
		Connection connection;
		PreparedStatement ps;
		try {
			connection=dataSource.getConnection();
			ps=(PreparedStatement) connection.prepareStatement(ALL_EMPLOYEE);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String surname=rs.getString("surname");
				int age=rs.getInt("age");
				
				Employee employee=new Employee(name,surname,age,id);
				
				employeeList.add(employee);	
			}
			
			rs.close();
			ps.close();
			connection.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return employeeList;
	}

}
