package br.sc.senac.dw.exemplos.dw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.exemplos.dw.model.entidade.Fabricante;
import br.sc.senac.dw.exemplos.dw.model.seletor.FabricanteSeletor;
import jakarta.persistence.criteria.Predicate;

public class FabricanteSpecification {

	public static Specification<Fabricante> comFiltros(FabricanteSeletor seletor) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			// FILTRAR "FABRICANTE.NOME"
			if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
				// WHERE/AND COLUNA OPERADOR VALOR
				predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			// FILTRAR "FABRICANTE.CNPJ"
			if (seletor.getCnpj() != null && !seletor.getCnpj().isEmpty()) {
				// WHERE p.fabricante like '%Rider%'
				// WHERE f.nome like '%Rider%'
				// JPQL = Java Persistence Query Language
				predicates.add(cb.equal(root.get("cnpj"), seletor.getCnpj()));
			}

			// FILTRAR "FABRICANTE.CIDADE"
			if (seletor.getCidade() != null && !seletor.getCidade().isEmpty()) {
				// WHERE/AND COLUNA OPERADOR VALOR
				predicates.add(cb.like(cb.lower(root.get("cidade")), "%" + seletor.getNome().toLowerCase() + "%"));
			}

			// FILTRAR "FABRICANTE.CEP"
			if (seletor.getCep() != null && !seletor.getCep().isEmpty()) {
				// WHERE/AND COLUNA OPERADOR VALOR
				predicates.add(cb.equal(root.get("cep"), seletor.getCnpj()));
			}

			// FILTRAR "FABRICANTE.UF"
			if (seletor.getUf() != null && !seletor.getUf().isEmpty()) {
				// WHERE/AND COLUNA OPERADOR VALOR
				predicates.add(cb.equal(root.get("uf"), seletor.getCnpj()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}