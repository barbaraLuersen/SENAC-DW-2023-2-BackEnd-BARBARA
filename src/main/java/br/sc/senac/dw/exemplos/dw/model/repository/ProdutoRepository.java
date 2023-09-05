package br.sc.senac.dw.exemplos.dw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
	// É possível declarar métodos do JpasRepository aqui, combinando atributos e
	// operadores SQL
}
