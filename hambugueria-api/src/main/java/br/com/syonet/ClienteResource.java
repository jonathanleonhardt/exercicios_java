package br.com.syonet;

import br.com.syonet.domain.Cliente;
import br.com.syonet.service.ClienteService;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path( "/cliente" )
@RolesAllowed( "admin" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class ClienteResource {

    @Inject
    ClienteService service;

    @GET
    public Response getByEmailDocumento(
            @QueryParam( "email" ) String email,
            @QueryParam( "documento" ) String documento ) {
        if ( email == null && documento == null ) {
            return Response.noContent().build();
        }
        return Response.ok( service.getByEmailDocument( email, documento ) ).build();
    }

    @POST
    public Response post( Cliente cliente ) {
        try {
            service.create( cliente );
        } catch ( IllegalArgumentException e) {
            Response.status( 409, e.getMessage() ).build();
        }
        return Response.accepted().build();
    }

    @PUT
    public Response put( Cliente cliente ) {
        try {
            service.update( cliente );
        } catch ( IllegalArgumentException e) {
            Response.status( 400, e.getMessage() ).build();
        }
        return Response.accepted().build();
    }

}
