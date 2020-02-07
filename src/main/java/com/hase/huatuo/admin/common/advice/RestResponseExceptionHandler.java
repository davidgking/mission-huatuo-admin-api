package com.hase.huatuo.admin.common.advice;

import javax.servlet.http.HttpServletRequest;

import com.hase.huatuo.admin.exception.error.ApiError;
import com.hase.huatuo.admin.exception.error.ErrorInfo;
import com.hase.huatuo.admin.exception.error.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hase.huatuo.admin.exception.BadRequestException;
import com.hase.huatuo.admin.exception.TechnicalRestException;

@RestControllerAdvice
public class RestResponseExceptionHandler {

	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleBadRequestException(HttpServletRequest req, BadRequestException ex) {
		
		return new ApiError(HttpStatus.BAD_REQUEST, req, ex.getErrorInfo());
	}
	
	@ExceptionHandler(TechnicalRestException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handleTechnicalRestException(HttpServletRequest req, TechnicalRestException ex) {
		
		return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, req, ex.getErrorInfo());
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiError handleException(HttpServletRequest req, Exception ex) {
		
		return buildApiError(HttpStatus.INTERNAL_SERVER_ERROR, req, "HTTP_ERR", ex.getMessage());
	}
	
	private ApiError buildApiError(HttpStatus httpStatus, HttpServletRequest req, String errPrefix, String msg) {
		
		ErrorInfo errorInfo = new ErrorInfo(errPrefix);
		errorInfo.setMessage(new ErrorMessage(msg));
		
		return new ApiError(httpStatus, req, errorInfo);
	}
	
}
