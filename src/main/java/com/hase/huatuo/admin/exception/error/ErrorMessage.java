package com.hase.huatuo.admin.exception.error;

import lombok.Data;

@Data
public class ErrorMessage {
	private String key;
	private String params;
	
	public ErrorMessage(String key) {
		this.key = key;
	}

	public ErrorMessage(String key, String params) {
		this.key = key;
		this.params = params;
	}
}
