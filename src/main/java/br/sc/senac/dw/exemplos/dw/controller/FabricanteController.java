package br.sc.senac.dw.exemplos.dw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exemplos.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.exemplos.dw.model.entidade.Fabricante;
import br.sc.senac.dw.exemplos.dw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.exemplos.dw.service.FabricanteService;

@RestController
@RequestMapping(path = "/api/fabricantes")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5500" }, maxAge = 3600)
public class FabricanteController {

	@Autowired
	private FabricanteService fabricanteService;

	@PostMapping
	public Fabricante salvar(@RequestBody Fabricante novoFabricante) throws CampoInvalidoException {
		return fabricanteService.inserir(novoFabricante);
	}

	@PostMapping("/filtro")
	public List<Fabricante> listarComSeletor(@RequestBody FabricanteSeletor seletor) {
		return fabricanteService.listarComSeletor(seletor);
	}
	
	@GetMapping(path = "/todos")
	public List<Fabricante> listarTodos() {
			return fabricanteService.listarTodos();
	}

}
