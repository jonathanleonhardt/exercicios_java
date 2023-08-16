package br.com.exemplo.api.exercicio.business;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.exemplo.api.exercicio.dao.CidadeDAO;
import br.com.exemplo.api.exercicio.domain.Cidade;
import br.com.exemplo.api.exercicio.enums.QueryParam;

public class CidadeBusiness {

	private static CidadeDAO dao = CidadeDAO.getInstance();

	private static CidadeBusiness instance;

	public static CidadeBusiness getInstance(){
		if ( instance == null ) {
			instance = new CidadeBusiness();
		}
		return instance;
	}

	public List< Cidade > listFiltered( Map< String , List< String > > filter ) {
		List< String > estados;
		List< String > regioes;
		if ( filter.containsKey( QueryParam.ESTADO.getQueryParamString() ) &&
			filter.containsKey( QueryParam.REGIAO.getQueryParamString() )) {
			estados = filter.get( QueryParam.ESTADO.getQueryParamString() );
			regioes = filter.get( QueryParam.REGIAO.getQueryParamString() );
			return listByEstadoAndRegiao( estados, regioes );
		} else if ( filter.containsKey( QueryParam.ESTADO.getQueryParamString() ) ) {
			estados = filter.get( QueryParam.ESTADO.getQueryParamString() );
			return listByEstado( estados );
		} else if ( filter.containsKey( QueryParam.REGIAO.getQueryParamString() ) ) {
			regioes = filter.get( QueryParam.REGIAO.getQueryParamString() );
			return listByRegiao( regioes );
			
		}
		return dao.listAll();
	}

	public List< Cidade > listAll() {
		return dao.listAll();
	}

	public void insert( Cidade cidade ) {
		dao.insert( cidade );
	}

	public void update( Cidade cidade ) {
		dao.update( cidade );
	}

	public void delete( Cidade cidade ) {
		dao.delete( cidade );
	}

	private List< Cidade > listByEstadoAndRegiao( List< String > estados,  List< String > regioes ) {
		return dao.listAll()
					.stream()
					.filter( cidade -> estados.contains( cidade.getEstado() ) )
					.filter( cidade -> regioes.contains( cidade.getRegiao() ) )
					.collect( Collectors.toList() );
	}

	private List< Cidade > listByEstado( List< String > estados ) {
		return dao.listAll()
					.stream()
					.filter( cidade -> estados.contains( cidade.getEstado() ) )
					.collect( Collectors.toList() );
	}

	private List< Cidade > listByRegiao( List< String > regioes ) {
		return dao.listAll()
					.stream()
					.filter( cidade -> regioes.contains( cidade.getRegiao() ) )
					.collect( Collectors.toList() );
	}

}
