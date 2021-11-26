package Entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais implements Serializable {
	
	@Id
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identificador;
	@NotBlank
	@Column(unique = true)
	private String nome;
	@NotBlank
	private String capital;
	@Column(unique = true)
	private String regiao;
	@NotBlank
	private String subregiao;
	@NotBlank
	private String area;
	
	public Pais(int identificador, @NotBlank String nome, @NotBlank String capital, String regiao,
			@NotBlank String subregião, @NotBlank String area) {
		super();
		this.identificador = identificador;
		this.nome = nome;
		this.capital = capital;
		this.regiao = regiao;
		this.subregiao = subregião;
		this.area = area;
	}

	public Pais() {
		
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSubregiao() {
		return subregiao;
	}

	public void setSubregiao(String subregião) {
		this.subregiao = subregião;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Pais [identificador=" + identificador + ", nome=" + nome + ", capital=" + capital + ", regiao=" + regiao
				+ ", subregião=" + subregiao + ", area=" + area + "]";
	}
	
	
	
	
	
	}
