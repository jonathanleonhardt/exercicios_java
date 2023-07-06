package exercicio3.business.menuPedido;

import exercicio3.domain.Cliente;
import exercicio3.domain.Pedido;
import exercicio3.enumeration.StatusPedidoEnum;

public interface IMenuPedidoBusiness {

	void cadastraPedido( Pedido pedido );
	void verificaStatusPedido( Integer numeroPedido );
	void verificaStatusPedidoCliente( Cliente cliente );
	void atualizaStatusPedido( Integer numeroPedido, StatusPedidoEnum novoStatus );

}
