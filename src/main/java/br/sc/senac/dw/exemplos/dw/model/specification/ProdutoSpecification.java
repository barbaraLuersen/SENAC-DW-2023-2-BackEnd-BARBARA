package br.sc.senac.dw.exemplos.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;
import br.sc.senac.dw.exemplos.dw.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoSpecification {

	/*
	 * root: é uma referência à entidade raiz que você está consultando. No contexto
	 * do JPA, isso representa a tabela do banco de dados correspondente à entidade
	 * Produto.
	 * 
	 * query: O parâmetro query representa a consulta JPA que está sendo construída.
	 * Ele é usado para adicionar cláusulas WHERE, JOIN, ORDER BY, entre outras, à
	 * consulta.
	 * 
	 * cb (CriteriaBuilder): é uma interface que oferece métodos para construção de
	 * cláusulas de consulta de forma programática. Você usa métodos deste objeto
	 * para criar expressões de predicado, funções agregadas e outras partes da
	 * consulta.
	 * 
	 */

	public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			// COMO FILTRAR "PRODUTO.NOME"
			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				// WHERE/AND COLUNA OPERADOR VALOR
				// WHERE nome like %Café%
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			// COMO FILTRAR POR "FABRICANTES.NOME"
			if (seletor.getNomeFabricante() != null && !seletor.getNomeFabricante().isEmpty()) {
				// WHERE p.fabricante like '%Rider%'
				// WHERE f.nome like '%Rider%'
				// JPQL = Java Persistence Query Language
				predicates.add(
						cb.like(root.join("fabricanteDoProduto").get("nome"), "%" + seletor.getNomeFabricante() + "%"));
			}

			// COMO FILTRAR POR "PRODUTO.PESO"
			if (seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
				// WHERE peso BETWEEN min AND max
				predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), seletor.getPesoMaximo()));
			} else if (seletor.getPesoMinimo() != null) {
				// WHERE peso >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
			} else if (seletor.getPesoMaximo() != null) {
				// WHERE peso <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
			}

			// COMO FILTRAR POR "PRODUTO.VALOR"
			if (seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
				// WHERE valor BETWEEN min AND max
				predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), seletor.getValorMaximo()));
			} else if (seletor.getValorMinimo() != null) {
				// WHERE valor >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
			} else if (seletor.getValorMinimo() != null) {
				// WHERE valor <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
			}

			// COMO FILTRAR POR "PRODUTO.DATA"
			if (seletor.getDataCadastroInicial() != null && seletor.getDataCadastroFinal() != null) {
				// WHERE data BETWEEN min AND max
				predicates.add(
						cb.between(root.get("data"), seletor.getDataCadastroInicial(), seletor.getDataCadastroFinal()));
			} else if (seletor.getDataCadastroInicial() != null) {
				// WHERE data >= min
				predicates.add(cb.greaterThanOrEqualTo(root.get("data"), seletor.getDataCadastroInicial()));
			} else if (seletor.getDataCadastroFinal() != null) {
				// WHERE data <= max
				predicates.add(cb.lessThanOrEqualTo(root.get("data"), seletor.getDataCadastroFinal()));
			}

			// COMO FILTRAR POR "FABRICANTE.CNPJ"
			if (seletor.getCnpjFabricante() != null && !seletor.getCnpjFabricante().isEmpty()) {
				// WHERE p.fabricante like '%Rider%'
				// WHERE f.nome like '%Rider%'
				// JPQL = Java Persistence Query Language
				predicates.add(cb.equal(root.join("fabricanteDoProduto").get("cnpj"), seletor.getCnpjFabricante()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
