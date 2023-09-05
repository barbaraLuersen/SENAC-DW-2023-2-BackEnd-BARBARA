package br.sc.senac.dw.exemplos.dw.model.seletor;

import java.time.LocalDate;

public class ProdutoSeletor extends BaseSeletor {

	private String nome;
	private String nomeFabricante;
	private Double valorMinimo;
	private Double valorMaximo;
	private Double pesoMinimo;
	private Double pesoMaximo;
	private LocalDate dataCadastroInicial;
	private LocalDate dataCadastroFinal;
	private String cnpjFabricante;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
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

	public String getCnpjFabricante() {
		return cnpjFabricante;
	}

	public void setCnpjFabricante(String cnpjFabricante) {
		this.cnpjFabricante = cnpjFabricante;
	}
}
