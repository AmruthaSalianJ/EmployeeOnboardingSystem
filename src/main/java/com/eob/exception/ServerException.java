package com.eob.exception;

import org.springframework.http.HttpStatus;

public class ServerException extends RuntimeException {

	private static final long serialVersionUID = -821442562499457275L;

	public ServerException(String message) {
		super(message);
	}

	public HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
