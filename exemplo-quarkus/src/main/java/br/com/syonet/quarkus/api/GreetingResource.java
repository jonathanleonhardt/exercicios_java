package br.com.syonet.quarkus;

import br.com.syonet.quarkus.repository.GreetingsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path( "/hello" )
public class GreetingResource {

	// repository
	@Inject
	GreetingsRepository repository;

	@GET
	@Produces( MediaType.TEXT_PLAIN )
	public String hello() {
		return "Hello from RESTEasy Reactive";
	}
	
}
