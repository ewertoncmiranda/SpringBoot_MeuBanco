package com.orange.talents.meubanco.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PessoaDTO {
		
	private Long id;
	
    @CPF
	private String CPF;

    @NotBlank(message = "O nome não pode estar em branco!")
	private String nome;

	@Email(message = "Insira o email padrão no 'endereço@provedor'")
	@NotBlank(message="O email não pode estar vazio!")
	private String email;
	
	@NotNull(message="A data de nascimento não pode estar vazia!")
	private LocalDate dataNascimento;	
	
}
