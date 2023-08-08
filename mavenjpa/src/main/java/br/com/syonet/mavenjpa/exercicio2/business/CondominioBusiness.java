package br.com.syonet.mavenjpa.exercicio2.business;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.syonet.mavenjpa.exercicio2.repository.CondominioRepository;
import br.com.syonet.mavenjpa.exercicio2.repository.ImovelRepository;
import br.com.syonet.mavenjpa.exercicio2.values.CondominioDTO;
import br.com.syonet.mavenjpa.exercicio2.values.ImovelDTO;

public class CondominioBusiness {

	private static Gson gson = new Gson();
	private static CondominioRepository condominioRepo = new CondominioRepository();
	private static ImovelRepository imovelRepo = new ImovelRepository();


	// - um método para retornar um string json dos condominios e seus imoveis;
	public String listImovelPorCondominio() {
		List< CondominioDTO > condominiosDTO = getCondominiosImoveisDTO();
		return gson.toJson( condominiosDTO );
	}

	private List< CondominioDTO > getCondominiosImoveisDTO() {
		return condominioRepo.listAllCondominios()
				.stream()
				.map( entity -> {
					List< ImovelDTO > imoveisDTO = getImoveisDTOByIdCondominio( entity.getId() );
					return new CondominioDTO.Builder()
								.withId( entity.getId() )
								.withNome( entity.getNome() )
								.withImoveis( imoveisDTO )
								.build(); } )
				.collect( Collectors.toList() );
	}

	private List< ImovelDTO > getImoveisDTOByIdCondominio( Integer idCondominio ) {
		return imovelRepo.listAllByCondominio( idCondominio )
				.stream()
				.map( imovel-> new ImovelDTO.Builder()
									.withId( imovel.getId() )
									.withDescricao( imovel.getDescricao() )
									.withValor( imovel.getValor() )
									.build() )
				.collect( Collectors.toList() );
	}


	// - um método que recebe um json de condomios e seus imoveis e irá salvar os registros no banco de dados.
	public List< CondominioDTO > convertJsonToListOfCondominiosDTO ( String json ) {
		Type listType = new TypeToken<List<CondominioDTO>>() {}.getType();
		return gson.fromJson(json, listType);
	}

	// - um método que retorna um json contendo somente condominio com mais de 3 imoveis.
	public String listCondominiosWithXImoveis( Integer numberOfImoveis ) {
		List< CondominioDTO > condominios = getCondominiosImoveisDTO();
		condominios = condominios.stream()
				.filter( condominio -> condominio.getImoveis().size() >= numberOfImoveis )
				.collect( Collectors.toList() );
		return gson.toJson( condominios );
	}


	// - um método que recebe um json em lista de condominios e seus imoveis, mas que retorna a lista de condominios com alugueis abaixo de X valor.
	public String listCondominioDentroDoOrcamento( String json, Float orcamento ) {
		Type listType = new TypeToken<List<CondominioDTO>>() {}.getType();
		List<CondominioDTO> condominios = gson.fromJson( json, listType );
		condominios = condominios.stream()
				.map( condominio -> {
					List< ImovelDTO > imoveis = condominio.getImoveis();
					imoveis = imoveis.stream()
							.filter( imovel -> imovel.getValor() <= orcamento )
							.collect( Collectors.toList() );
					condominio.setImoveis( imoveis );
					return condominio;
				})
				.filter( condominio -> !condominio.getImoveis().isEmpty() )
				.collect( Collectors.toList() );
		return gson.toJson( condominios );
	}

}
