package br.com.syonet.repository;

import java.util.List;
import java.util.Optional;

import br.com.syonet.domain.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClienteRepository implements
        PanacheRepositoryBase< Cliente, Integer >, IClienteRepository {

    @Override
    @Transactional
    public void save( Cliente cliente ) {
        Optional< Cliente > clienteOpt = findByIdOptional( cliente.getId() );

        clienteOpt.ifPresentOrElse( registro -> {
            registro.setDocumento( cliente.getDocumento() );
            registro.setEmail( cliente.getEmail() );
            registro.setNome( cliente.getNome() );
            this.persistAndFlush( registro );
        }, () -> {
            this.persist( cliente );
        } );
    }

    @Override
    public List< Cliente > listClienteByDocumento( String documento ) {
        return list( "documento = ?1", documento );
    }

    @Override
    public List< Cliente > listClienteByEmail( String email ) {
        return list( "email = ?1", email );
    }

    @Override
    public List< Cliente > listClienteByDocumentoAndEmail( String documento,
            String email ) {
        return list( "email = ?1 and documento = ?2", email, documento );
    }

}
