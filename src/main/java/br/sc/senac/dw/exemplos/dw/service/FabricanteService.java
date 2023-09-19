package br.sc.senac.dw.exemplos.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.exemplos.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplos.dw.model.entidade.Fabricante;
import br.sc.senac.dw.exemplos.dw.model.repository.FabricanteRepository;
import br.sc.senac.dw.exemplos.dw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.exemplos.dw.model.specification.FabricanteSpecification;
import jakarta.transaction.Transactional;

@Service
public class FabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;

	@Transactional
	public Fabricante inserir(Fabricante novoFabricante) throws CampoInvalidoException {
		validarCamposObrigatorios(novoFabricante);
		return fabricanteRepository.save(novoFabricante);
	}

	private void validarCamposObrigatorios(Fabricante fabricante) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(fabricante.getNome(), "nome");
		mensagemValidacao += validarCampoString(fabricante.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(fabricante.getCidade(), "cidade");
		mensagemValidacao += validarCampoString(fabricante.getCep(), "cep");
		mensagemValidacao += validarCampoString(fabricante.getUf(), "uf");

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

	public List<Fabricante> listarComSeletor(FabricanteSeletor seletor) {
		// https://www.baeldung.com/spring-data-jpa-query-by-example
		Specification<Fabricante> specification = FabricanteSpecification.comFiltros(seletor);
		return fabricanteRepository.findAll(specification);
	}

}
