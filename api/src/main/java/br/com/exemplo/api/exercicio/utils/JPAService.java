package br.com.exemplo.api.exercicio.utils;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAService {

	private static JPAService instance;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory( "exercicioapi" );

	public static JPAService getInstance() {
		if ( instance == null ) {
			instance = new JPAService();
		}
		return instance;
	}

	public < T > T runOperation ( Function< EntityManager, T > function ) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			T retorno = function.apply( entityManager );
			return retorno;
		} finally {
			transaction.commit();
		}
	}

	public void closeAll() {
		factory.close();
	}

}