package br.sc.senac.dw.exemplos.dw.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.exemplos.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;
import br.sc.senac.dw.exemplos.dw.model.repository.ProdutoRepository;
import br.sc.senac.dw.exemplos.dw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.exemplos.dw.model.specification.ProdutoSpecification;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// Listagem de métodos
	@Transactional
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto consultarPorId(Long id) {
		return produtoRepository.findById(id.longValue()).get();
	}

	public Produto inserir(Produto novoProduto) throws CampoInvalidoException {
		validarCamposObrigatorios(novoProduto);
		return produtoRepository.save(novoProduto);
	}

	public Object atualizar(Produto produtoParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(produtoParaAtualizar);
		return produtoRepository.save(produtoParaAtualizar);
	}

	public boolean excluir(Integer id) {
		produtoRepository.deleteById(id.longValue());
		return true;
	}

	// TODO public boolean excluirPorCpf

	private void validarCamposObrigatorios(Produto produto) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(produto.getNome(), "nome");
		// mensagemValidacao += validarCampoString(produto.getFabricante(),
		// "fabricante");
		mensagemValidacao += validarCampoDouble(produto.getValor(), "valor");
		mensagemValidacao += validarCampoDouble(produto.getPeso(), "peso");

		if (!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if (valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}

		return "";
	}

	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if (valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	public List<Produto> listarComSeletor(ProdutoSeletor seletor) {
		// https://www.baeldung.com/spring-data-jpa-query-by-example
		Specification<Produto> specification = ProdutoSpecification.comFiltros(seletor);
		return produtoRepository.findAll(specification);
	}

}
