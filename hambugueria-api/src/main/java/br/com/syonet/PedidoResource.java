package br.com.syonet;

import br.com.syonet.domain.Pedido;
import br.com.syonet.domain.StatusEnum;
import br.com.syonet.service.PedidoService;
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

@Path( "/pedido" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class PedidoResource {

    @Inject
    PedidoService service;

    @GET
    public Response getByEmailDocumento(
            @QueryParam( "data" ) Long data,
            @QueryParam( "status" ) StatusEnum status ) {
        if ( data == null && status == null ) {
            return Response.noContent().build();
        }
        return Response.ok( service.getByDataStatus( data, status ) ).build();
    }

    @POST
    public Response post( Pedido pedido ) {
        try {
            service.create( pedido );
        } catch ( IllegalArgumentException e) {
            Response.status( 409, e.getMessage() ).build();
        }
        return Response.accepted().build();
    }

    @PUT
    public Response put( Pedido pedido ) {
        try {
            service.update( pedido );
        } catch ( IllegalArgumentException e) {
            Response.status( 400, e.getMessage() ).build();
        }
        return Response.accepted().build();
    }
}
