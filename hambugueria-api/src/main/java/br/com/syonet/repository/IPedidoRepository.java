package br.com.syonet.repository;

import java.util.List;

import br.com.syonet.domain.Pedido;
import br.com.syonet.domain.StatusEnum;

public interface IPedidoRepository {

    void save( Pedido pedido );

    List< Pedido > listByStatus( StatusEnum status );

    List< Pedido > listByData( Long data );

    List< Pedido > listByDataAndStatus( Long data, StatusEnum status );

}
