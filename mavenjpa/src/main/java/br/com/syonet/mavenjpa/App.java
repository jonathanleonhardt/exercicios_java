package br.com.syonet.mavenjpa;

import java.util.ArrayList;
import java.util.List;

import br.com.syonet.mavenjpa.exercicio1.domain.Cliente;
import br.com.syonet.mavenjpa.exercicio1.domain.Item;
import br.com.syonet.mavenjpa.exercicio1.service.ItemService;
import br.com.syonet.mavenjpa.utils.JPAService;

/**
 * Hello world!
 *
 */
public class App {

	private static JPAService jpa = JPAService.getInstance();

	public static void main( String[] args ) {

		System.out.println( "LISTA DE ITENS ANTES DA OPERAÇÃO" );
		System.out.println( ItemService.getItensCliente( 1 ) );

		Cliente cliente = getCliente( 1 );
		System.out.println( "Cliente banco: " + cliente );

		List< Item > itens = new ArrayList<>();
		itens.add( new Item( 1, cliente ) );
		itens.add( new Item( 2, cliente ) );
		itens.add( new Item( 3, cliente ) );
		itens.add( new Item( 7, cliente ) );
		itens.add( new Item( 8, cliente ) );
		itens.add( new Item( 9, cliente ) );

		ItemService.atualizaListItensCliente( 1, itens);

		System.out.println( "LISTA DE ITENS DEPOIS DA OPERAÇÃO" );
		System.out.println( ItemService.getItensCliente( 1 ) );
	}

	public static Cliente getCliente( Integer idCliente ) {
		return jpa.runOperation( manager -> manager.createQuery(
				"select c from Cliente c where c.id = " + idCliente,
				Cliente.class
			).getSingleResult() );
	}
}
