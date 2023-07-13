package exercicios.vendasveiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exercicios.vendasveiculos.business.LivrariaBusiness;
import exercicios.vendasveiculos.domain.ItemLivraria;
import exercicios.vendasveiculos.domain.Livraria;
import exercicios.vendasveiculos.domain.Livro;
import exercicios.vendasveiculos.domain.Reportagem;

public class App {
	public static void main( String[] args ) {
		Livraria livraria = new Livraria(
				"Lojas Saraiva",
				new ArrayList< ItemLivraria >() );
		LivrariaBusiness business = new LivrariaBusiness( livraria );
		
		// add LIVRO
		business.addLivro( 
				1,
				"cronicas de narnia",
				"01-01-1999",
				60.0f,
				"Saraiva" );

		//add JORNAL
		Reportagem reportagem1 = new Reportagem( 
			"Vida dos animais",
			"xxxxxxxxxx",
			Arrays.asList( "Nome 1","Nome 2" ) );
		business.addJornal(
			2,
			"Jornal do dia",
			"05-07-2023",
			2.50f,
			Arrays.asList( reportagem1 ) );

		// lista itens para venda
		//business.listaItensParaVenda();

		// List< ItemLivraria > itens = business.getItensLivraria();
		// business.vendeItens( true , itens );
		// business.vendeItens( false , itens );

		Livro livro = new Livro(
			1,
			"cronicas de narnia 2",
			"01-01-1999",
			60.0f,
			"Saraiva"
		);
		business.updateItem(livro);
		// lista itens para venda
		// business.listaItensParaVenda();

		System.out.println(" VENDA DE ITENS ");

		List< ItemLivraria > itens = business.getItensLivraria();
		business.vendeItens( true , itens );
		business.vendeItens( false , itens );
		
	}

}
