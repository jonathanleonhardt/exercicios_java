package exercicios.hamburgueria.business.menuPedido;

import exercicios.hamburgueria.domain.Cliente;
import exercicios.hamburgueria.domain.Pedido;
import exercicios.hamburgueria.enumeration.StatusPedidoEnum;

public interface IMenuPedidoBusiness {

	void cadastraPedido( Pedido pedido );
	void verificaStatusPedido( Integer numeroPedido );
	void verificaStatusPedidoCliente( Cliente cliente );
	void atualizaStatusPedido( Integer numeroPedido, StatusPedidoEnum novoStatus );

}
