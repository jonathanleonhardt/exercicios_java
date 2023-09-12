package br.com.syonet.client;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.syonet.service.RickMortyService;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.Scheduled.ConcurrentExecution;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class TimerRickAndMorty {

    @Inject
    RickMortyService service;

    @Scheduled(
        concurrentExecution = ConcurrentExecution.SKIP,
        delayed = "1m",
        every = "1m",
        identity = "get-all-personagens"
    )
    public void timer() {
        try {
            log.infov( "Busca sendo realizada pela {0}, {1}, {2}", "Syonet", "Devclass", "Teste" );
            log.info( service.getAll() );
        } catch( Exception e ) {
            log.error( "Ocorreu um erro ao executar a busca de personagens", e);
        }

    }


    
}
