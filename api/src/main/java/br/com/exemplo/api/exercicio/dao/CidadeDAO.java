package br.com.exemplo.api.exercicio.dao;

import java.util.List;

import br.com.exemplo.api.exercicio.domain.Cidade;
import br.com.exemplo.api.exercicio.utils.JPAService;

public class CidadeDAO {

	private static CidadeDAO instance;
	private static JPAService service = JPAService.getInstance();

	public static CidadeDAO getInstance() {
		if ( instance == null ) {
			instance = new CidadeDAO();
		}
		return instance;
	}

	public List< Cidade > listAll() {
		return service.runOperation( manager -> manager.createQuery(
			"select c from Cidade c",
			Cidade.class
		).getResultList() );
	}


	public void insert( Cidade cidade ) {
		service.runOperation( manager -> {
			manager.persist( cidade );
			return null;
		} );
	}

	public void update( Cidade cidade ) {
		service.runOperation( manager -> {
			manager.merge( cidade );
			return null;
		} );
	}

	public void delete( Cidade cidade ) {
		service.runOperation( manager -> {
			Cidade cidadeToRemove = manager.find( Cidade.class, cidade.getId() );
			manager.remove( cidadeToRemove );
			return null;
		} );
	}

}
