package com.suivistage.api.exception;

public class EntityAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityAlreadyExistsException(String errorMessage) {
		super(errorMessage);
	}
	
	public EntityAlreadyExistsException(String errorMessage, Throwable errorCause) {
		super(errorMessage, errorCause);
	}
	
	public EntityAlreadyExistsException(String errorMessage, ErrorCodes errorCode) {
		super(errorMessage);
		this.errorCode=errorCode;
	}
	
	public EntityAlreadyExistsException(String errorMessage, Throwable errorCause, ErrorCodes errorCode) {
		super(errorMessage, errorCause);
		this.errorCode=errorCode;
	}
	
	private ErrorCodes errorCode;
	
	public ErrorCodes getErrorCode() {
		return this.errorCode;
	}
}
