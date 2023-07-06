package exercicio2.business;

import java.util.List;
import java.util.Optional;

import exercicio2.domain.Artigo;
import exercicio2.domain.ItemLivraria;
import exercicio2.domain.Jornal;
import exercicio2.domain.Livraria;
import exercicio2.domain.Livro;
import exercicio2.domain.Reportagem;
import exercicio2.domain.Revista;

public class LivrariaBusiness {

	private Livraria livraria;

	public LivrariaBusiness( Livraria livraria ) {
		this.livraria = livraria;
	}

	// Listagem dos itens
	public void listaItensParaVenda() {
		System.out.println(" Seja bem-vindo a livraria " + this.livraria.getNomeLoja() );
		System.out.println(" --> ITEM A VENDA: ");
		this.livraria.getItens().stream().forEach( ItemLivraria::imprimeItem );
	}

	// - Inclusão de um novo item;
	public void addLivro( int id, String titulo, String data, Float valor, String editora ) {
		this.addItemParaVenda( new Livro( id, titulo, data, valor, editora ) );
	}
	public void addRevista( int id, String titulo, String data, Float valor, int numeroEdicao, List< Artigo > artigos ) {
		this.addItemParaVenda( new Revista( id, titulo, data, valor, numeroEdicao, artigos ) );
	}
	public void addJornal( int id, String titulo, String data, Float valor, List< Reportagem > reportagens ) {
		this.addItemParaVenda( new Jornal( id, titulo, data, valor, reportagens ) );
	}
	private void addItemParaVenda( ItemLivraria itemLivraria ) {
		this.livraria.addItem( itemLivraria );
	}



	public List< ItemLivraria > getItensLivraria() {
		return this.livraria.getItens();
	}

	// - Alteração de informações de um item já existente;
	public void updateItem( ItemLivraria itemAtualizado ) {
		Optional<ItemLivraria> itemOptional = this.livraria.getItens()
			.stream()
			.filter( item -> item.getId() == itemAtualizado.getId() )
			.findFirst();
		if( itemOptional.isPresent() ) {
			ItemLivraria itemAntigo = itemOptional.get();
			int index = this.livraria.getItens().indexOf( itemAntigo );
			this.livraria.getItens().set( index, itemAtualizado );
		}
	}

	// - Modalidades de venda
	public void vendeItens( boolean isEstudando, List<ItemLivraria> itens ) {
		System.out.println( " COMPRANDO ITENS DA LIVRARIA - ESTUDANTE: " + isEstudando );
		float totalValor = 0f;
		System.out.println( "-- itens na sacola: " );
		for (ItemLivraria item : itens) {
			System.out.println( 
				"Titulo: " + item.getTitulo() +
				"\nValor: " + item.getValor());
			boolean isJornal = item instanceof Jornal;
			boolean temDesconto = isEstudando && !isJornal;
			float valorItem = temDesconto ? 
					item.getValor() * 0.5f :
					item.getValor();
			totalValor += valorItem;
		}
		System.out.println( "TOTAL: " + totalValor );
	}

}
