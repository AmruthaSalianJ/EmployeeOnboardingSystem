package com.eob.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

import com.eob.entity.User;

public class StepSkipListener implements SkipListener<User, Number>{

	Logger logger = LoggerFactory.getLogger(StepSkipListener.class);
	
	public void onSkipInRead(Throwable t)
	{
		logger.info("failure in read "+ t.getMessage());
	}
	
	public void onSkipInWrite(Number number, Throwable t)
	{
		logger.info("failure in write "+t.getMessage());
	}
	
	public void onSkipInProcess(User u, Throwable t)
	{
		logger.info("failure in process "+t.getMessage());
	}
	
}
