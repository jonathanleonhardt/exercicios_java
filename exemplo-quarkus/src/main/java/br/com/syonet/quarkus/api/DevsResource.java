package br.com.syonet.quarkus.api;

import br.com.syonet.quarkus.exemploUsoPanache.PanacheRepository.Desenvolvedor;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path( "/api" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class DevsResource {

	@GET
	@Path( "/dev" )
	public Response getDev() {
		return Response.accepted().build();
	}

	@POST
	@Path( "/dev" )
	public Response insertDev( Desenvolvedor dev ) {
		return null;
	}

	@PATCH
	@Path( "/dev" )
	public Response updateDev( Desenvolvedor dev ) {
		return null;
	}

	@DELETE
	@Path( "/dev" )
	public Response deleteDeb( Desenvolvedor dev ) {
		if ( dev.getId() == null ) {
			return Response.status( 404 ).build();
		}
		return Response.ok( "{ \"status\": \"registro deletado\" }" ).build();
	}
	
}
