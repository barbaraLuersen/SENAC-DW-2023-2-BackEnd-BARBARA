package br.sc.senac.dw.exemplos.dw.model.entidade;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Anotação do lombok para gerar getters, setters e construtor vazio (não descobri ainda porque não gerou o construtor com todos os argumentos)
//TODO ver esse artigo ("BUGFIX"): 
//https://stackoverflow.com/questions/62168522/spring-boot-rest-api-returns-empty-json-used-with-lombok
//@Data

//Anotação do JPA para determinar que esta classe é uma entidade (objeto será gerenciado pelo container)
//Anotação do JPA para associar a entidade a uma tabela do banco
//Nome da tabela no banco, caso nada seja informado é considerado o nome da classe da entidade

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double valor;
	private double peso;
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;

	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	private Fabricante fabricanteDoProduto;

	public Produto(Integer id, String nome, Fabricante fabricanteDoProduto, double valor, double peso,
			LocalDate dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.peso = peso;
		this.dataCadastro = dataCadastro;
		this.fabricanteDoProduto = fabricanteDoProduto;
	}

	public Produto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Fabricante getFabricanteDoProduto() {
		return fabricanteDoProduto;
	}

	public void setFabricanteDoProduto(Fabricante fabricanteDoProduto) {
		this.fabricanteDoProduto = fabricanteDoProduto;
	}
}
