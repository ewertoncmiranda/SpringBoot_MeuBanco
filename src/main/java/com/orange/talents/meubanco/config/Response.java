package com.orange.talents.meubanco.config;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response {
	
	private String mensagem ;
	private String mensagem_2 ;
	private int httpStatus ;
	private long timeStamp ;

}
