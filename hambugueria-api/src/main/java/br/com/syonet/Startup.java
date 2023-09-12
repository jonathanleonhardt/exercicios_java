package br.com.syonet;


import br.com.syonet.domain.Usuario;
import io.quarkus.runtime.StartupEvent;
import jakarta.inject.Singleton;
import jakarta.enterprise.event.Observes;

@Singleton
public class Startup {

    public void loadUsers( @Observes StartupEvent event ) {
        Usuario.deleteAll();
        Usuario.addUser( "admin", "admin", "admin" );
        Usuario.addUser( "jonathan", "jonathan", "dev");
    }
    
}
