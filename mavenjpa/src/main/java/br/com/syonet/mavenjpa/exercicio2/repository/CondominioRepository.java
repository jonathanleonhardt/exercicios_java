package br.com.syonet.mavenjpa.exercicio2.repository;

import java.util.List;

import br.com.syonet.mavenjpa.exercicio2.domain.Condominio;
import br.com.syonet.mavenjpa.utils.JPAService;

public class CondominioRepository {

	private static JPAService jpa = JPAService.getInstance();

	public List< Condominio > listAllCondominios() {
		return jpa.runOperation( manager -> manager.createQuery(
				"select i from Condominio i",
				Condominio.class
			).getResultList() );
	}
	
}
