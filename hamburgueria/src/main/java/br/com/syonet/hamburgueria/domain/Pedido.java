package br.com.syonet.hamburgueria.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "syo_pedido" )
public class Pedido {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;
 
	@ManyToOne
	@JoinColumn( name = "id_hamburgueria", referencedColumnName = "id", nullable = false )
	private Hamburgueria hamburgueria;

	@Column( name = "dt_inc", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataInc = LocalDateTime.now();

	@Column( name = "ds_pedido", columnDefinition = "text default 'sem itens no pedido'")
	private String desciption;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public Hamburgueria getHamburgueria() {
		return hamburgueria;
	}

	public void setHamburgueria( Hamburgueria hamburgueria ) {
		this.hamburgueria = hamburgueria;
	}

	public LocalDateTime getDataInc() {
		return dataInc;
	}

	public void setDataInc( LocalDateTime dataInc ) {
		this.dataInc = dataInc;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption( String desciption ) {
		this.desciption = desciption;
	}

	
}
