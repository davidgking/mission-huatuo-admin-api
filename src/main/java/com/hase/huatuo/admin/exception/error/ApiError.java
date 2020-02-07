package com.hase.huatuo.admin.exception.error;

import javax.servlet.http.HttpServletRequest;

import com.hase.huatuo.admin.exception.error.ErrorInfo;
import lombok.Data;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.http.HttpStatus;

@Data
public class ApiError {
	private ErrorInfo errorInfo;
	private String path;
	private Integer status;
	
	public ApiError(HttpStatus httpStatus, HttpServletRequest request, ErrorInfo errorInfo) {
		this.status = httpStatus.value();
		this.errorInfo = errorInfo;
		this.path = StringEscapeUtils.escapeHtml4(request.getRequestURI());
	}
}
