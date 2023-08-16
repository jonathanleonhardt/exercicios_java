package br.com.exemplo.api.exercicio.api;

import java.util.List;
import java.util.Map;

public interface EndpointFunction {
	String execute( String body, Map< String , List< String > > queryParams );
}

// 			NÃO VAMOS IMPLEMENTAR COM CLASS ASSIM: 
// class GetCidadesEndpointFunction implements EndpointFunction {

// 	@Override
// 	public String execute( String request ) {
// 		// TODO Auto-generated method stub
// 		throw new UnsupportedOperationException("Unimplemented method 'execute'");
// 	}

// }
