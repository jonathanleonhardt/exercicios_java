package exercicios.vendasveiculos.domain;

import java.util.List;

public class Livraria {
	private String nomeLoja;
	private List< ItemLivraria > itens;

	public Livraria( String nomeLoja, List< ItemLivraria > itens ) {
		this.nomeLoja = nomeLoja;
		this.itens = itens;
	}

	public void addItem( ItemLivraria item ) {
		this.itens.add( item );
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja( String nomeLoja ) {
		this.nomeLoja = nomeLoja;
	}

	public List< ItemLivraria > getItens() {
		return itens;
	}

	public void setItens( List< ItemLivraria > itens ) {
		this.itens = itens;
	}

}
