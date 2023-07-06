package exercicio2.domain;

public class ItemLivraria {

	private int id;
	private String titulo;
	private String data;
	private Float valor;

	public ItemLivraria( int id, String titulo, String data, Float valor ) {
		this.id = id;
		this.titulo = titulo;
		this.data = data;
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData( String data ) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor( Float valor ) {
		this.valor = valor;
	}

	public void imprimeItem() {
		System.out.println(
			"Titulo: " + this.titulo + 
			"\nValor: " + this.valor + 
			"\nData: " + this.data
		);
		System.out.println("Codigo:" + this.hashCode() );

	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

}
