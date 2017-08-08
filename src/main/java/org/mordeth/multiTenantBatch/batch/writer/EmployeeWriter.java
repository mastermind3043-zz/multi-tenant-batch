package org.mordeth.multiTenantBatch.batch.writer;

import java.util.List;

import org.mordeth.multiTenantBatch.batch.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component(value="employeeWriter")
public class EmployeeWriter implements ItemWriter<Employee> {

	private static final Logger log = LoggerFactory.getLogger(EmployeeWriter.class);
	
	@Override
	public void write(List<? extends Employee> employee) throws Exception {
		
		log.info("Employee : "+employee);
	}

}
