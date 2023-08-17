package br.sc.senac.dw.exemplos.dw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
