package com.orange.talents.meubanco.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.orange.talents.meubanco.dto.PessoaDTO;
import com.orange.talents.meubanco.entity.PessoaEntity;
import com.orange.talents.meubanco.repository.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository repos ;	
	private ModelMapper mapper ;
	
	@Autowired
	public PessoaService(PessoaRepository repos) {
		this.repos = repos ;
		this.mapper = new ModelMapper();			
	}
	
	public List<PessoaDTO> listarTodasPessoas(){
				
			List<PessoaDTO> lista = new ArrayList<>();
			
			for( PessoaEntity pessoa : this.repos.findAll() ) {
				lista.add(this.mapper.map(pessoa, PessoaDTO.class));
			}
			return lista ;						
	}
	
	
	public Boolean salvarNovaPessoa(PessoaDTO dto) {
		try {
			repos.save(mapper.map(dto , PessoaEntity.class));
			return Boolean.TRUE;
		} catch (DataIntegrityViolationException e) {
		 throw new DataIntegrityViolationException("CPF ou Email Duplicados na base de dados!!") ;		  
		}	
	 }
	
	
}
