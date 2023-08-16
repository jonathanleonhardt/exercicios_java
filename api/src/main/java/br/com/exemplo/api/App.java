package br.com.exemplo.api;

import com.google.gson.Gson;

import br.com.exemplo.api.exercicio.api.API;
import br.com.exemplo.api.exercicio.api.Router;
import br.com.exemplo.api.exercicio.business.CidadeBusiness;
import br.com.exemplo.api.exercicio.domain.Cidade;
import br.com.exemplo.api.exercicio.enums.HTTPMethod;

public class App {
	public static int port = 8080;
	public static CidadeBusiness business = CidadeBusiness.getInstance();
	public static Gson gson = new Gson();
	
	public static void main(String[] args) {
		new API( port ).createAPI( createRoutes() );;
	}

	private static Router createRoutes() {
		Router router = new Router();

		router.addRoute( "/cidade", HTTPMethod.GET, ( body, queryParams ) -> {
			if ( queryParams.isEmpty() ) {
				return gson.toJson( business.listAll() );
			}
			return gson.toJson( business.listFiltered( queryParams ) );
		});

		router.addRoute( "/cidade", HTTPMethod.POST, ( body, queryParams ) -> {
			Cidade possivelCidade = gson.fromJson( body , Cidade.class );
			business.insert( possivelCidade );
			return "Cidade criada";
		});

		router.addRoute( "/cidade", HTTPMethod.PUT, ( body, queryParams ) -> {
			Cidade possivelCidade = gson.fromJson( body , Cidade.class );
			business.update( possivelCidade );
			return "Cidade atualizada";
		});

		router.addRoute( "/cidade", HTTPMethod.DELETE, ( body, queryParams ) -> {
			Cidade possivelCidade = gson.fromJson( body , Cidade.class );
			business.delete( possivelCidade);
			return "Cidade deletada";
		});
		return router;
	}

	// 1 -  cria a api a partir de uma porta
	// 2 - adiciona este endpoint:
	//		/cidade
	//		GET
	// 		RETORNO DA API ( request ) -> { cidadeBusiness.listAll ou listFiltered }

	// adiciona este endpoint:
	//		/cidade
	//		POST
	// 		RETORNO DA API --> gson.toJson ( cidadeBusiness.insert )

	
}
