package com.orange.talents.meubanco.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PessoaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5372363447487353865L;

	private final HttpStatus httpStatus ;
	
	public PessoaException (final String mensagem , final HttpStatus httpStatus) {
		super(mensagem) ;
		this.httpStatus = httpStatus;
	}
	
	
	
}
