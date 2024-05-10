package com.suivistage.api.exception;

public class ServerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServerException(String errorMessage) {
		super(errorMessage);
	}
	
	public ServerException(String errorMessage, Throwable errorCause) {
		super(errorMessage, errorCause);
	}
	
	public ServerException(String errorMessage, ErrorCodes errorCode) {
		super(errorMessage);
		this.errorCode=errorCode;
	}
	
	public ServerException(String errorMessage, Throwable errorCause, ErrorCodes errorCode) {
		super(errorMessage, errorCause);
		this.errorCode=errorCode;
	}
	
	private ErrorCodes errorCode;
	
	public ErrorCodes getErrorCode() {
		return this.errorCode;
	}
}
