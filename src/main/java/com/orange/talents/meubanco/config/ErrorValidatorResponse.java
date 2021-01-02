package com.orange.talents.meubanco.config;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorValidatorResponse {
	private int httpResponse ;
	private Map<String ,String> validation;
	private Long timestamp ; 
	private String mensagem ;

}
