package br.com.syonet.hamburgueria.dao.genericDAO;

import java.util.List;

import br.com.syonet.hamburgueria.domain.Hamburgueria;

public interface GenericDAO<T, R> {
	//T == Classe ou entidade
	//R == ID da entidade

	void insert( T entity );
	void update( T entity );
	void delete( T entity );
	List< T > listAll();
	T findById( R id );

	
}
