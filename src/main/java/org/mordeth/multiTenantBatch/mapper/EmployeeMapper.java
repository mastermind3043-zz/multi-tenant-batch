package org.mordeth.multiTenantBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mordeth.multiTenantBatch.batch.model.Car;
import org.mordeth.multiTenantBatch.batch.model.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee employee = new Employee();
		
		employee.setEmployeeId(rs.getString("EMPLOYEE_ID"));
		employee.setFirstName(rs.getString("FIRST_NAME"));
		employee.setLastName(rs.getString("NAME"));
		return employee;
		
	}

}
