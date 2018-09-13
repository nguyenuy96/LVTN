package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ExceptionHandle.class)
	public ResponseEntity<ExceptionResponse> handlingException(ExceptionHandle exceptionHandle) throws Exception{
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrCode(exceptionHandle.getErrCode());
		exceptionResponse.setErrMessage(exceptionHandle.getErrMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.valueOf(exceptionHandle.getErrCode()));
	}
}
