package vn.code.skycloud.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vn.code.skycloud.entity.Employee;
import vn.code.skycloud.mapper.EmployeeRowMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;

	@Override
	public List<Employee> findAll() {

		String sql = """
					SELECT
						e.*
						,dep.name departmentName
					FROM employee e
					LEFT JOIN department dep ON dep.id = e.department_id
					WHERE e.deleted = 0 and e.status > 0
				""";
		;

		return template.query(sql, new EmployeeRowMapper());
	}

	@Override
	public void insertEmployee(Employee emp) {
		final String sql = "insert into employee(id, name, emaill, current_address) values(:employeeId,:employeeName,:employeeEmail,:employeeAddress)";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("employeeId", emp.getEmployeeId())
				.addValue("employeeName", emp.getEmployeeName())
				.addValue("employeeEmail", emp.getEmployeeEmail())
				.addValue("employeeAddress", emp.getEmployeeAddress());
		template.update(sql, param, holder);

	}

	@Override
	public void updateEmployee(Employee emp) {
		final String sql = "update employee set name = :employeeName, current_address = :employeeAddress, email = :employeeEmail where id = :employeeId";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("employeeId", emp.getEmployeeId())
				.addValue("employeeName", emp.getEmployeeName())
				.addValue("employeeEmail", emp.getEmployeeEmail())
				.addValue("employeeAddress", emp.getEmployeeAddress());
		template.update(sql, param, holder);

	}

	@Override
	public void executeUpdateEmployee(Employee emp) {
		final String sql = "update employee set name = :employeeName, current_address = :employeeAddress, email = :employeeEmail where employeeId=:employeeId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employeeId", emp.getEmployeeId());
		map.put("employeeName", emp.getEmployeeName());
		map.put("employeeEmail", emp.getEmployeeEmail());
		map.put("employeeAddress", emp.getEmployeeAddress());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public void deleteEmployee(Employee emp) {
		final String sql = "delete from employee where id = :employeeId";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employeeId", emp.getEmployeeId());

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

	@Override
	public List<Employee> searchEmployee(String searchText) {
		String sql = """
					SELECT
						e.*
						,dep.name departmentName
					FROM employee e
					LEFT JOIN department dep ON dep.id = e.department_id
					WHERE e.deleted = 0 and e.status > -1
						AND lower(e.name) LIKE :searchText
					ORDER BY e.name
				""";
		;

		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("searchText", searchText);

		return template.query(sql, param, new EmployeeRowMapper());
	}

}
