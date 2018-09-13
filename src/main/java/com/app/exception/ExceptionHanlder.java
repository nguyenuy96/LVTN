package com.app.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionHanlder extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errCode;
	private String errMessage;

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}
