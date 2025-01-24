package com.eob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api")
public class JobController {
 
	@Autowired
	@Qualifier("userJob")
	private Job userJob;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@GetMapping("/load")
	//@Scheduled(cron = "*/10 * * * * *") // Task will run for 10 sec
	public ResponseEntity userLoad() {
		try
		{
			JobParameters parameters = new JobParametersBuilder().addLong("started at", System.currentTimeMillis())
				.toJobParameters();
		
			jobLauncher.run(userJob, parameters);
			return ResponseEntity.ok("job is running");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity("error",HttpStatus.EXPECTATION_FAILED);
		
		}
	}
	
}
