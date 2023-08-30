package br.com.syonet.service;

import java.util.List;

import br.com.syonet.domain.Cliente;
import br.com.syonet.repository.IClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClienteService {

    @Inject
    IClienteRepository repo;

    public void create( Cliente cliente ) throws IllegalArgumentException {
        if ( cliente.getId() != null ) {
            throw new IllegalArgumentException( "Cliente não será inserido pois veio com ID" );
        }
        repo.save( cliente );
    }

    public void update( Cliente cliente ) throws IllegalArgumentException {
        if ( cliente.getId() == null ) {
            throw new IllegalArgumentException( "Cliente não será atualizadp pois veio sem ID" );
        }
        repo.save( cliente );
    }

    public List< Cliente > getByEmailDocument( String email, String documento ) {
        if ( email != null && documento != null ) {
            return repo.listClienteByDocumentoAndEmail( documento, email );
        }
        if ( email != null ) {
            return repo.listClienteByEmail( email );
        }
        return repo.listClienteByDocumento( documento );
    }

}
