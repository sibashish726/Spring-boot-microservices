package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.entity.ErrorMessage;

@ControllerAdvice
public class RestEntityResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
   
	@ExceptionHandler(EmployeeNotFound.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage employeeNotFoundExpception(EmployeeNotFound exception) {
		return new ErrorMessage(HttpStatus.NOT_FOUND , exception.getMessage());
   }
}
