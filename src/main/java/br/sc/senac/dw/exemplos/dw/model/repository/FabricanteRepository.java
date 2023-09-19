package br.sc.senac.dw.exemplos.dw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.sc.senac.dw.exemplos.dw.model.entidade.Fabricante;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long>, JpaSpecificationExecutor<Fabricante> {

}
