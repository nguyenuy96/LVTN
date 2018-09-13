package com.app.exception;

import org.springframework.http.HttpStatus;

public class ExceptionThrower {

	public void throwException(HttpStatus errCode, String errMessage) throws ExceptionHanlder{
		ExceptionHanlder exceptionHanlder = new ExceptionHanlder();
		exceptionHanlder.setErrCode(errCode.value());
		exceptionHanlder.setErrMessage(errMessage);
		throw exceptionHanlder;
	}
}
