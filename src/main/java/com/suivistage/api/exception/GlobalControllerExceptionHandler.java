package com.suivistage.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EntityNotFoundException.class)
	public @ResponseBody ErrorInfo handleEntityNotFoundException(EntityNotFoundException exception) {
		return new ErrorInfo(exception.getErrorCode().toString(), exception.getMessage(), null);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EntityNotValidException.class)
	public @ResponseBody ErrorInfo handleEntityNotValidException(EntityNotValidException exception) {
		return new ErrorInfo(exception.getErrorCode().toString(), exception.getMessage(), exception.getlistErrors());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ServerException.class)
	public @ResponseBody ErrorInfo handleServerException(ServerException exception) {
		return new ErrorInfo(exception.getErrorCode().toString(), exception.getMessage(), null);
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(EntityAlreadyExistsException.class)
	public @ResponseBody ErrorInfo handleEntityAlreadyExistsException(EntityAlreadyExistsException exception) {
		return new ErrorInfo(exception.getErrorCode().toString(), exception.getMessage(), null);
	}
}
