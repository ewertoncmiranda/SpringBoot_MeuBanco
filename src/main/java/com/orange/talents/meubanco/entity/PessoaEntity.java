package com.orange.talents.meubanco.entity;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_pessoa")
@Data
@NoArgsConstructor
public class PessoaEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment" ,strategy = "increment")
	@Column(name="id")
	private Long id ;
	

	@Column(name="CPF" ,length = 14,unique=true)
	private String CPF;	
	

	@Column(name="email" ,unique=true )
	private String email;
	
	
	@Column(name="nome")
	private String nome;
		
	
	@Column(name="dataNascimento" )
	private  LocalDate dataNascimento ;
	
}
