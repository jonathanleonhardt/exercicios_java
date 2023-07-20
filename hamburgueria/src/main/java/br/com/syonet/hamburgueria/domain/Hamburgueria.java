package br.com.syonet.hamburgueria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity( name = "Hamb" )
@Table( name = "syo_hamburgueria" )
public class Hamburgueria {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name  = "name", unique = true, nullable = false )
	private String name;

	@Column( name = "cnpj", length = 14 )
	private String cnpj;
	
	@Enumerated( EnumType.STRING )
	private StatusEnum status;

	@Transient
	private String internalDescription;

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus( StatusEnum status ) {
		this.status = status;
	}

	public String getInternalDescription() {
		return internalDescription;
	}

	public void setInternalDescription( String internalDescription ) {
		this.internalDescription = internalDescription;
	}

	@Override
	public String toString() {
		return "Hamburgueria [id=" + id + ", name=" + name + ", cnpj=" + cnpj
				+ ", status=" + status + ", internalDescription="
				+ internalDescription + "]";
	}

}
