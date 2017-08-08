package org.mordeth.multiTenantBatch.batch.processor;

import org.mordeth.multiTenantBatch.batch.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(value="carProcessor")
public class CarProcessor implements ItemProcessor<Car, Car> {
	
	private static final Logger log = LoggerFactory.getLogger(CarProcessor.class);

	@Override
	public Car process(Car car) throws Exception {
		log.info("Do some Processing");
		Thread.sleep(6000);
		return car;
	}

}
