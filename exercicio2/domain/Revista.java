package exercicio2.domain;

import java.util.List;

public class Revista extends ItemLivraria {

	private int numeroEdicao;
	private List< Artigo > artigos;

	public Revista( int id, String titulo, String data, Float valor, 
		int numeroEdicao, List< Artigo > artigos ) {
		super( id, titulo, data, valor );
		this.numeroEdicao = numeroEdicao;
		this.artigos = artigos;
	}

	public int getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao( int numeroEdicao ) {
		this.numeroEdicao = numeroEdicao;
	}

	public List< Artigo > getArtigos() {
		return artigos;
	}

	public void setArtigos( List< Artigo > artigos ) {
		this.artigos = artigos;
	}

	@Override
	public void imprimeItem() {
		System.out.println( "\n\n .:: REVISTA ::. " );
		super.imprimeItem();
		System.out.println( "Num. edição: " +  this.numeroEdicao );
		this.artigos.forEach( Artigo::imprimeArtigo );
	}

}
