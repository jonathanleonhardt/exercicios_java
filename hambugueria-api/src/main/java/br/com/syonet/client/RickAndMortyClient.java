package br.com.syonet.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path( "/api/character/" )
@RegisterRestClient( configKey = "rickmorty-api" )
public interface RickAndMortyClient {
    
    @GET
    String getAll();

    // @GET
    // @Path( "{id}" )
    // List< CharacterDTO > getById( @PathParam( "id" ) Integer id );

}
