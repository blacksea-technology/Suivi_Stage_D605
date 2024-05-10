package com.suivistage.api.exception;

import java.util.List;

public class EntityNotValidException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EntityNotValidException(String errorMessage) {
		super(errorMessage);
	}
	
	public EntityNotValidException(String errorMessage, Throwable errorCause) {
		super(errorMessage, errorCause);
	}
	
	public EntityNotValidException(String errorMessage, ErrorCodes errorCode) {
		super(errorMessage);
		this.errorCode=errorCode;
	}
	
	public EntityNotValidException(String errorMessage, Throwable errorCause, ErrorCodes errorCode) {
		super(errorMessage, errorCause);
		this.errorCode=errorCode;
	}
	
	public EntityNotValidException(String errorMessage, ErrorCodes errorCode, List<String> listErrors) {
		super(errorMessage);
		this.errorCode=errorCode;
		this.listErrors=listErrors;
	}
	
	private ErrorCodes errorCode;
	List<String> listErrors;
	
	public ErrorCodes getErrorCode() {
		return this.errorCode;
	}
	public List<String> getlistErrors() {
		return this.listErrors;
	}
}
