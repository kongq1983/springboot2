package com.kq.jdbc1.exception;

/**
 * 基础异常
 * @author kongqi
 * @Date 2017-09-28
 */
public class ZyxtBaseRuntimeException extends RuntimeException{

	private static final long serialVersionUID = -6802928047118211693L;
	
	protected String code;
	protected String message;
	
	public ZyxtBaseRuntimeException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
}