package org.br.serratec.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.br.serratec.domain.Produto;
import org.br.serratec.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping
	@ApiOperation(value = "Lista todos os produtos", notes = "Listagem de produtos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todas os produtos"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Produto>> buscar() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um produto", notes = "produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um produto"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto.get());
	}
	@PostMapping
	@ApiOperation(value = "Insere os dados de um produto", notes = "Inserir produto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Produto adicionado"),
	@ApiResponse(code = 401, message = "Erro de autenticação"),
	@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
	@ApiResponse(code = 404, message = "Recurso não encontrado"),
	@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Produto> inserir(@Valid @RequestBody Produto produto) {
		produto = produtoRepository.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza dados de um produto", notes="Atualizar produto")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Produto atualizado"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		produto = produtoRepository.save(produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="Remove um produto", notes="Remover produto")
	@ApiResponses(value= {
	@ApiResponse(code=200, message="Produto removido"),
	@ApiResponse(code=204, message="Sem conteúdo"),
	@ApiResponse(code=401, message="Erro de autenticação"),
	@ApiResponse(code=403, message="Não há permissão para acessar o recurso"),
	@ApiResponse(code=404, message="Recurso não encontrado"),
	@ApiResponse(code=505, message="Exceção interna da aplicação"),
	})
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Produto> produtoBanco = produtoRepository.findById(id);
		if (!produtoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
}
