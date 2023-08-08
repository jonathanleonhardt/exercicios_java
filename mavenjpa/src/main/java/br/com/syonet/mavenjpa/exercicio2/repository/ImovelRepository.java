package br.com.syonet.mavenjpa.exercicio2.repository;

import java.util.List;

import br.com.syonet.mavenjpa.exercicio2.domain.Imovel;
import br.com.syonet.mavenjpa.utils.JPAService;

public class ImovelRepository {

	private static JPAService jpa = JPAService.getInstance();

	public List< Imovel > listAllByCondominio( Integer idCondominio ) {
		return jpa.runOperation( manager -> manager.createQuery(
				"select i from Imovel i where i.condominio = " + idCondominio,
				Imovel.class
			).getResultList() );
	}

}
