package br.com.syonet.quarkus.api;

import br.com.syonet.quarkus.exemploUsoPanache.PanacheRepository.DesenvolvedoresRepository;
import br.com.syonet.quarkus.repository.GreetingsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path( "/api" )
public class ApiStatusResource {

	// repository
	@Inject
	GreetingsRepository repository;

	@Inject
	DesenvolvedoresRepository devRepo;

	@GET
	@Path( "/status" )
	@Produces( MediaType.TEXT_PLAIN )
	public String hello() {
		return "App está no ar";
	}
	
}
