package com.dxctraining.inventorymgt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler 
{

		 @ExceptionHandler(SupplierNullException.class)
		    @ResponseStatus(HttpStatus.NOT_FOUND)
		    public String handleEmployeeNotFound(SupplierNullException e){
		        System.out.println("inside handlePhoneNotNotFound");
		        String msg=e.getMessage();
		        return msg;
		    }

		    @ExceptionHandler(InvalidSupplierArgumentException.class)
		    @ResponseStatus(HttpStatus.BAD_REQUEST)
		    public String handleInvalidArgument(InvalidSupplierArgumentException e){
		        System.out.println("inside handleInvalidArgument");
		        return e.getMessage();
		    }
}
