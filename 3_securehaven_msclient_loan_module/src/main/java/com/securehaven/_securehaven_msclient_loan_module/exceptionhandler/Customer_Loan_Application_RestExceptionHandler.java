package com.securehaven._securehaven_msclient_loan_module.exceptionhandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.securehaven._securehaven_msclient_loan_module.exceptions.ApplicationInProgressException;
import com.securehaven._securehaven_msclient_loan_module.exceptions.ApplicationNotFoundException;
import com.securehaven._securehaven_msclient_loan_module.model.Success;

@RestControllerAdvice
public class Customer_Loan_Application_RestExceptionHandler {
	
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Success> ApplicationNotFound(ApplicationNotFoundException e)
	{
		Success s=new Success();
		
		s.setMsg(e.getMessage());
		
		return new ResponseEntity<Success>(s,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ApplicationInProgressException.class)
	public ResponseEntity<Success> ApplicationProgress(ApplicationInProgressException e)
	{
		Success s=new Success();
		
		s.setMsg(e.getMessage());
		
		return new ResponseEntity<Success> (s,HttpStatus.NOT_FOUND);
	}

}
