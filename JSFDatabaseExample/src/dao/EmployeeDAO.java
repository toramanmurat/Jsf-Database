package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {
	
	public void insertEmployee(Employee employee);
	
	public void removeEmployee(int id);
	
	public List<Employee> findAllEmployees();

}
