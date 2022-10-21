package org.br.serratec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.br.serratec.dto.ClienteInserirDto;
import org.br.serratec.dto.EnderecoDto;

@Entity
@Table(name = "endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id_endereco")
	private Long id;
	
	@NotBlank(message = "O CEP não pode ser nulo")
	@Column(name = "cep", length = 8)
	private String cep;

	@NotBlank(message = "A logradouro não pode ser nula")
	@Column(name = "logradouro", length = 80)
	private String logradouro;
	
	@NotBlank(message = "O bairro não pode ser nulo")
	@Column(name = "bairro", length = 50)
	private String bairro;
	
	@NotBlank(message = "A cidade não pode ser nula")
	@Column(name = "localidade", length = 80)
	private String localidade;
	
	@NotBlank(message = "O número não pode ser nulo")
	@Column(name = "numero", length = 20)
	private String numero;
	
	@Column(name = "complemento", length = 60)
	private String complemento;
	
	@NotBlank(message = "A uf não pode ser nulo")
	@Column(name = "uf", length = 2)
	private String uf;

	public Endereco(EnderecoDto enderecoDto) {
		this.logradouro = enderecoDto.getLogradouro();
		this.cep = enderecoDto.getCep();
		this.bairro = enderecoDto.getBairro();
		this.complemento = enderecoDto.getComplemento();
		this.localidade = enderecoDto.getLocalidade();
		this.uf = enderecoDto.getUf();
	}
	

	public Endereco() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
