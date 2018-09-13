package com.app.exception;

import org.springframework.http.HttpStatus;

public class ExceptionThrower {

	public void throwException(HttpStatus errCode, String errMessage) throws ExceptionHandle{
		ExceptionHandle exceptionHanlder = new ExceptionHandle();
		exceptionHanlder.setErrCode(errCode.value());
		exceptionHanlder.setErrMessage(errMessage);
		throw exceptionHanlder;
	}
}
