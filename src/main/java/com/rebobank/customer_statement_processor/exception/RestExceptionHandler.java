package com.rebobank.customer_statement_processor.exception;


import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 *  Global exception handler for all exceptions which will finally send to Http Client.
 *  @author vgavhane
 */

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomerStatementProcessorException.class)
	protected ResponseEntity<Object> handleDiscoveryException(
			CustomerStatementProcessorException ex) {
		return buildResponseEntity(ex);
	}
	
	private ResponseEntity<Object> buildResponseEntity(CustomerStatementProcessorException customerStatementProcessorException) {
		return new ResponseEntity<>(customerStatementProcessorException, customerStatementProcessorException.getStatus());
	}
	
	@ExceptionHandler(UserAuthenticationException.class)
	public ResponseEntity<Object> handleUserAuthenticationException(UserAuthenticationException ex,
			HttpServletResponse response) {
		return new ResponseEntity<>(ex, ex.getStatus());
	}
}
