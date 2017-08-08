package org.mordeth.multiTenantBatch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.mordeth.multiTenantBatch.batch.model.Car;
import org.springframework.jdbc.core.RowMapper;

public class CarMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int arg1) throws SQLException {
		Car car = new Car();
		
		car.setSerial(rs.getInt("serial"));
		car.setBrand(rs.getString("brand"));
		car.setColor(rs.getString("color"));
		car.setModel(rs.getString("model"));
		car.setYear(rs.getString("year"));
		
		return car;
		
	}

}
