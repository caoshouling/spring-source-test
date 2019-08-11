package org.csl.study.spring.source.exception;

public class BusinessException extends RuntimeException {

	
	private String errorCode;
	
	private static final long serialVersionUID = 1L;
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BusinessException() {
		super();
	}

	public BusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BusinessException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BusinessException(String message) {
		super(message);
		this.errorCode = ErrorCode.Business_Common_Error;
		
	}
	public BusinessException(String message,String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(Throwable arg0) {
		super(arg0);
	}

}
