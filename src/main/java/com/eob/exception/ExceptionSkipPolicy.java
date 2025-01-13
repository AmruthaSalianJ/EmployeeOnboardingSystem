package com.eob.exception;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

public class ExceptionSkipPolicy implements SkipPolicy{

	@Override
	public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
		// TODO Auto-generated method stub
		return t instanceof RuntimeException;
	}

}
