package org.br.serratec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.br.serratec.domain.ItemPedido;
import org.br.serratec.domain.Pedido;
import org.br.serratec.dto.PedidoDto;
import org.br.serratec.dto.PedidoInserirDto;
import org.br.serratec.dto.PedidoItemInserirDto;
import org.br.serratec.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	
	public PedidoDto buscar(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			return null;
		}
		return new PedidoDto(pedido.get());
	}
	
	
	
	public Pedido salvar(PedidoInserirDto pedidoInserirDto) {
		Pedido pedido = new Pedido();
		pedido.setDataPedido(pedidoInserirDto.getDataPedido());
		pedido.setDataEntrega(pedidoInserirDto.getDataEntrega());
		pedido.setDataEnvio(pedidoInserirDto.getDataEnvio());
		pedido.setStatus(pedidoInserirDto.getStatus());
		pedido.setCliente(pedidoInserirDto.getCliente());
		
		List<ItemPedido> pedidoItens = new ArrayList<>();
		
		
		for (PedidoItemInserirDto pedidoItemInserirDto : pedidoInserirDto.getPedidoItemInserirDto()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setPedido(pedido);
			itemPedido.setPercentualDesconto(pedidoItemInserirDto.getPercentualDesconto());
			itemPedido.setQuantidade(pedidoItemInserirDto.getQuantidade());
			
			pedidoItens.add(itemPedido);
		}
		
		pedido = pedidoRepository.save(pedido);
	return pedido;
		
	}
}
