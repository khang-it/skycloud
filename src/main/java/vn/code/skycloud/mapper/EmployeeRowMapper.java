package vn.code.skycloud.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import vn.code.skycloud.entity.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getLong("id"));
		emp.setEmployeeName(rs.getString("name"));
		emp.setEmployeeEmail(rs.getString("email"));
		emp.setEmployeeAddress(rs.getString("current_address"));
		emp.setDepartmentName(rs.getString("departmentName"));
		return emp;
	}

}
