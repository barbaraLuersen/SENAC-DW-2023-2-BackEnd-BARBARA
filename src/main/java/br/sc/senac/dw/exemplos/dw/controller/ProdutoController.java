package br.sc.senac.dw.exemplos.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;
import br.sc.senac.dw.exemplos.dw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

	// Anteriormente faziamos:
	// private ProdutoBO bo = new ProdutoBO();

	@Autowired // injeção de dependência (tomcat
	private ProdutoService produtoService;

	@GetMapping(path = "/todos")
	public List<Produto> listarTodosProdutos() {
		return produtoService.listarTodos();
	}
	
	@GetMapping(path = "/{id}")
	public Produto consultarPorId(@PathVariable Integer id) {
		return produtoService.consultarPorId(id.longValue());
	}
}
