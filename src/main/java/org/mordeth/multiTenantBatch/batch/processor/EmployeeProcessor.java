package org.mordeth.multiTenantBatch.batch.processor;

import org.mordeth.multiTenantBatch.batch.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(value="employeeProcessor")
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

	private static final Logger log = LoggerFactory.getLogger(EmployeeProcessor.class);
	
	@Override
	public Employee process(Employee employee) throws Exception {
		log.info("Do some processing");
		Thread.sleep(6000);
		return employee;
	}

}
