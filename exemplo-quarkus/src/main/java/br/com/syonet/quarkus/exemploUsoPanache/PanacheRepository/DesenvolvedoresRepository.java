package br.com.syonet.quarkus.exemploUsoPanache.PanacheRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.transaction.Transactional;

public class DesenvolvedoresRepository implements PanacheRepository< Desenvolvedor > {

	@Transactional
	public void deleteAllDevs() {
		this.deleteAll();
	}
	
}
