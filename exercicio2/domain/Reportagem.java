package exercicio2.domain;

import java.util.List;

public class Reportagem {

	private String titulo;
	private String textoPublicacao;
	private List< String > autores;
	
	public Reportagem( String titulo, String textoPublicacao,
			List< String > autores ) {
		this.titulo = titulo;
		this.textoPublicacao = textoPublicacao;
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo( String titulo ) {
		this.titulo = titulo;
	}

	public String getTextoPublicacao() {
		return textoPublicacao;
	}

	public void setTextoPublicacao( String textoPublicacao ) {
		this.textoPublicacao = textoPublicacao;
	}

	public List< String > getAutores() {
		return autores;
	}

	public void setAutores( List< String > autores ) {
		this.autores = autores;
	}

	public void imprimeReportagem() {
		System.out.println(
			"-- Reportagem:" +
			"\nTitulo: " + this.titulo + 
			"\nTexto:" + this.textoPublicacao +
			"\nAutores: " + this.autores.toString()
		);
	}

}
