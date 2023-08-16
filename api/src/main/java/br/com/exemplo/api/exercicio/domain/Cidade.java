package br.com.exemplo.api.exercicio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "syo_cidade" )
public class Cidade {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "nome" )
	private String nome;

	@Column( name = "estado" )
	private String estado;

	@Column( name = "regiao" )
	private String regiao;



	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado( String estado ) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao( String regiao ) {
		this.regiao = regiao;
	}

}
