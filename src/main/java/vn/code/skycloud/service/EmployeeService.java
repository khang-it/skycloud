package vn.code.skycloud.service;

import java.util.List;

import vn.code.skycloud.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void executeUpdateEmployee(Employee emp);

	void deleteEmployee(Employee emp);

	List<Employee> searchEmployee(String searchText);

}
