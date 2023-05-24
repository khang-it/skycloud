package vn.code.skycloud.dao;

import java.util.List;

import vn.code.skycloud.entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void executeUpdateEmployee(Employee emp);

	public void deleteEmployee(Employee emp);

	List<Employee> searchEmployee(String searchText);
}
