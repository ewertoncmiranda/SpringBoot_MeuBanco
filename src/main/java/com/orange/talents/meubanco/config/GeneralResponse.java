package com.orange.talents.meubanco.config;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GeneralResponse<T> extends RepresentationModel<GeneralResponse<T>> {
	private T data ;
	private int statusCode ;
	private Long timestamp ;
	
}
