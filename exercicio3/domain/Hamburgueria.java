package exercicio3.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Hamburgueria {

	private String nome;
	private List< Pedido > pedidos;
	private List< Cliente > clientes;

	public Hamburgueria( String nome ) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public List< Cliente > getClientes() {
		return clientes;
	}

	public void addCliente( Cliente cliente ) {
		this.clientes.add( cliente );
	}

	public void addPedido( Pedido pedido ) {
		this.pedidos.add( pedido );
	}

	public List< Pedido > listPedidoDia( String data ) {
		return this.pedidos
				.stream()
				.filter( pedido -> data.equals( pedido.getData() ) )
				.collect( Collectors.toList() );
	}

	public Optional< Pedido > getPedidoPorID( Integer id ) {
		return this.pedidos
			.stream()
			.filter( pedido -> pedido.getNumeroPedido() == id )
			.findFirst();
	}
	
	public void updatePedido( Pedido pedido ) {
		int index = this.pedidos.indexOf( pedido );
		this.pedidos.set( index, pedido );
	}
 
}
