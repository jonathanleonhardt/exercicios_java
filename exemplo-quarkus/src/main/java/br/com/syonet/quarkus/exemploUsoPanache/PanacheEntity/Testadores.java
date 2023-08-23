package br.com.syonet.quarkus.exemploUsoPanache.PanacheEntity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Testadores extends PanacheEntity {

	@Column( name = "ds_nome" )
	private String nome;

	public List < Testadores > listAlguns( String pedacoNome ) {
		// posso usar HQL
		return list( "nome like ", pedacoNome);
	}
	
}
