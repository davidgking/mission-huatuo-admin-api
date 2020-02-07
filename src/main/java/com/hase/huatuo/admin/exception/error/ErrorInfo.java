package com.hase.huatuo.admin.exception.error;

import lombok.Data;

@Data
public class ErrorInfo {
	private String code;
	private ErrorMessage message;
	
	public ErrorInfo(String code) {
		this.code = code;
	}
}
