package br.sc.senac.dw.exemplos.dw.model.seletor;

import java.time.LocalDate;

public abstract class ProdutoSeletor extends BaseSeletor {

	private String nome;
	private String fabricante;
	private Double valorMinimo;
	private Double valorMaximo;
	private Double pesoMinimo;
	private Double pesoMaximo;
	private LocalDate dataCadastroInicial;
	private LocalDate dataCadastroFinal;

	public ProdutoSeletor(int pagina, int limite, String nome, String fabricante, Double valorMinimo,
			Double valorMaximo, Double pesoMinimo, Double pesoMaximo, LocalDate dataCadastroInicial,
			LocalDate dataCadastroFinal) {
		super(pagina, limite);
		this.nome = nome;
		this.fabricante = fabricante;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.pesoMinimo = pesoMinimo;
		this.pesoMaximo = pesoMaximo;
		this.dataCadastroInicial = dataCadastroInicial;
		this.dataCadastroFinal = dataCadastroFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Double getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Double valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public Double getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(Double pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public Double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public LocalDate getDataCadastroInicial() {
		return dataCadastroInicial;
	}

	public void setDataCadastroInicial(LocalDate dataCadastroInicial) {
		this.dataCadastroInicial = dataCadastroInicial;
	}

	public LocalDate getDataCadastroFinal() {
		return dataCadastroFinal;
	}

	public void setDataCadastroFinal(LocalDate dataCadastroFinal) {
		this.dataCadastroFinal = dataCadastroFinal;
	}
}
