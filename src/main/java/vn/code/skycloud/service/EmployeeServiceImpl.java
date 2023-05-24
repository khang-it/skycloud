package vn.code.skycloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.code.skycloud.common.Lib;
import vn.code.skycloud.dao.EmployeeDao;
import vn.code.skycloud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void insertEmployee(Employee emp) {
		employeeDao.insertEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		employeeDao.updateEmployee(emp);

	}

	@Override
	public void executeUpdateEmployee(Employee emp) {
		employeeDao.executeUpdateEmployee(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeDao.deleteEmployee(emp);
	}

	@Override
	public List<Employee> searchEmployee(String searchText) {
		searchText = Lib.wildcard(searchText, false);
		return employeeDao.searchEmployee(searchText);
	}

}
