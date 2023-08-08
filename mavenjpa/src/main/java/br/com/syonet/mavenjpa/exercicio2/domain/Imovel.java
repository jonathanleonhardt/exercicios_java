package br.com.syonet.mavenjpa.exercicio2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "syo_imovel" )
public class Imovel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "ds_descricao" )
	private String descricao;

	@Column( name = "nm_valor" )
	private Float valor;

	@ManyToOne
	@JoinColumn( name = "id_condominio", referencedColumnName = "id" )
	private Condominio condominio;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor( Float valor ) {
		this.valor = valor;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio( Condominio condominio ) {
		this.condominio = condominio;
	}

}
