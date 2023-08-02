package br.com.syonet.mavenjpa.exercicio1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "syo_item" )
public class Item {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn( name = "id_cliente", referencedColumnName = "id" )
	private Cliente cliente;

	public Item(){};

	public Item( Integer id, Cliente cliente ) {
		this.id = id;
		this.cliente = cliente;
	}

	public void setCliente( Cliente cliente ) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "\nItem [id=" + id + ", cliente=" + cliente + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

}
