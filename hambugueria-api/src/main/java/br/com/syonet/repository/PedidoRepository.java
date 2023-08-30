package br.com.syonet.repository;

import java.util.List;
import java.util.Optional;

import br.com.syonet.domain.Pedido;
import br.com.syonet.domain.StatusEnum;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoRepository implements PanacheRepositoryBase< Pedido, Integer >, IPedidoRepository {

    @Override
    public void save( Pedido pedido ) {
        Optional< Pedido > pedidoOpt = findByIdOptional( pedido.getId() );

        pedidoOpt.ifPresentOrElse( registro -> {
            registro.setDescricao( pedido.getDescricao() );
            registro.setStatus( pedido.getStatus() );
            registro.setData( pedido.getData() );
            this.persistAndFlush( registro );
        }, () -> {
            pedido.setData( System.currentTimeMillis() );
            persist( pedido );
        });
    }

    @Override
    public List< Pedido > listByStatus( StatusEnum status ) {
       return list( "status = ?1", status );
    }

    @Override
    public List< Pedido > listByData( Long data ) {
        return list( "data = ?1", data );
    }

    @Override
    public List< Pedido > listByDataAndStatus( Long data, StatusEnum status ) {
        return list( "data = ?1 and status = ?2", data, status );
    }
    
}
