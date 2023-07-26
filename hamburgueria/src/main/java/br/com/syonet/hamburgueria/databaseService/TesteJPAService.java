package br.com.syonet.hamburgueria.databaseService;

import java.util.List;

import br.com.syonet.hamburgueria.domain.Hamburgueria;
import br.com.syonet.hamburgueria.domain.Pedido;

public class TesteJPAService {

	private static JPAService service = JPAService.getInstance();

	public static void main(String[] args) {
		Hamburgueria hamburgueria = new Hamburgueria();
		hamburgueria.setCnpj( "12345678912345" );
		hamburgueria.setName( "Burguers" );

		inserHamburguerias( hamburgueria );

		List< Hamburgueria > listaHamburguerias = listHamburguerias();

		System.out.println( "\n\n   ---- Lista de HAMBURGUERIAS: ");
		System.out.println( listaHamburguerias );
		System.out.println( "\n\n   ---- Lista de HAMBURGUERIAS: ");

		Pedido pedido = new Pedido();
		pedido.setDescription("blablabla");
		pedido.setHamburgueria( hamburgueria );

		insertPedido( pedido );
		insertPedido( pedido );
		insertPedido( pedido );

		List< Pedido > listaPedidos = listPedidos();

		System.out.println( "\n\n   ---- Lista de PEDIDOS: ");
		System.out.println( listaPedidos );
		System.out.println( "\n\n   ---- Lista de PEDIDOS: ");
	}

	private static List< Hamburgueria > listHamburguerias() {
		return service.runOperation( manager -> manager.createQuery(
				"select h from Hamb h",
				Hamburgueria.class
			).getResultList()  );
	}

	private static void inserHamburguerias ( Hamburgueria hamburgueria ) {
		service.runOperation( manager -> {
				manager.persist( hamburgueria );
				return null;
			} );
	}

	private static void insertPedido ( Pedido pedido ) {
		service.runOperation( manager -> {
				manager.persist( pedido );
				return null;
			} );
	}

	private static List< Pedido > listPedidos() {
		return service.runOperation( manager -> manager.createQuery(
				"select p from Pedido p",
				Pedido.class
			).getResultList()  );
	}
}
