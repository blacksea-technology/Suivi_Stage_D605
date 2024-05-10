package com.suivistage.api.exception;

public class EntityNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public EntityNotFoundException(String errorMessage, Throwable errorCause) {
		super(errorMessage, errorCause);
	}
	
	public EntityNotFoundException(String errorMessage, ErrorCodes errorCode) {
		super(errorMessage);
		this.errorCode=errorCode;
	}
	
	public EntityNotFoundException(String errorMessage, Throwable errorCause, ErrorCodes errorCode) {
		super(errorMessage, errorCause);
		this.errorCode=errorCode;
	}
	
	private ErrorCodes errorCode;
	
	public ErrorCodes getErrorCode() {
		return this.errorCode;
	}
}
