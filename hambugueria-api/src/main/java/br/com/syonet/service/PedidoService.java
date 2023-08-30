package br.com.syonet.service;

import java.util.List;

import br.com.syonet.domain.Pedido;
import br.com.syonet.domain.StatusEnum;
import br.com.syonet.repository.IPedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PedidoService {

    @Inject
    IPedidoRepository repo;

    public void create( Pedido pedido ) throws IllegalArgumentException {
        if ( pedido.getId() != null ) {
            throw new IllegalArgumentException( "Pedido não será inserido pois veio com ID" );
        }
        repo.save( pedido );
    }

    public void update( Pedido pedido ) throws IllegalArgumentException {
        if ( pedido.getId() == null ) {
            throw new IllegalArgumentException( "Pedido não será atualizadp pois veio sem ID" );
        }
        repo.save( pedido );
    }

    public List< Pedido > getByDataStatus( Long data, StatusEnum status ) {
        if ( data != null && status != null ) {
            return repo.listByDataAndStatus( data, status );
        }
        if ( data != null ) {
            return repo.listByData( data );
        }
        return repo.listByStatus( status );
    }

}
