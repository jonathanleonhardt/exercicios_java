package br.com.syonet.mavenjpa.exercicio1.service;

import java.util.List;

import br.com.syonet.mavenjpa.exercicio1.domain.Cliente;
import br.com.syonet.mavenjpa.exercicio1.domain.Item;
import br.com.syonet.mavenjpa.utils.JPAService;

public class ItemService {

	// se a lista tiver vazia, deleta os itens do banco
	// remoção de itens q n existem mais
	// inclusao de itens novos
	// sem usar deleteAll

	private static JPAService jpa = JPAService.getInstance();

	public static void atualizaListItensCliente( Integer idCliente, List< Item > newItens ) {

		List< Item > itens = getItensCliente( idCliente );

		if ( newItens.isEmpty() ) {
			deleteAllItens( itens );
			return;
		}

		deleteOldItens( newItens, itens );
		insertNewItens( newItens, itens );
	}

	public static void deleteAllItens( List< Item > itens ) {
		itens.forEach( item -> deletaItem( item ) );
	}

	private static void insertNewItens( List< Item > newItens, List< Item > oldItens ) {
		newItens.stream()
			.forEach( newItem -> {
				if ( !isItemDuplicado( newItem, oldItens ) ) {
					System.out.println( "ITEM INSERT" + newItem);
					insertItem( newItem );
				}
			} );
	}

	private static void deleteOldItens( List< Item > newItens, List< Item > itens ) {
		itens.stream()
			.forEach( item -> {
				System.out.println(" ITEM ATUAL: " + item );
				System.out.println(" LISTA NEW ITENS: " + newItens );
				if ( !isItemDuplicado( item, newItens ) ) {
					deletaItem( item );
				}
			} );
	}

	public static void deletaItem( Item item ) {
		jpa.runOperation( manager -> {
				Item toRemove = manager.find( Item.class, item.getId() );
				manager.remove( toRemove );
				return null;
			} );
	}

	private static boolean isItemDuplicado( Item item, List< Item > itensList ) {
		return itensList.stream()
				.filter( newItem -> newItem.getId() == item.getId() )
				.findFirst()
				.isPresent();
	}

	public static List < Item > getItensCliente( Integer idCliente ) {
		return jpa.runOperation( manager -> manager.createQuery(
				"select i from Item i where i.cliente = " + idCliente,
				Item.class
			).getResultList() );
	}

	

	public static void insertItem( Item item ) {
		jpa.runOperation( manager -> {
				Cliente cliente = manager.createQuery(
						"select c from Cliente c where c.id = " + item.getCliente().getId(),
						Cliente.class
				).getSingleResult();
				item.setCliente( cliente );
				manager.persist( manager.merge( item ) );
				return null;
			} );
	}
	
}
