/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mordeth.multiTenantBatch.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAutoConfiguration(exclude = {BatchAutoConfiguration.class})
@ComponentScan
@ImportResource({"classpath:job-context.xml"})
@EnableAsync
public class SampleBatchApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SampleBatchApplication.class);

	
	@Autowired
	ApplicationContext context;
	
	private String[] jobNames = {};
	
	private JobLauncher jobLauncher = null;
	
	public static void main(String[] args) throws Exception {
		// System.exit is common for Batch applications since the exit code can be used to
		// drive a workflow
		SpringApplication.run(SampleBatchApplication.class, args);
	}
	
	@Scheduled(initialDelay=5000, fixedDelayString="${application.process.sleep.interval}")
	private void jobLauncher(){
		//System.out.println("Invoked");
		if(jobNames.length<1){
		 log.info("Fetching Job Names");	
		 jobNames = context.getBeanNamesForType(Job.class);
		}
		if(jobLauncher==null){
			log.info("Fetching job launcher");
			jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		}
		
		for(int i=0; i<jobNames.length; i++){
			launchJob(jobLauncher, jobNames[i]);
			
		}
		
	}

	@Async
	public void launchJob(JobLauncher jobLauncher, String jobName) {
		log.info("Launching job : "+jobName);
		Job aJob = (Job) context.getBean(jobName);
		if(aJob!=null){
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
			try {
				JobExecution execution = jobLauncher.run(aJob, jobParameters);
				log.info("Status : "+execution.getStatus());
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobRestartException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
