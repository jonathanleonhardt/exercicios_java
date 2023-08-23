package br.com.syonet.quarkus.exemploUsoPanache.PanacheRepositoryBase;

import br.com.syonet.quarkus.exemploUsoPanache.PanacheRepository.Desenvolvedor;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.transaction.Transactional;

public class DevBaseRepository implements PanacheRepositoryBase< Integer, Desenvolvedor > {

	@Transactional
	public void deleteAllDevs() {
		this.deleteAll();
	}
	
}
