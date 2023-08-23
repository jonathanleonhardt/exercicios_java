package br.com.syonet.quarkus.exemploUsoPanache.PanacheRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "devs" )
public class Desenvolvedor {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "ds_nome" )
	private String nome;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
