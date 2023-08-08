package br.com.syonet.mavenjpa.exercicio2.values;

import java.util.List;

public class CondominioDTO {
	//  new CondominioDTO ( id, nome, imoveis )
	//  	ou
	// new CondominioDTO(); -> condominio.setId( id )

	private Integer id; // "id" : 1
	private String nome;
	private List< ImovelDTO > imoveis;

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

	public List< ImovelDTO > getImoveis() {
		return imoveis;
	}

	public void setImoveis( List< ImovelDTO > imoveis ) {
		this.imoveis = imoveis;
	}

	public static class Builder {

		private Integer id;
		private String nome;
		private List< ImovelDTO > imoveis;

		public Builder withId( Integer id ) {
			this.id = id;
			return this;
		}

		public Builder withNome( String nome ) {
			this.nome = nome;
			return this;
		}

		public Builder withImoveis( List< ImovelDTO > imoveis ) {
			this.imoveis = imoveis;
			return this;
		}

		public CondominioDTO build() {
			CondominioDTO dto = new CondominioDTO();
			dto.setId( this.id );
			dto.setNome( this.nome );
			dto.setImoveis( imoveis );
			return dto;
		}

	}

}
