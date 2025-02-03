package com.eob.exception;

import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends ServerException {

	private static final long serialVersionUID = 4433467670768029985L;

	public RecordNotFoundException() {
		super("Requested record not found");
	}
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public HttpStatus getHttpStatus() {
		return HttpStatus.NOT_FOUND;
	}
	
}
