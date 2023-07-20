package br.com.syonet.hamburgueria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.syonet.hamburgueria.domain.Hamburgueria;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) {
		Hamburgueria objeto1 = new Hamburgueria();
		objeto1.setCnpj( "12345678912345" );
		objeto1.setName( "Jonathan Burguer" );

		Hamburgueria objeto2 = new Hamburgueria();
		objeto2.setCnpj( "12345678912344" );
		objeto2.setName( "Leonhardt Burguer" );

		EntityManagerFactory factory = Persistence.createEntityManagerFactory( "Hamburgueriajpa" );
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist( objeto1 );
		manager.persist( objeto2 );

		manager.getTransaction().commit();

		System.out.println("$$$ Resultado do select: ");
		System.out.println( manager.createQuery(
			"select h from Hamb h where h.name like '%Burguer'",
			Hamburgueria.class
		).getResultList() );

		factory.close();
		manager.close();

	}

}
