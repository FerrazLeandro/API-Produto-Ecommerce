package org.br.serratec.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.br.serratec.domain.Cliente;

import io.swagger.annotations.ApiModelProperty;

public class PedidoInserirDto {
	
	@NotNull
	@ApiModelProperty(value="Data do pedido", required = true)
	private LocalDate dataPedido;
	
	@ApiModelProperty(value="Data de entrega")
	private LocalDate dataEntrega;
	
	@ApiModelProperty(value="Data do pedido")
	private LocalDate dataEnvio;
	
	@NotBlank
	private String status;
	
	@NotNull
	@ApiModelProperty(value="Identificado único do cliente")
	private Cliente cliente;
	
	@NotNull
	private List<PedidoItemInserirDto> pedidoItemInserirDto;
	
	public PedidoInserirDto() {
	}
	
	
	public List<PedidoItemInserirDto> getPedidoItemInserirDto() {
		return pedidoItemInserirDto;
	}

	public void setPedidoItemInserirDto(List<PedidoItemInserirDto> pedidoItemInserirDto) {
		this.pedidoItemInserirDto = pedidoItemInserirDto;
	}


	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public Cliente getCliente() {
		return cliente;
	}


	
	
	
	
}
