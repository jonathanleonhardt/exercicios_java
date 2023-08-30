package br.com.syonet.repository;

import java.util.List;

import br.com.syonet.domain.Cliente;

public interface IClienteRepository {

    void save( Cliente cliente );

    List< Cliente > listClienteByDocumento( String documento );

    List< Cliente > listClienteByEmail( String email );

    List< Cliente > listClienteByDocumentoAndEmail( String documento, String email );
    
}
