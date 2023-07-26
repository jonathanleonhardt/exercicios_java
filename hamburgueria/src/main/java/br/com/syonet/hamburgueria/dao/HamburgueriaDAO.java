package br.com.syonet.hamburgueria.dao;

import java.util.List;

import br.com.syonet.hamburgueria.domain.Hamburgueria;

public interface HamburgueriaDAO {

	void insert( Hamburgueria entity );
	void update( Hamburgueria entity );
	void delete( Hamburgueria entity );
	List< Hamburgueria > listAll();
	Hamburgueria findById( Integer id );

}
