package com.hase.huatuo.admin.exception;

import com.hase.huatuo.admin.exception.error.ErrorInfo;

public class TechnicalRestException extends BaseException {
	private static final long serialVersionUID = 1L;
	
	public TechnicalRestException(ErrorInfo errorInfo) {
		super(errorInfo);
	}

}
