package br.com.syonet.hamburgueria.dao;

import java.util.List;

import br.com.syonet.hamburgueria.databaseService.JPAService;
import br.com.syonet.hamburgueria.domain.Hamburgueria;

public class HamburgueriaDAOImpl implements HamburgueriaDAO {

	private static JPAService service = JPAService.getInstance();

	@Override
	public void insert( Hamburgueria entity ) {
		service.runOperation( manager -> {
			manager.persist( entity );
			return null;
		} );
	}

	@Override
	public void update( Hamburgueria entity ) {
		service.runOperation( manager -> {
			manager.merge( entity );
			return null;
		} );
	}

	@Override
	public void delete( Hamburgueria entity ) {
		service.runOperation( manager -> {
			manager.remove( entity );
			return null;
		} );
	}

	@Override
	public List< Hamburgueria > listAll() {
		return service.runOperation( manager -> manager.createQuery(
				"select h from Hamb h",
				Hamburgueria.class 
			).getResultList() );
	}

	@Override
	public Hamburgueria findById( Integer id ) {
		return service.runOperation( manager -> manager.createQuery(
				"select h from Hamb h where h.id = " + id,
				Hamburgueria.class 
			).getSingleResult() );
	}


}
