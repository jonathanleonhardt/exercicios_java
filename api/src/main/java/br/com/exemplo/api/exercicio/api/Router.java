package br.com.exemplo.api.exercicio.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.exemplo.api.exercicio.enums.HTTPMethod;

public class Router {

	private Map< String, Map< HTTPMethod, EndpointFunction > > routes = new HashMap<>();
	
	// metodo para adicionar as rotas
	public void addRoute( String endpoint, HTTPMethod metodo, EndpointFunction function ) {
		routes.computeIfAbsent( endpoint, k -> new HashMap<>() ).put( metodo, function );
	}

	// metodo pra 'direcionar' a request para a rota existente ou NAO
	public String route( String request ) {
		String[] partesRequest = request.split( " " );
		System.out.println( partesRequest[ 0 ] );
		System.out.println( partesRequest[ 1 ] );
		HTTPMethod metodohttp = HTTPMethod.valueOf( partesRequest[ 0 ] );
		String endpoint = partesRequest[ 1 ].indexOf( "?" ) > 0 ?
		partesRequest[ 1 ].substring( 0, partesRequest[ 1 ].indexOf( "?" ) ) : partesRequest[ 1 ];
		if ( request.contains( "Invalid request received." ) ) {
			return "Request chegou nula!";
		}
		String body = request.indexOf( "{" ) > 0 ?
		request.substring( request.indexOf( "{" ), request.indexOf( "}" ) + 1 ) : "";

		Map< HTTPMethod, EndpointFunction > metodoFuncaoMap = routes.get( endpoint );
		if ( metodoFuncaoMap != null ) {
			EndpointFunction funcao = metodoFuncaoMap.get( metodohttp );
			if ( funcao != null ) {
				return funcao.execute( body, extractQueryParameters( request ) );
			}

		}

		return "Endpoint não encontrado!";
	}

	private static Map< String, List< String > > extractQueryParameters( String request ) {
		Map< String, List< String > > queryParams = new HashMap<>();
		//   regiao = [ 'RS', 'PE' ]

		String[] parts = request.split( " " );
		if ( parts.length >= 2 ) {
			String url = parts[ 1 ];
			int queryStart = url.indexOf( '?' );
			if ( queryStart != -1 ) {
				String queryString = url.substring( queryStart + 1 );
				String[] paramPairs = queryString.split( "&" );
				for ( String paramPair : paramPairs ) {
					String[] keyValue = paramPair.split( "=" );
					if ( keyValue.length == 2 ) {
						String paramName = keyValue[ 0 ];
						String[] paramValues = keyValue[ 1 ]
								.replaceAll( "\\[|\\]", "" ).split( "," );
						queryParams.put( paramName,
								Arrays.asList( paramValues ) );
					}
				}
			}
		}

		return queryParams;
	}



}
