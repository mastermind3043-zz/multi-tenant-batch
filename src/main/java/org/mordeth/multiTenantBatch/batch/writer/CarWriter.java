package org.mordeth.multiTenantBatch.batch.writer;

import java.util.List;

import org.mordeth.multiTenantBatch.batch.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component(value="carWriter")
public class CarWriter implements ItemWriter<Car> {
	
	private static final Logger log = LoggerFactory.getLogger(CarWriter.class);
	
	@Override
	public void write(List<? extends Car> car) throws Exception {
		 log.info("Car : "+car);
	}

}
