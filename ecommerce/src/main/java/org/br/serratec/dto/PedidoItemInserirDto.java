package org.br.serratec.dto;

import org.br.serratec.domain.Produto;

public class PedidoItemInserirDto {
	private Integer quantidade;
	private Double percentualDesconto;
	private Produto produto;
	
	
	public PedidoItemInserirDto() {
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}
	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
