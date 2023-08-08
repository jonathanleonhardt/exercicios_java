package br.com.syonet.mavenjpa.exercicio2.values;

public class ImovelDTO {

	private Integer id;
	private String descricao;
	private Float valor;

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

	public static class Builder {

		private Integer id;
		private String descricao;
		private Float valor;

		public Builder withId( Integer id ) {
			this.id = id;
			return this;
		}

		public Builder withDescricao( String descricao ) {
			this.descricao = descricao;
			return this;
		}

		public Builder withValor( Float valor ) {
			this.valor = valor;
			return this;
		}

		public ImovelDTO build() {
			ImovelDTO dto = new ImovelDTO();
			dto.setId( this.id );
			dto.setDescricao( this.descricao );
			dto.setValor( this.valor );
			return dto;
		}

	}

}
