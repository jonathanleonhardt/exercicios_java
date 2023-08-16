package br.com.exemplo.api.exercicio.enums;

public enum QueryParam {

	REGIAO( "regiao" ),
	ESTADO( "estado" );

	private final String queryParamString;

	private QueryParam( String queryParamString ) {
		this.queryParamString = queryParamString;
	}
	
	public String getQueryParamString() {
		return queryParamString;
	}

}
