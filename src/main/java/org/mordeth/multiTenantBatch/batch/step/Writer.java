package org.mordeth.multiTenantBatch.batch.step;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	private static final Logger log = LoggerFactory.getLogger(Writer.class);
	
	@Override
	public void write(List<? extends String> messages) throws Exception {
		Thread.sleep(6000);
		for(String msg : messages){
			log.info("#Writer Step: " + msg);
		}
	}
	
}