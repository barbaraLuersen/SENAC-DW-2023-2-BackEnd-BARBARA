package br.sc.senac.dw.exemplos.dw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.exemplos.dw.model.entidade.Produto;
import br.sc.senac.dw.exemplos.dw.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto consultarPorId(Long id) {
		return produtoRepository.findById(id.longValue()).get();
	}
}
