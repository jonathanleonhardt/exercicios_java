package exercicio3.business.menuPedido;

import java.util.Objects;
import java.util.Optional;

import exercicio3.domain.Cliente;
import exercicio3.domain.Hamburgueria;
import exercicio3.domain.Pedido;
import exercicio3.enumeration.StatusPedidoEnum;
import exercicio3.utils.ApoioUtil;

public class MenuBusiness implements IMenuPedidoBusiness, IMenuClienteBusiness {

	private static final Integer MAX_PEDIDOS_POR_DIA = 50;

	private Hamburgueria hamburgueria;

	@Override
	public void cadastraCliente( Cliente cliente ) {
		if ( ApoioUtil.isStringEmpty( cliente.getEndereco() ) ||
			ApoioUtil.isStringEmpty( cliente.getTelefone() ) ) {
			System.out.println( "Cliente não cadastrado, dados imcompletos." );
			return;
		}
		this.hamburgueria.addCliente( cliente );
		System.out.println( "Cliente cadastrado com sucesso!" );
	}

	@Override
	public void cadastraPedido( Pedido pedido ) {
		if ( !this.hamburgueria.getClientes().contains( pedido.getCliente() ) ){
			System.out.println( "Pedido não cadastrado, cliente sem registro no sistema." );
			return;
		}
		if ( this.hamburgueria.listPedidoDia( pedido.getData() ).size() <= MAX_PEDIDOS_POR_DIA ) {
			System.out.println( "Pedido não cadastrado, número maximo de pedidos/dia alcançado." );
			return;
		}
		this.hamburgueria.addPedido( pedido );
		System.out.println( "Pedido realizado." );
	}

	@Override
	public void verificaStatusPedido( Integer numeroPedido ) {
		Optional< Pedido > pedidoOpt = this.findPedidoPorId( numeroPedido );
		if ( pedidoOpt.isEmpty() ) return;
		Pedido pedido = pedidoOpt.get();
		System.out.println( "Status do pedido " + numeroPedido + ": " + pedido.getStatus() );
	}

	@Override
	public void verificaStatusPedidoCliente( Cliente cliente ) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'verificaStatusPedidoCliente'");
	}

	@Override
	public void atualizaStatusPedido( Integer numeroPedido, StatusPedidoEnum novoStatus ) {
		Optional< Pedido > pedidoOpt = this.findPedidoPorId( numeroPedido );
		if ( pedidoOpt.isEmpty() ) return;
		Pedido pedido = pedidoOpt.get();
		pedido.setStatus( novoStatus );
		this.hamburgueria.updatePedido( pedido );
	}

	private Optional< Pedido > findPedidoPorId( Integer numeroPedido ) {
		if ( Objects.isNull( numeroPedido ) || numeroPedido < 0 ) {
			System.out.println( "Numero do pedido inválido." );
			return Optional.empty();
		}
		Optional< Pedido > pedidoOpt = this.hamburgueria.getPedidoPorID( numeroPedido );
		if( pedidoOpt.isEmpty() ) {
			System.out.println( "Pedido não encontrado por ID: " + numeroPedido );
			return Optional.empty();
		}
		return pedidoOpt;
	}
	
}
