package exercicio2.domain;

public class Livro extends ItemLivraria {
	private String editora;
	
	public Livro( int id, String titulo, String data, Float valor, String editora ) {
		super( id, titulo, data, valor );
		this.editora = editora;
		
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora( String editora ) {
		this.editora = editora;
	}

	@Override
	public void imprimeItem() {
		System.out.println( "\n\n .:: LIVRO ::. " );
		super.imprimeItem();
	}

}
