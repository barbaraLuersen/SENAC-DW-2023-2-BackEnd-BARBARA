package br.sc.senac.dw.exemplos.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exemplos.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;
import br.sc.senac.dw.exemplos.dw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.exemplos.dw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class ProdutoController {

	// Anteriormente faziamos:
	// private ProdutoBO bo = new ProdutoBO();

	@Autowired // injeção de dependência (tomcat
	private ProdutoService produtoService;

	/**
	 * Método GET: geralmente utilizado em consultas Parâmetros podem ser enviados
	 * via URL
	 * 
	 * @return a lista de todas os produtos
	 */
	@GetMapping(path = "/todos")
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}

	// NO SERVICE:
	// public List<Produto> listarTodos() {
	// return produtoRepository.findAll();
	// }

	/**
	 * Método GET Parâmetro id foi enviado via URL
	 * 
	 * @return um produto específico, dado o seu id
	 */
	@GetMapping(path = "/{id}")
	public Produto consultarPorId(@PathVariable Integer id) {
		return produtoService.consultarPorId(id.longValue());
	}

	/**
	 * Método POST: geralmente utilizado para inserir novos registros Parâmetros são
	 * enviados no corpo da requisição HTTP, para isso usamos a notação @RequestBody
	 *
	 * @return o produto salvo, com id produto
	 * @throws CampoInvalidoException
	 */
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) throws CampoInvalidoException {
		return produtoService.inserir(novoProduto);
	}

	@PostMapping("/filtro")
	public List<Produto> listarComSeletor(@RequestBody ProdutoSeletor seletor) {
		return produtoService.listarComSeletor(seletor);
	}

	/**
	 * Método PUT: utilizado para atualizar registros. Muitas vezes é usado o POST
	 * em seu lugar Parâmetros são enviados no corpo da requisição HTTP, para isso
	 * usamos a anotação @RequestBody
	 * 
	 * @return um booleano indicando se o produto em questão foi atualizado
	 * @throws CampoInvalidoException
	 */
	@PutMapping()
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException {
		return produtoService.atualizar(produtoParaAtualizar) != null;
	}

	/**
	 * Método DELETE Parâmetro id foi enviado via URL
	 */
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return produtoService.excluir(id);
	}

}
