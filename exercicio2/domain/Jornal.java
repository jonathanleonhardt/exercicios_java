package exercicio2.domain;

import java.util.List;

public class Jornal extends ItemLivraria {

	private List< Reportagem > reportagens;

	public Jornal( int id, String titulo, String data, Float valor,
			List< Reportagem > reportagens ) {
		super( id, titulo, data, valor );
		this.reportagens = reportagens;
	}

	public List< Reportagem > getReportagens() {
		return reportagens;
	}

	public void setReportagens( List< Reportagem > reportagens ) {
		this.reportagens = reportagens;
	}

	@Override
	public void imprimeItem() {
		System.out.println( "\n\n .:: JORNAL ::. " );
		super.imprimeItem();
		this.reportagens.forEach( Reportagem::imprimeReportagem );
	}
	
}
