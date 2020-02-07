package com.hase.huatuo.admin.exception;

import com.hase.huatuo.admin.exception.error.ErrorInfo;

public class BadRequestException extends BaseException {
	
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(ErrorInfo errorInfo) {
		super(errorInfo);
	}

}
