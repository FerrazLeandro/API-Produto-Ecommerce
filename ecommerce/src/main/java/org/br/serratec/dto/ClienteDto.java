package org.br.serratec.dto;

import java.time.LocalDate;

import org.br.serratec.domain.Cliente;
import org.br.serratec.domain.Endereco;

public class ClienteDto {
	
	private Long id;
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
	
	public ClienteDto(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.dataNascimento = cliente.getDataNascimento();
	}
	
	public ClienteDto() {
	}


	
	public Long getId() {
		return id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public String getCpf() {
		return cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public Endereco getEndereco() {
		return endereco;
	}
	
	
	

}
