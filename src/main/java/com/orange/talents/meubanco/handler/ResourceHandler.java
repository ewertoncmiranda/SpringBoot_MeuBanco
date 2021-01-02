package com.orange.talents.meubanco.handler;


import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orange.talents.meubanco.config.ErrorValidatorResponse;
import com.orange.talents.meubanco.config.ErrorValidatorResponse.ErrorValidatorResponseBuilder;
import com.orange.talents.meubanco.config.Response;
import com.orange.talents.meubanco.config.Response.ResponseBuilder;

@ControllerAdvice
public class ResourceHandler {

	 ResponseBuilder erro ;
	 ErrorValidatorResponseBuilder erroValidator;	
	
		
	  @ExceptionHandler(HttpMessageNotReadableException.class)
	  public ResponseEntity<Response> handlerHttpMessageNotReadableException(HttpMessageNotReadableException  exception) {
		  erro = Response.builder() ;
	  
		  erro.mensagem("INSIRA A DATA NO FORMATO DEFINIDO! 'yyyy-MM-dd'") ;
		  erro.mensagem_2(exception.getLocalizedMessage());
		  erro.httpStatus(HttpStatus.BAD_REQUEST.value());
		  erro.timeStamp(System.currentTimeMillis());
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro.build());
	  }
	  
		
		  @ExceptionHandler(DataIntegrityViolationException.class)
		  public ResponseEntity<Response> handlerDataIntegrityViolationException(DataIntegrityViolationException exception){
			  erro = Response.builder();
			  
			  erro.mensagem_2(exception.getMostSpecificCause().toString());
			  erro.mensagem(" CPF ou Email Duplicados na base de dados!!");
			  erro.httpStatus(HttpStatus.CONFLICT.value());
			  erro.timeStamp(System.currentTimeMillis());
			  return ResponseEntity.status(HttpStatus.CONFLICT).body(erro.build());
		  
		  }
		 
	 
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<ErrorValidatorResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception){  
	  
		  ErrorValidatorResponseBuilder erroValidator  = ErrorValidatorResponse.builder();
	  
		  Map<String, String> mapaDeErros = new HashMap<>();
		  exception.getBindingResult().getAllErrors().forEach(
				  erroInterno ->{
					  String campo = ((FieldError)erroInterno).getField();
					  String mensagem = erroInterno.getDefaultMessage();
					  mapaDeErros.put(campo, mensagem);
				  });
		  
		  erroValidator.validation(mapaDeErros)
		  			   .mensagem(exception.getMessage())
		  			   .timestamp(System.currentTimeMillis())
		  			   .httpResponse(HttpStatus.BAD_REQUEST.value());
		  
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroValidator.build());
	  
	  }	  
	  
	  
	
	  
	
}
